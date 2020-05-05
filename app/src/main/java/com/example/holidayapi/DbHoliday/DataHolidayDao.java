package com.example.holidayapi.DbHoliday;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataHolidayDao {
    @Insert
    long insertData(DataHoliday dataHoliday);

    @Query("Select * from holiday_db")
    List<DataHoliday> getData();

    @Delete
    void deleteData(DataHoliday item);
}
