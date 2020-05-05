package com.example.holidayapi.country;

import com.google.gson.annotations.SerializedName;

public class CountryResponse {

	@SerializedName("envelope")
	private Envelope envelope;

	@SerializedName("holidays")
	private Holidays holidays;

	@SerializedName("availableFilters")
	private Filters availableFilters;

	@SerializedName("requests")
	private Requests requests;

	@SerializedName("message")
	private String message;

	@SerializedName("errors")
	private Object errors;

	@SerializedName("status")
	private int status;

	public void setEnvelope(Envelope envelope){
		this.envelope = envelope;
	}

	public Envelope getEnvelope(){
		return envelope;
	}

	public void setHolidays(Holidays holidays){
		this.holidays = holidays;
	}

	public Holidays getHolidays(){
		return holidays;
	}

	public void setAvailableFilters(Filters availableFilters){
		this.availableFilters = availableFilters;
	}

	public Filters getAvailableFilters(){
		return availableFilters;
	}

	public void setRequests(Requests requests){
		this.requests = requests;
	}

	public Requests getRequests(){
		return requests;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setErrors(Object errors){
		this.errors = errors;
	}

	public Object getErrors(){
		return errors;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"CountryDiscoverResponse{" + 
			"envelope = '" + envelope + '\'' + 
			",holidays = '" + holidays + '\'' + 
			",availableFilters = '" + availableFilters + '\'' + 
			",requests = '" + requests + '\'' + 
			",message = '" + message + '\'' + 
			",errors = '" + errors + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}