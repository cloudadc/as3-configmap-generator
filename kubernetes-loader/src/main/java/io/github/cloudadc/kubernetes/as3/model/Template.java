package io.github.cloudadc.kubernetes.as3.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"class","action", "persist", "declaration"})
public class Template {
	
	@JsonProperty("class")
	private String class_;
	
	private String action;
	
	private Boolean persist;
	
	private Map<String, Object> declaration;
	
	public Template() {
		super();
	}

	public Template(String class_, String action, Boolean persist,  Map<String, Object> declaration) {
		super();
		this.class_ = class_;
		this.action = action;
		this.persist = persist;
		this.declaration = declaration;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Boolean getPersist() {
		return persist;
	}

	public void setPersist(Boolean persist) {
		this.persist = persist;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public  Map<String, Object> getDeclaration() {
		return declaration;
	}

	public void setDeclaration( Map<String, Object> declaration) {
		this.declaration = declaration;
	}

	@Override
	public String toString() {
		return "Template [class=" + class_ + ", action=" + action + ", persist=" + persist + ", declaration=" + declaration + "]";
	}

}
