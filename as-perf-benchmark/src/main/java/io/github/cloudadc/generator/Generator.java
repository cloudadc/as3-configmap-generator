package io.github.cloudadc.generator;

public interface Generator {
	
	public String deployment();
	
	public String configmap();
	
	public String ingress();

}
