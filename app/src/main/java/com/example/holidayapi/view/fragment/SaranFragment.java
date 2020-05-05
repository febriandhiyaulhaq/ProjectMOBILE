package com.example.holidayapi.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holidayapi.R;
import com.example.holidayapi.adapter.SaranAdapter;
import com.example.holidayapi.database.AppDatabase;
import com.example.holidayapi.database.DataDiri;

import java.util.ArrayList;

public class SaranFragment extends AppCompatActivity {
    private SaranAdapter saranAdapter;
    private RecyclerView rvSaran;
    private AppDatabase appDatabase;

    private ArrayList<DataDiri> listSaran = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_saran);

        rvSaran = findViewById(R.id.fragmentsaran);
        saranAdapter = new SaranAdapter(getApplicationContext());
        saranAdapter.notifyDataSetChanged();

        if (appDatabase == null){
            appDatabase = AppDatabase.initDB(getApplicationContext());
        }

        listSaran.addAll(appDatabase.dao().getDatadiri());
        saranAdapter.setData(listSaran);

        rvSaran.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvSaran.setAdapter(saranAdapter);


    }
}
