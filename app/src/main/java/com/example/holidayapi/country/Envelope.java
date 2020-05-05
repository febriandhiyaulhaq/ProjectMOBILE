package com.example.holidayapi.country;

import com.google.gson.annotations.SerializedName;

public class Envelope{

	@SerializedName("remote_ip")
	private String remoteIp;

	@SerializedName("api_key")
	private String apiKey;

	@SerializedName("signature")
	private String signature;

	@SerializedName("request_url")
	private String requestUrl;

	public void setRemoteIp(String remoteIp){
		this.remoteIp = remoteIp;
	}

	public String getRemoteIp(){
		return remoteIp;
	}

	public void setApiKey(String apiKey){
		this.apiKey = apiKey;
	}

	public String getApiKey(){
		return apiKey;
	}

	public void setSignature(String signature){
		this.signature = signature;
	}

	public String getSignature(){
		return signature;
	}

	public void setRequestUrl(String requestUrl){
		this.requestUrl = requestUrl;
	}

	public String getRequestUrl(){
		return requestUrl;
	}

	@Override
 	public String toString(){
		return 
			"Envelope{" + 
			"remote_ip = '" + remoteIp + '\'' + 
			",api_key = '" + apiKey + '\'' + 
			",signature = '" + signature + '\'' + 
			",request_url = '" + requestUrl + '\'' + 
			"}";
		}
}