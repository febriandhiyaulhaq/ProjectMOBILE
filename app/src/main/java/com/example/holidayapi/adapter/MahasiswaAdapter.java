package com.example.holidayapi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holidayapi.R;
import com.example.holidayapi.databaseprof.AppDatabase;
import com.example.holidayapi.databaseprof.MahasiswaModel;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MahasiswaModel> mahasiswaItems = new ArrayList<>();
    private AppDatabase appDatabase;

    public MahasiswaAdapter(Context context){
        this.context = context;
        appDatabase = AppDatabase.initDatabase(this.context);
    }

    public void setData(ArrayList<MahasiswaModel> items){
        mahasiswaItems.clear();
        mahasiswaItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MahasiswaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_mahasiswa,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.ViewHolder holder, final int position) {
        holder.tvEmail.setText(mahasiswaItems.get(position).getNim());
        holder.tvNama.setText(mahasiswaItems.get(position).getNama());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    MahasiswaModel mahasiswaModel = new MahasiswaModel();

                    mahasiswaModel.setNim(mahasiswaItems.get(position).getNim());
                    mahasiswaModel.setNama(mahasiswaItems.get(position).getNama());
                    mahasiswaModel.setId(mahasiswaItems.get(position).getId());

                    appDatabase.mahasiswaDAO().deleteMahasiswa(mahasiswaModel);

                    Log.d("MahasiwaAdapter" , "Sukses Dihapus");
                    Toast.makeText(context,"Data Sukses Dihapus", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("MahasiwaAdapter" , "Gagal Menampilkan Data , msg : "+ex.getMessage());
                    Toast.makeText(context,"Data Gagal Ditampilkan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswaItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnDelete;
        TextView tvEmail,tvNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnDelete = itemView.findViewById(R.id.itemlist_mahasiswa_btn_delete);
            tvNama = itemView.findViewById(R.id.itemlist_mahasiswa_tv_nama);
            tvEmail = itemView.findViewById(R.id.itemlist_mahasiswa_tv_email);
        }
    }
}
