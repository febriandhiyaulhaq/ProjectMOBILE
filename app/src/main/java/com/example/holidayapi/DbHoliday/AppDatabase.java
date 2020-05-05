package com.example.holidayapi.DbHoliday;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataHoliday.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataHolidayDao dao();
    private static AppDatabase appDatabase;

    public static AppDatabase iniDb(Context context){
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "holidaydb")
                    .allowMainThreadQueries().build();

        return appDatabase;
    }

    public static void destroyInstance(){appDatabase = null;}
}
