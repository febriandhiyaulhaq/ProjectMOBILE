package com.example.holidayapi.country;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Holidays{

	@SerializedName("holidays")
	private ArrayList<CountryHolidaysItem> holidays;

	@SerializedName("query")
	private Query query;

	public void setHolidays(ArrayList<CountryHolidaysItem> holidays){
		this.holidays = holidays;
	}

	public ArrayList<CountryHolidaysItem> getHolidays(){
		return holidays;
	}

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	@Override
 	public String toString(){
		return 
			"Holidays{" + 
			"holidays = '" + holidays + '\'' + 
			",query = '" + query + '\'' + 
			"}";
		}
}