package com.fv.api.dto;

public class Request {
	private String apiKey;
	String countryCode; 
    String deviceType;
    String apiVersion;
    
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	 public String getDeviceType() {  
	        return deviceType;  
	    }  
	  
	    public void setDeviceType(String deviceType) {  
	        this.deviceType = deviceType;  
	    } 
	    
	    public String getApiVersion() {  
	        return apiVersion;  
	    }  
	  
	    public void setApiVersion(String apiVersion) {  
	        this.apiVersion = apiVersion;  
	    } 
	    
	
		
}
