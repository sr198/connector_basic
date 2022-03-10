package com.srijan.connectors.pooling;

import java.util.Map;

public class SearchDocument {
	
	private String id;
	
	private String name;
	
	private String revision;
	
	private Map<String, String> propertyMap;
	
	public SearchDocument( String id, String name, String revision, Map<String, String> allProps )
	{
		this.setid(id);
		this.setname(name);
		this.setrevision(revision);
		this.propertyMap = allProps;
	}
	
	

	public String getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getrevision() {
		return this.revision;
	}

	public void setrevision(String revision) {
		this.revision = revision;
	}

	public Map<String, String> getPropertyMap() {
		return this.propertyMap;
	}

	public void setPropertyMap(Map<String, String> propertyMap) {
		this.propertyMap = propertyMap;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}
	
	public String toString()
	{
		return "ID: " + id  +"\n" +
				"Name: " + name + "\n"+
				"Revision: " + revision + "\n"+
				((propertyMap != null)? "Props: " + propertyMap.toString() : "") ;
	}

}
