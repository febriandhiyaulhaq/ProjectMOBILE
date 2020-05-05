package com.example.holidayapi.country;

import com.google.gson.annotations.SerializedName;

public class CountryHolidaysItem {

	@SerializedName("date")
	private String date;

	@SerializedName("country")
	private String country;

	@SerializedName("public")
	private boolean jsonMemberPublic;

	@SerializedName("start")
	private String start;

	@SerializedName("name")
	private String name;

	@SerializedName("end")
	private String end;

	@SerializedName("type")
	private String type;

	@SerializedName("substitute")
	private boolean substitute;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setJsonMemberPublic(boolean jsonMemberPublic){
		this.jsonMemberPublic = jsonMemberPublic;
	}

	public boolean isJsonMemberPublic(){
		return jsonMemberPublic;
	}

	public void setStart(String start){
		this.start = start;
	}

	public String getStart(){
		return start;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEnd(String end){
		this.end = end;
	}

	public String getEnd(){
		return end;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setSubstitute(boolean substitute){
		this.substitute = substitute;
	}

	public boolean isSubstitute(){
		return substitute;
	}

	@Override
 	public String toString(){
		return 
			"HolidaysItem{" + 
			"date = '" + date + '\'' + 
			",country = '" + country + '\'' + 
			",public = '" + jsonMemberPublic + '\'' + 
			",start = '" + start + '\'' + 
			",name = '" + name + '\'' + 
			",end = '" + end + '\'' + 
			",type = '" + type + '\'' + 
			",substitute = '" + substitute + '\'' + 
			"}";
		}
}