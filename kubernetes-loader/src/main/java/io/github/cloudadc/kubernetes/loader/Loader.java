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
	
	static {
		System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
	}
	
	final CoreV1Api api;
	
	protected Loader() throws  IOException {

		String kubeConfigPath = System.getenv("HOME") + "/.kube/config";
		ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
		Configuration.setDefaultApiClient(client);
		api = new CoreV1Api();
	}
	
	public CoreV1Api api() {
		return api;
	}

	public void loadConfigmap() throws ApiException  {
		
		V1ConfigMap cm = api.readNamespacedConfigMap("cm-cistest", "f5-hub-1", null, null, null);
		
		System.out.println(cm.getData().get("template"));
	}
	
	
	
	public static Loader create() throws IOException {
		return new Loader();
	}


	public static void main(String[] args) throws IOException, ApiException {

		Loader loader = Loader.create();
		loader.loadConfigmap();
	
		System.out.println();
	}

}
