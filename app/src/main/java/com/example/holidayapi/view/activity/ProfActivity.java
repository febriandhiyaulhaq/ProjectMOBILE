package com.example.holidayapi.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.holidayapi.R;
import com.example.holidayapi.databaseprof.AppDatabase;
import com.example.holidayapi.databaseprof.MahasiswaModel;
import com.example.holidayapi.view.activity.ReadActivity;

public class ProfActivity extends AppCompatActivity {

    private AppDatabase appDatabase;
    private Button btnLihatData, btnSimpan;
    private EditText etEmail,etNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        btnLihatData = findViewById(R.id.activitymain_btn_lihatdata);
        btnSimpan = findViewById(R.id.activitymain_btn_simpan);

        etNama = findViewById(R.id.activitymain_et_nama);
        etEmail = findViewById(R.id.activitymain_et_email);

        appDatabase = AppDatabase.initDatabase(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    MahasiswaModel mahasiswaModel = new MahasiswaModel();
                    mahasiswaModel.setNama(etNama.getText().toString());
                    mahasiswaModel.setNim(etEmail.getText().toString());

                    appDatabase.mahasiswaDAO().insertMahasiswa(mahasiswaModel);

                    Log.d("ProfActivity" , "sukses ");
                    Toast.makeText(getApplicationContext(),"Tersimpan", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("ProfActivity" , "gagal menyimpan , msg : "+ex.getMessage());
                    Toast.makeText(getApplicationContext(),"Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });


            findViewById(R.id.activitymain_btn_lihatdata).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(ProfActivity.this, com.example.holidayapi.view.activity.ReadActivity.class));
                }
            });
    }
}
