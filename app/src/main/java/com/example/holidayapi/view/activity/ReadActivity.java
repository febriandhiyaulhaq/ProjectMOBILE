package com.example.holidayapi.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holidayapi.adapter.MahasiswaAdapter;
import com.example.holidayapi.R;
import com.example.holidayapi.databaseprof.AppDatabase;
import com.example.holidayapi.databaseprof.MahasiswaModel;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {

    private MahasiswaAdapter mahasiswaAdapter;
    private RecyclerView rvMahasiswa;
    private AppDatabase appDatabase;
    private ArrayList<MahasiswaModel> listMahasiswa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        rvMahasiswa = findViewById(R.id.readactivity_rv_mahasiswa);
        mahasiswaAdapter = new MahasiswaAdapter(getApplicationContext());
        mahasiswaAdapter.notifyDataSetChanged();

        if (appDatabase == null){
            appDatabase = AppDatabase.initDatabase(getApplicationContext());
        }

        listMahasiswa.addAll(appDatabase.mahasiswaDAO().getMahasiswa());
        mahasiswaAdapter.setData(listMahasiswa);

        rvMahasiswa.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvMahasiswa.setAdapter(mahasiswaAdapter);


    }
}
