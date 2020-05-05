package com.example.holidayapi.view.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holidayapi.adapter.CountryAdapter;
import com.example.holidayapi.adapter.WishListAdapter;
import com.example.holidayapi.DbHoliday.AppDatabase;
import com.example.holidayapi.DbHoliday.DataHoliday;
import com.example.holidayapi.tow.TowDao;
import com.example.holidayapi.view.MainContact;
import com.example.holidayapi.view.activity.MainActivity;
import com.example.holidayapi.R;
import com.example.holidayapi.view.activity.MenuActivity;

import java.util.ArrayList;
import java.util.List;


public class WishListFragment extends Fragment implements MainContact.hapus {

    private String api_key = "e9e4be2e-72e6-4e6c-ab2f-684fd7fe4f7f";
    private String country = "GB";
    private String year = "2020";

    private RecyclerView A;
    private CountryAdapter countryAdapter;
    private AppDatabase appDatabase;
    private TowDao towDao;
    private WishListAdapter wishListAdapter;
    Context context;

    public WishListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wishlist, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        A = view.findViewById(R.id.fragmentfavorit_rv);

        towDao = new TowDao(this);
        A.setLayoutManager(new LinearLayoutManager(context));
        appDatabase = AppDatabase.iniDb(getContext());
        readData(appDatabase);
    }
    public void readData(AppDatabase database){
        List list;
        list = database.dao().getData();
        wishListAdapter = new WishListAdapter(context, (ArrayList<DataHoliday>) list, this);
        A.setAdapter(wishListAdapter);
    }

    @Override
    public void sukses() {
        Toast.makeText(getContext(),"removed", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getContext(), MenuActivity.class));
    }

    @Override
    public void deleteData(final DataHoliday item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Remove From Wish List")
                .setMessage("Remove This List ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        towDao.deleteData(appDatabase, item);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
