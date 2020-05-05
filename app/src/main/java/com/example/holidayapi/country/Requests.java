package com.example.holidayapi.country;

import com.google.gson.annotations.SerializedName;

public class Requests{

	@SerializedName("available")
	private Object available;

	@SerializedName("resets")
	private Object resets;

	@SerializedName("used")
	private Object used;

	public void setAvailable(Object available){
		this.available = available;
	}

	public Object getAvailable(){
		return available;
	}

	public void setResets(Object resets){
		this.resets = resets;
	}

	public Object getResets(){
		return resets;
	}

	public void setUsed(Object used){
		this.used = used;
	}

	public Object getUsed(){
		return used;
	}

	@Override
 	public String toString(){
		return 
			"Requests{" + 
			"available = '" + available + '\'' + 
			",resets = '" + resets + '\'' + 
			",used = '" + used + '\'' + 
			"}";
		}
}