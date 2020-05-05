package com.example.holidayapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holidayapi.R;
import com.example.holidayapi.database.AppDatabase;
import com.example.holidayapi.database.DataDiri;


import java.util.ArrayList;

public class SaranAdapter extends RecyclerView.Adapter<SaranAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DataDiri> dataDiriItem = new ArrayList<>();
    private AppDatabase appDatabase;

    public SaranAdapter(Context context){
        this.context = context;
        appDatabase = AppDatabase.initDB(this.context);
    }

    public void setData(ArrayList<DataDiri> items){
        dataDiriItem.clear();
        dataDiriItem.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SaranAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saran_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaranAdapter.ViewHolder holder, final int position) {
        holder.tvNama.setText(dataDiriItem.get(position).getName());
        holder.tvAlamat.setText(dataDiriItem.get(position).getAlamat());

    }

    @Override
    public int getItemCount() {
        return dataDiriItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama,tvAlamat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            tvNama = itemView.findViewById(R.id.itemlist_nama);
            tvAlamat = itemView.findViewById(R.id.itemlist_saran);
        }
    }
}
