package com.example.holidayapi.tow;

import com.example.holidayapi.country.CountryHolidaysItem;

import java.util.ArrayList;

public interface MainTow {
    void onSucces(ArrayList<CountryHolidaysItem> holidaysItems);

    void onError(String errorMessage);

    void onFailure(String failureMessage);
}
