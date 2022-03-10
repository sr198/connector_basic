package com.srijan.connectors.pooling;

public class IdentifierDocument {
	
	private String id;
	
	public IdentifierDocument( String id )
	{
		this.id = id;
	}
	
	public String getDocumentIdentifier()
	{
		return id;
	}
	
	public String toString()
	{
		return "ID: " + id;
	}

}
