package io.github.cloudadc.kubernetes.loader;

import java.io.FileReader;
import java.io.IOException;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;

public class Loader {
	
	final CoreV1Api api;
	
	
	protected Loader() throws  IOException {
		String kubeConfigPath = System.getenv("HOME") + "/.kube/config";
		ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
		Configuration.setDefaultApiClient(client);
		this.api = new CoreV1Api();
	}
	
	public void loadConfigmap() throws ApiException {
		V1ConfigMap cm = api.readNamespacedConfigMap("cm-cistest", "f5-hub-1", "true");
		
		System.out.println(cm);
	}
	
	
	
	public static Loader create() throws IOException {
		return new Loader();
	}
	
	

	public static void main(String[] args) throws IOException, ApiException {

//		Loader loader = Loader.create();
//		loader.loadConfigmap();
		
		String kubeConfigPath = System.getenv("HOME") + "/.kube/config";
		ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
		Configuration.setDefaultApiClient(client);
		CoreV1Api api = new CoreV1Api();
		V1ConfigMap cm = api.readNamespacedConfigMap("cm-cistest", "f5-hub-1", null);
		
		
		//System.out.println();
	}

}
