package com.example.holidayapi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.holidayapi.R;
import com.example.holidayapi.country.CountryHolidaysItem;

public class DetailCountryActivity extends AppCompatActivity {

    private CountryHolidaysItem holidaysItem;
    private TextView tvTitle, tvDate, tvStart, tvEnd, tvType, tvPublic, tvCountry;
    private ImageView ivPoster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvTitle = findViewById(R.id.info_detail_name);
        tvDate = findViewById(R.id.info_detail_date);
        tvStart = findViewById(R.id.info_detail_start);
        tvEnd = findViewById(R.id.info_detail_end);
        tvType = findViewById(R.id.info_detail_type);

        tvCountry = findViewById(R.id.info_detail_country);



        getIncomingIntent();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;
            default:return super.onOptionsItemSelected(item);

        }
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String getTvTitle = bundle.getString("tvTitle");
            String getTvDate = bundle.getString("tvDate");
            String getTvStart = bundle.getString("tvStart");
            String getTvEnd = bundle.getString("tvEnd");
            String getTvType = bundle.getString("tvType");
            String getTvCountry = bundle.getString("tvCountry");

            tvTitle.setText(getTvTitle);
            tvDate.setText(getTvDate);
            tvStart.setText(getTvStart);
            tvEnd.setText(getTvEnd);
            tvType.setText(getTvType);
            tvCountry.setText(getTvCountry);

        }

    }

}
