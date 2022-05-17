package io.github.cloudadc.generator;

import static io.github.cloudadc.generator.FileLoader.load;

import java.io.IOException;
import java.util.UUID;

import io.github.cloudadc.config.Config;

public class AS3Generator extends AbstractGenerator {

	public AS3Generator(Config config) {
		super(config);
	}

	@Override
	public void generateHeader() throws IOException {

		String starter = load("as3.starter");
		starter = starter.replaceAll(REPLACEMENT_AS3_VERSION, config.getAs3Version()).replaceAll(REPLACEMENT_AS3_ID, UUID.randomUUID().toString());
		as3Buffer.append(starter).append("\n");
	}

	@Override
	public void generateContent() throws IOException {

		String content = load("as3.content");
		
		boolean isFirst = true;
		
		for (int i = 0 ; i < config.getAppCount() ; i ++) {
			
			String tenantName = config.getNamespacePrefix() + (i +1);
			String app = "app-" + (i+1);
			String tenant = content.replaceAll(REPLACEMENT_AS3_TENANT, tenantName).replaceAll(REPLACEMENT_AS3_APP, app).replaceAll(REPLACEMENT_AS3_VS_IP, config.ip()).replaceAll(REPLACEMENT_AS3_MEMBER_IP, config.memberIp());
			
			if(isFirst) {
				isFirst = false;
				as3Buffer.append(tenant);
			} else {
				as3Buffer.append(",").append("\n").append(tenant);
			}
		}
		
	}

	@Override
	public void generateFoot() throws IOException {

		String footer = load("as3.footer");
		as3Buffer.append("\n").append(footer);
	}

}
