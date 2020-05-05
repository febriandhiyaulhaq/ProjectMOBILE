package com.example.holidayapi.view.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.holidayapi.country.CountryHolidaysItem;
import com.example.holidayapi.country.CountryResponse;
import com.example.holidayapi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<CountryHolidaysItem>> listDiscoverCountry = new MutableLiveData<ArrayList<CountryHolidaysItem>>();

    public void setCountryDiscover(String api_key, String country, String year) {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiCountry().getHolidays(api_key, country, year).enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                CountryResponse holidays = response.body();
                if (holidays != null && holidays.getHolidays() != null) {
                    ArrayList<CountryHolidaysItem> countryHolidaysItems = holidays.getHolidays().getHolidays();
                    listDiscoverCountry.postValue(countryHolidaysItems);

                }
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<CountryHolidaysItem>> getCountryDiscover(){
        return listDiscoverCountry;
    }

}
