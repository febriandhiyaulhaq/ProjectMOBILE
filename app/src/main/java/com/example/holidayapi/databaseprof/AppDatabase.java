package com.example.holidayapi.databaseprof;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MahasiswaModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract DataDiriDAO mahasiswaDAO();

    public static AppDatabase initDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "mahasiswa"
            ).allowMainThreadQueries().build();
        }

        return appDatabase;
    }

}
