package io.github.cloudadc.generator;

import static io.github.cloudadc.generator.FileLoader.load;

import java.io.IOException;

import io.github.cloudadc.config.Config;


public class CIS20HubModeGenerator extends AbstractGenerator {
	
	

	public CIS20HubModeGenerator(Config config) {
		super(config);
	}

	@Override
	public void generateHeader() throws IOException {
		
		String hub_starter = load("cis-2.0-hub.starter");
		hub_starter = hub_starter.replaceAll("REPLACEMENT_CM_AS_VERSION", config.getAs3Version());
		configmapBuffer.append(hub_starter).append("\n");
	}

	@Override
	public void generateContent() throws IOException {
		
		String app_namespace = load("app.namespace");
		String app_deployment = load("app.deployment");
		String app_service = load("app.service");
		String hub_content = load("cis-2.0-hub.content");

		boolean isFirst = true;
		for (int i = 0 ; i < config.getAppCount() ; i ++) {
		
			String ns = config.getNamespacePrefix() + (i +1);
			String nsContent = app_namespace.replaceAll("REPLACEMENT_NAMESPACE", ns).replaceAll("REPLACEMENT_ZONE", "cistest");
			deploymentBuffer.append(nsContent).append("\n").append("---").append("\n");
			for (int j = 0 ; j < config.getAppPerNamespace() ; j ++) {
				i++;
				String app = "app-" + (j+1);
				String deployContent = app_deployment.replaceAll("REPLACEMENT_NAMESPACE", ns)
						                             .replaceAll("REPLACEMENT_APP_NAME", app)
						                             .replaceAll("REPLACEMENT_BACKEND_IMAGE", config.getAppImage())
						                             .replaceAll("REPLACEMENT_BACKEND_PORT", String.valueOf(config.getAppImageContainerPort()));
				deploymentBuffer.append(deployContent).append("\n").append("---").append("\n");
				String svcContent = app_service.replaceAll("REPLACEMENT_NAMESPACE", ns).replaceAll("REPLACEMENT_APP_NAME", app).replaceAll("REPLACEMENT_SERVICE_NAME", "app-svc-" + (j +1));
				deploymentBuffer.append(svcContent).append("\n").append("---").append("\n");
				
				String cm = hub_content.replaceAll("REPLACEMENT_NAMESPACE", ns)
						               .replaceAll("REPLACEMENT_APP_NAME", app)
						               .replaceAll("REPLACEMENT_BACKEND_PORT", String.valueOf(config.getAppImageContainerPort()))
						               .replaceAll("REPLACEMENT_APP_VS_IP", config.ip());
				if(isFirst) {
					isFirst = false;
				} else {
					configmapBuffer.append(",").append("\n");
				}
				configmapBuffer.append(cm);
				
				if(i == config.getAppCount()) {
					break;
				}
			}
			i--;
		}
	}

	@Override
	public void generateFoot() throws IOException {

		String hub_footer = load("cis-2.0-hub.footer");
		configmapBuffer.append("\n").append(hub_footer);
	}

}
