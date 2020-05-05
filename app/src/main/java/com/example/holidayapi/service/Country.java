package com.example.holidayapi.service;

import com.example.holidayapi.country.CountryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Country {
    @GET("v1/holidays")
    Call<CountryResponse> getHolidays(@Query("api_key") String api_key,
                                      @Query("country") String country,
                                      @Query("year") String year);
}
