package io.github.cloudadc.controller;

public class EntityGeneratorApp {
	
	private String appName;
	
	private String content;

	public EntityGeneratorApp(String appName, String content) {
		super();
		this.appName = appName;
		this.content = content;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
