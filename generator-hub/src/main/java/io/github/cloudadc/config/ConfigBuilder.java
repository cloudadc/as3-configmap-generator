package io.github.cloudadc.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.util.SubnetUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigBuilder {
	
	private Config config ; 
	
	public static ConfigBuilder instance() {
		return new ConfigBuilder();
	}
	
	public Boolean isValidCIDR(String subnet) {

		// Base on "http://www.faqs.org/rfcs/rfc1519.html"
		Pattern pattern = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])(\\/(\\d|[1-2]\\d|3[0-2]))?$");
		
		Matcher matcher = pattern.matcher(subnet);
		
		return matcher.find();		
	}
	
	public String[] addressLists(String subnet) {
		SubnetUtils utils = new SubnetUtils(subnet);
		return utils.getInfo().getAllAddresses();
	}
	
	public Config build() {
		return this.config;
	}
	
	public ConfigBuilder load(String... args)  {
		
		if(!Files.exists(Paths.get("config.json")) && args.length == 0) {
			throw new RuntimeException("Either pass 'config.json' via args, or put to app home");
		}
		
		String config;
		try {
			config = getResourceFileAsString("config.json");
			
			if(args.length >= 1) {
				config = getResourceFileAsString(args[0]);
			}
		} catch (IOException e) {
			throw new InvalidConfigExcaption(e);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.config = mapper.readValue(config.getBytes(), Config.class);
		} catch (IOException e) {
			throw new InvalidConfigExcaption(e);
		}
		
		// validate cidr
		if(!isValidCIDR(this.config.getSubnet())) {
			throw new InvalidConfigExcaption("Configuration 'subnet' is not valid");
		}
		
		this.config.setAddresses(this.addressLists(this.config.getSubnet()));
		if(this.config.getAddresses().length < this.config.getAppCount()) {
			throw new InvalidConfigExcaption("Configuration is not valid, 'subnet' defined addresses less than the app count 'appCount'");
		}
		
		if(this.config.getAppPerNamespace() > this.config.getAppCount()) {
			throw new InvalidConfigExcaption("Configuration is not valid, app per namespace should less than the app count");
		}
		
		if(this.config.getAppPerNamespace() < 1) {
			this.config.setAppPerNamespace(1);
		}
		
		//validate as schema version
		boolean inValid = true;
		for(int i = 0 ; i < ASSchemaVersion.values().length ; i ++) {
			if(ASSchemaVersion.values()[i].version.equals(this.config.getAs3Version())) {
				inValid = false;
				break;
			}
		}
		
		if(inValid) {
			throw new InvalidConfigExcaption("Configuration 'as3Version' is not support");
		}
		
		if(this.config.getNamespacePrefix().length() < 4) {
			this.config.setNamespacePrefix("cistest");
		}
		
		
		return this;
	}
	
	public String getResourceFileAsString(String fileName) throws IOException {
		
		
		String content = Files.readString(Paths.get(fileName), StandardCharsets.US_ASCII);
		
		if(content == null || content.length() == 0) {
			throw new RuntimeException(fileName + " not exist under template");
		}
	    
		return content;
	}

}
