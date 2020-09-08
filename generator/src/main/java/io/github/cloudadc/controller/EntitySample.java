package io.github.cloudadc.controller;

public class EntitySample {
	
	private int id;
	
	private String name;
	
	private String notes;
	
	private int value;
	
	private String path;
	
	private Boolean allow;

	public EntitySample(int id, String name, String notes, int value, String path, Boolean allow) {
		super();
		this.id = id;
		this.name = name;
		this.notes = notes;
		this.value = value;
		this.path = path;
		this.allow = allow;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getAllow() {
		return allow;
	}

	public void setAllow(Boolean allow) {
		this.allow = allow;
	}

}
