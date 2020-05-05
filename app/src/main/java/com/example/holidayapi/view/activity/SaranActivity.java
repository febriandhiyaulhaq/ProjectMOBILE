package com.example.holidayapi.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.holidayapi.R;
import com.example.holidayapi.database.AppDatabase;
import com.example.holidayapi.database.DataDiri;

public class SaranActivity extends AppCompatActivity {

    private Button btnSimpan;
    private EditText etName,etAssassement;
    private AppDatabase appDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        etName = findViewById(R.id.et_nama);
        etAssassement = findViewById(R.id.et_assassement);
        btnSimpan = findViewById(R.id.btn_simpan);
        appDatabase = AppDatabase.initDB(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    DataDiri dataDiri = new DataDiri();

                    dataDiri.setName(etName.getText().toString());
                    dataDiri.setAlamat(etAssassement.getText().toString());

                    appDatabase.dao().insertData(dataDiri);

                    Log.d("SaranActivity", "sukses ");
                    Toast.makeText(getApplicationContext(), "Tersimpan", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Log.e("SaranActivity", "gagal menyimpan , msg : " + ex.getMessage());
                    Toast.makeText(getApplicationContext(), "Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

