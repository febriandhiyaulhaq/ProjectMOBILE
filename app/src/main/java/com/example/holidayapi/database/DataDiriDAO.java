package com.example.holidayapi.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDiriDAO {
    @Insert
    Long insertData(DataDiri dataDiri);

    @Query("SELECT * FROM datadiri_db")
    List<DataDiri> getDatadiri();
}
