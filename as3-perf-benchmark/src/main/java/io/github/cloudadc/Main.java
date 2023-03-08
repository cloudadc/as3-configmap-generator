package io.github.cloudadc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cloudadc.config.Config;
import io.github.cloudadc.config.ConfigBuilder;
import io.github.cloudadc.generator.AS3Generator;
import io.github.cloudadc.generator.CISHub291ModeGenerator;
import io.github.cloudadc.generator.CISHubModeGenerator;
import io.github.cloudadc.generator.Generator;

import static io.github.cloudadc.config.Mode.CIS_20_AS_318_HUB;;;


@SuppressWarnings("unused")
@SpringBootApplication
public class Main implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("CIS Performance Benchmark Generator Starting");
				
		Config config = ConfigBuilder.instance().load(args).build();
		
		log.info("mode: " + config.getMode());
		
		Generator generator = null;
		
		switch(config.getMode()) {
		
		    case CIS_291_AS_336_HUB:
			    generator = new CISHub291ModeGenerator(config);
		        break;
		    case CIS_20_AS_318_HUB :
			    generator = new CISHubModeGenerator(config);
			    break;
		    case CIS_280_AS_330_HUB:
		    	generator = new CISHubModeGenerator(config);
			    break;
		    case CIS_281_AS_330_HUB:
		    	generator = new CISHubModeGenerator(config);
			    break;
		    case AS_318 :
		    	generator = new AS3Generator(config);
		    	break;
			default:
				generator = null;
				break;
		}
		
		
		if(null != generator && generator.deployment().length() > 0) {
			generate(config.getDeployFile(), generator.deployment());			
		}
		
		if(null != generator && generator.configmap().length() > 0) {
			generate(config.getConfigmapFile(), generator.configmap());	
		}
		
		if(null != generator && generator.as3().length() > 0) {
			generate("declaration.json", generator.as3());	
			String cm = "declaration.json";
		}
		
		log.info("CIS Performance Benchmark Generator End");
	}
	
	private void generate(String name, String content) throws IOException {

		log.info("Generating to " + name);
		if (Files.exists(Paths.get(name))) {
			Files.delete(Paths.get(name));  
		}
		Files.createFile(Paths.get(name));
		Files.write(Paths.get(name), content.getBytes(), StandardOpenOption.APPEND);
	}

	protected void execute(String[] args) throws Exception {

		int count = 3;
		String deploy = "deploy.yaml";
		String configmap = "configmap.yaml";
		String ingress = "ingress.yaml";
		String backend = "cloudadc/cafe:1.0";
		String net = "10.1.10.0/24";
		int ip_start = 3;
		boolean isSingleNamsespace = false;
		String cisVersion = "";
		
		if(args.length < 2) {
			StringBuffer sb = new StringBuffer();
			sb.append("Invalid parameters").append("\n");
			sb.append("Run with: --count <COUNT> --deploy <DEPLOYMENT NAME> --configmap <CONFIGMAP NAME> --backend <IMAGE NAME> --net <VS ADDR> --ipstart <IP START> --single <true/false>").append("\n");
			sb.append("      eg: --count 20 --deploy deploy.yaml --configmap configmap.yaml --ingress ingress.yaml --backend 'cloudadc/cafe:1.0' --net '10.1.10.0/24' --ipstart 3 --single false");
			throw new RuntimeException(sb.toString());
		}
		
		for(int i = 0 ; i < args.length ; i++) {
			
			if(args[i].equals("--count")) {
				count = Integer.parseInt(args[++i]);
			} else if(args[i].equals("--deploy")) {
				deploy = args[++i];
			} else if(args[i].equals("--configmap")) {
				configmap = args[++i];
			} else if(args[i].equals("--backend")) {
				backend = args[++i];
			} else if(args[i].equals("--net")) {
				net = args[++i];
			} else if(args[i].equals("--ipstart")) {
				ip_start = Integer.parseInt(args[++i]);
			} else if(args[i].equals("--ingress")) {
				ingress = args[++i];
			} else if(args[i].equals("--single")) {
				isSingleNamsespace = Boolean.parseBoolean(args[++i]);
			} else if(args[i].equals("--cis-version")) {
				cisVersion = args[++i];
				if(cisVersion.equals("2.0") || cisVersion.equals("2.1") || cisVersion.equals("2.2") || cisVersion.equals("2.3") || cisVersion.equals("2.4") || cisVersion.equals("2.5") || cisVersion.equals("2.6")) {
					System.out.println("CIS Version is");
				}
			}

		}
		
		
		if(!net.endsWith(".0/24")) {
			throw new RuntimeException("Current only support /24 network");
		}
		
		String net_prefix = net.substring(0, net.length() - 5);
		boolean first = true;
		int start = 100;
		
		if(cisVersion.equals("2.0")) {
			
		} else if(isSingleNamsespace) {
			
			String ns = "cistestzone1";
			boolean firstCM = true;
						
		
			String cmStart = getResourceFileAsString("cmsingle.start"); 
			cmStart = cmStart.replaceAll("REPLACEMENT_NAMESPACE", ns); 
			StringBuffer sb = new StringBuffer(); 
			sb.append(cmStart);
			
			
			for (int i = 0 ; i < count ; i ++) {
				
				String raw = getResourceFileAsString("deploysingle.yaml");
				raw = raw.replaceAll("REPLACEMENT_NAMESPACE", ns);
				raw = raw.replaceAll("REPLACEMENT_BACKEND_IMAGE", backend);
				String app = "app-" +  String.valueOf(1 + i);
				String svc = "app-svc-" +  String.valueOf(1 + i);
				raw = raw.replaceAll("REPLACEMENT_APP_NAME", app);
				raw = raw.replaceAll("REPLACEMENT_SVC_NAME", svc);
				
				if(first) {
					first = false;
					if (Files.exists(Paths.get(deploy))) {
						Files.delete(Paths.get(deploy));  
					}
					Files.createFile(Paths.get(deploy));
					
					if (Files.exists(Paths.get(configmap))) {
						Files.delete(Paths.get(configmap));
					}
					Files.createFile(Paths.get(configmap));
				} else {
					Files.write(Paths.get(deploy), "---\n".getBytes(), StandardOpenOption.APPEND);
					//Files.write(Paths.get(configmap), "---\n".getBytes(), StandardOpenOption.APPEND);
				}
				
				Files.write(Paths.get(deploy), raw.getBytes(), StandardOpenOption.APPEND);
				Files.write(Paths.get(deploy), "\n".getBytes(), StandardOpenOption.APPEND);
				
				//configmap
				String cm = getResourceFileAsString("cmsingle.content");				
				cm = cm.replaceAll("REPLACEMENT_NAMESPACE", ns);
				cm = cm.replaceAll("REPLACEMENT_SVC_NAME", svc);
				String vip = net_prefix + "." + (i + ip_start);
				cm = cm.replaceAll("REPLACEMENT_BIGIP_VS_IP_ADDR", vip);
		
				if(firstCM) {
					firstCM = false;
					sb.append("\n").append(cm);
				} else {
					sb.append(",").append("\n").append(cm);
				}
			
			}
			
			
			 
			 String cmEnd = getResourceFileAsString("cmsingle.end");
			 sb.append("\n").append(cmEnd); 
			 Files.write(Paths.get(configmap),
			 sb.toString().getBytes());
			 
			
		} else {
			
			/*
			 *  Used in CIS 2.0
			 *  
			 * boolean firstCM = true; 
			 * String cmStart = getResourceFileAsString("cm.start");
			 * StringBuffer sb = new StringBuffer(); 
			 * sb.append(cmStart);
			 * 
			 * String cmEnd = getResourceFileAsString("cm.end");
			 * sb.append("\n").append(cmEnd);
			 */
					
			for (int i = 0 ; i < count ; i ++) {
					
				String ns = "perftestzone1" + String.valueOf(start + i);
				
				if(first) {
					first = false;
					if (Files.exists(Paths.get(deploy))) {
						Files.delete(Paths.get(deploy));  
					}
					Files.createFile(Paths.get(deploy));
					
					if (Files.exists(Paths.get(ingress))) {
						Files.delete(Paths.get(ingress));
					}
					Files.createFile(Paths.get(ingress));
					
					if (Files.exists(Paths.get(configmap))) {
						Files.delete(Paths.get(configmap));
					}
					Files.createFile(Paths.get(configmap));
				} else {
					Files.write(Paths.get(deploy), "---\n".getBytes(), StandardOpenOption.APPEND);
					Files.write(Paths.get(ingress), "---\n".getBytes(), StandardOpenOption.APPEND);
					Files.write(Paths.get(configmap), "---\n".getBytes(), StandardOpenOption.APPEND);
				}
				
				// append to deploy.yaml
				String raw = getResourceFileAsString("deploy.yaml");
				raw = raw.replaceAll("REPLACEMENT_NAMESPACE", ns);
				raw = raw.replaceAll("REPLACEMENT_BACKEND_IMAGE", backend);

				if(i % 3 == 0) {
					raw = raw.replaceAll("REPLACEMENT_ZONE", "zone_1");
				} else if(i % 3 == 1) {
					raw = raw.replaceAll("REPLACEMENT_ZONE", "zone_2");
				} if(i % 3 == 2) {
					raw = raw.replaceAll("REPLACEMENT_ZONE", "zone_3");
				}
				Files.write(Paths.get(deploy), raw.getBytes(), StandardOpenOption.APPEND);
				Files.write(Paths.get(deploy), "\n".getBytes(), StandardOpenOption.APPEND);
				
				// append to ingress.yaml
				String ingressraw = getResourceFileAsString("ingress.yaml");
				ingressraw  = ingressraw.replaceAll("REPLACEMENT_NAMESPACE", ns);
				Files.write(Paths.get(ingress), ingressraw.getBytes(), StandardOpenOption.APPEND);
				Files.write(Paths.get(ingress), "\n".getBytes(), StandardOpenOption.APPEND);
				
				
				// append to configmap.yaml
				String cm = getResourceFileAsString("cm.yaml");
				cm = cm.replaceAll("REPLACEMENT_NAMESPACE", ns);
				String vip = net_prefix + "." + (i + ip_start);
				cm = cm.replaceAll("REPLACEMENT_BIGIP_VS_IP_ADDR", vip);
				Files.write(Paths.get(configmap), cm.getBytes(), StandardOpenOption.APPEND);
				Files.write(Paths.get(configmap), "\n".getBytes(), StandardOpenOption.APPEND);	
			}
			
			
			System.out.println("Generating ingress to " + ingress);
			

		}
		
		System.out.println("Generating K8S deployments to " + deploy);
		System.out.println("Generating AS3 configmap to " + configmap);
	}

	static String getResourceFileAsString(String fileName) throws IOException {
		
		
		String content = Files.readString(Paths.get("template", fileName), StandardCharsets.US_ASCII);
		
		if(content == null || content.length() == 0) {
			throw new RuntimeException(fileName + " not exist under template");
		}
	    
		return content;
	}
	
	

	
}
