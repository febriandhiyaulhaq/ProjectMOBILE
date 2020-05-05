package com.example.holidayapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holidayapi.R;
import com.example.holidayapi.DbHoliday.AppDatabase;
import com.example.holidayapi.DbHoliday.DataHoliday;
import com.example.holidayapi.view.MainContact;

import java.util.ArrayList;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.Holder> {
    private AppDatabase appDatabase;
    private Context context;
    private ArrayList<DataHoliday> list;
    private MainContact.hapus view;

    public WishListAdapter(Context context, ArrayList<DataHoliday> list, MainContact.hapus view) {
        this.context = context;
        this.list = list;
        this.view = view;
    }

    @NonNull
    @Override
    public WishListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wishlist, viewGroup,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WishListAdapter.Holder holder, int i) {
        holder.bind(i);
    }
    private ImageView ivFavorit;
    private TextView tvTitlefav, tvDate, tvStart, tvEnd, tvType, tvCountry;
    private CardView cvItemFav;

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
            tvTitlefav = itemView.findViewById(R.id.itemfavorit_tv_name);
            cvItemFav = itemView.findViewById(R.id.itemfavorit_cv);
            ivFavorit = itemView.findViewById(R.id.itemfavorit_star_favorit);
            tvDate = itemView.findViewById(R.id.itemfavorit_date);
            tvStart = itemView.findViewById(R.id.itemfavorit_start);
            tvEnd = itemView.findViewById(R.id.itemfavorit_end);
            tvType = itemView.findViewById(R.id.itemfavorit_type);
            tvCountry = itemView.findViewById(R.id.itemfavorit_country);

        }

        public void bind(int i){
            final DataHoliday dataHoliday = list.get(i);
            tvTitlefav.setText(dataHoliday.getNameHoliday());
            tvDate.setText(dataHoliday.getDateHoliday());
            tvStart.setText(dataHoliday.getStartHoliday());
            tvEnd.setText(dataHoliday.getEndHoliday());
            tvType.setText(dataHoliday.getTypeHoliday());
            tvCountry.setText(dataHoliday.getCountryHoliday());

            ivFavorit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appDatabase = AppDatabase.iniDb(context);

                    view.deleteData(dataHoliday);
                }
            });

        }
    }
}
