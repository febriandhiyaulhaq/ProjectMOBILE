package com.example.holidayapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.holidayapi.R;
import com.example.holidayapi.country.CountryHolidaysItem;
import com.example.holidayapi.DbHoliday.AppDatabase;
import com.example.holidayapi.DbHoliday.DataHoliday;
import com.example.holidayapi.view.activity.DetailCountryActivity;

import java.util.ArrayList;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private ArrayList<CountryHolidaysItem> countryHolidaysItems = new ArrayList<>();
    private Context context;
    AppDatabase appDatabase;

    public CountryAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<CountryHolidaysItem> items) {
        countryHolidaysItems.clear();
        countryHolidaysItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, final int i) {
        holder.tvTitle.setText(countryHolidaysItems.get(i).getName());
        CardView cardView = holder.cvItem;
        ImageButton imageButton = holder.ivStarFavorit;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailCountryActivity.class);
                intent.putExtra("tvTitle", countryHolidaysItems.get(i).getName());
                intent.putExtra("tvDate", countryHolidaysItems.get(i).getDate());
                intent.putExtra("tvStart", countryHolidaysItems.get(i).getStart());
                intent.putExtra("tvEnd", countryHolidaysItems.get(i).getEnd());
                intent.putExtra("tvType", countryHolidaysItems.get(i).getType());
                intent.putExtra("tvCountry", countryHolidaysItems.get(i).getCountry());
                context.startActivity(intent);

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appDatabase = AppDatabase.iniDb(context);
                final DataHoliday dataHolidays = new DataHoliday();
                //   dataHoliday.setId(idHoliday);
                dataHolidays.setNameHoliday(countryHolidaysItems.get(i).getName());
                dataHolidays.setDateHoliday(countryHolidaysItems.get(i).getDate());
                dataHolidays.setStartHoliday(countryHolidaysItems.get(i).getStart());
                dataHolidays.setEndHoliday(countryHolidaysItems.get(i).getEnd());
                dataHolidays.setTypeHoliday(countryHolidaysItems.get(i).getType());
                dataHolidays.setCountryHoliday(countryHolidaysItems.get(i).getCountry());

                new InsertData(appDatabase, dataHolidays).execute();

            }
        });
    }


    @Override
    public int getItemCount() {
        return countryHolidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;
        ImageButton ivStarFavorit;
        TextView tvTitle;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_name);
            ivStarFavorit = itemView.findViewById(R.id.itemlist_star_favorit);
        }
    }

    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase database;
        private DataHoliday dataHolidays;


        public InsertData(AppDatabase database, DataHoliday dataHolidays) {
            this.database = database;
            this.dataHolidays = dataHolidays;

        }

        @Override
        protected Long doInBackground(Void... voids) {

            return database.dao().insertData(dataHolidays);
        }

        protected void onPostExecute(Long aLong){
            super.onPostExecute(aLong);
            Toast.makeText(context, "WishList", Toast.LENGTH_SHORT).show();
        }
    }
}
