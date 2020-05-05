package com.example.holidayapi.tow;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.holidayapi.country.CountryHolidaysItem;
import com.example.holidayapi.country.CountryResponse;
import com.example.holidayapi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tow {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<CountryHolidaysItem>> listDiscoverCountry = new MutableLiveData<ArrayList<CountryHolidaysItem>>();

    private Context context;
    private MainTow mainTow;

    public Tow(Context context, MainTow mainTow){
        this.context = context;
        this.mainTow = mainTow;
    }
    public void loadInstitusi(String api_key, String country, String year){
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
                else {
                    mainTow.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {
                mainTow.onFailure(t.getMessage());
            }
        });

    }
}
