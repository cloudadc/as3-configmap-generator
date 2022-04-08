package io.github.cloudadc.generator;

import java.io.IOException;

import io.github.cloudadc.config.Config;
import io.github.cloudadc.config.GeneratorFailedException;

public abstract class AbstractGenerator implements Generator {
	
	protected Config config;
	
	protected StringBuffer deploymentBuffer;
	
	protected StringBuffer configmapBuffer;
	
	protected StringBuffer ingressBuffer;
	
	protected StringBuffer as3Buffer;
	
	public AbstractGenerator(Config config) {
		this.config = config;
		this.deploymentBuffer = new StringBuffer();
		this.configmapBuffer = new StringBuffer();
		this.ingressBuffer = new StringBuffer();
		this.as3Buffer = new StringBuffer();
		try {
			generateHeader();
			generateContent();
			generateFoot();
		} catch (IOException e) {
			throw new GeneratorFailedException(e);
		}
	}

	protected Config getConfig() {
		return config;
	}

	protected StringBuffer getDeploymentBuffer() {
		return deploymentBuffer;
	}

	protected StringBuffer getConfigmapBuffer() {
		return configmapBuffer;
	}

	protected StringBuffer getIngressBuffer() {
		return ingressBuffer;
	}

	@Override
	public String deployment() {
		return this.deploymentBuffer.toString();
	}

	@Override
	public String configmap() {
		return this.configmapBuffer.toString();
	}

	@Override
	public String ingress() {
		return this.ingressBuffer.toString();
	}

	@Override
	public String as3() {
		return this.as3Buffer.toString();
	}

	public abstract void generateHeader() throws IOException;
	
	public abstract void generateContent() throws IOException;
	
	public abstract void generateFoot() throws IOException;
	
}
