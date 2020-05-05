package com.example.holidayapi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holidayapi.R;
import com.example.holidayapi.adapter.CountryAdapter;
import com.example.holidayapi.country.CountryHolidaysItem;
import com.example.holidayapi.tow.MainTow;
import com.example.holidayapi.view.model.CountryViewModel;
import com.example.holidayapi.tow.Tow;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFragment extends Fragment implements MainTow {

    private Tow tow;
    private CountryAdapter countryAdapter;
    private RecyclerView rvCountryDiscover;
    CountryViewModel countryViewModel;
    private String api_key = "e9e4be2e-72e6-4e6c-ab2f-684fd7fe4f7f";
    private String country = "GB";
    private String year = "2020";

    public CountryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_holiday, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        countryAdapter = new CountryAdapter(getContext());
        countryAdapter.notifyDataSetChanged();

        rvCountryDiscover = view.findViewById(R.id.fragmentcountry_rv);
        rvCountryDiscover.setLayoutManager(new GridLayoutManager(getContext(), 2));

        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);
        countryViewModel.setCountryDiscover(api_key, country, year);
        countryViewModel.getCountryDiscover().observe(this, getCountryDiscover);

        rvCountryDiscover.setAdapter(countryAdapter);


    }

    private Observer<ArrayList<CountryHolidaysItem>> getCountryDiscover = new Observer<ArrayList<CountryHolidaysItem>>() {
        @Override
        public void onChanged(ArrayList<CountryHolidaysItem> countryHolidaysItems) {
            if (countryHolidaysItems != null) {
                countryAdapter.setData(countryHolidaysItems);
            }
        }
    };

    @Override
    public void onSucces(ArrayList<CountryHolidaysItem> holidaysItems) {

    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getContext(), failureMessage, Toast.LENGTH_SHORT).show();
    }
}
