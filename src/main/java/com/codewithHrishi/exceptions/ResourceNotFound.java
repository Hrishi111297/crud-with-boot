package com.codewithHrishi.exceptions;

public class ResourceNotFound extends RuntimeException {

	private String resource;
	private String resourceField;
	private long fieldId;

	public ResourceNotFound(String resource, String resourceField, long fieldId) {
		super(String.format("%s not found with % s with %s",resource,resourceField ,fieldId));
		this.resource = resource;
		this.resourceField = resourceField;
		this.fieldId = fieldId;
	}
	
	

}
