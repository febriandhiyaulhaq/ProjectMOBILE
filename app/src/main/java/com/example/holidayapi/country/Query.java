package com.example.holidayapi.country;

import com.google.gson.annotations.SerializedName;

public class Query{

	@SerializedName("country")
	private String country;

	@SerializedName("year")
	private String year;

	@SerializedName("api_key")
	private String apiKey;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setApiKey(String apiKey){
		this.apiKey = apiKey;
	}

	public String getApiKey(){
		return apiKey;
	}

	@Override
 	public String toString(){
		return 
			"Query{" + 
			"country = '" + country + '\'' + 
			",year = '" + year + '\'' + 
			",api_key = '" + apiKey + '\'' + 
			"}";
		}
}