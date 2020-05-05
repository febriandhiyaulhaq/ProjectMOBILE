package com.example.holidayapi.DbHoliday;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "holiday_db")
public class DataHoliday {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nameHoliday")
    private String nameHoliday;

    @ColumnInfo(name = "dateHoliday")
    private String dateHoliday;

    @ColumnInfo(name = "startHoliday")
    private String startHoliday;

    @ColumnInfo(name = "endHoliday")
    private String endHoliday;

    @ColumnInfo(name = "typeHoliday")
    private String typeHoliday;

    @ColumnInfo(name = "countryHoliday")
    private String countryHoliday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameHoliday() {
        return nameHoliday;
    }

    public void setNameHoliday(String nameHoliday) {
        this.nameHoliday = nameHoliday;
    }

    public String getDateHoliday() {
        return dateHoliday;
    }

    public void setDateHoliday(String dateHoliday) {
        this.dateHoliday = dateHoliday;
    }

    public String getStartHoliday() {
        return startHoliday;
    }

    public void setStartHoliday(String startHoliday) {
        this.startHoliday = startHoliday;
    }

    public String getEndHoliday() {
        return endHoliday;
    }

    public void setEndHoliday(String endHoliday) {
        this.endHoliday = endHoliday;
    }

    public String getTypeHoliday() {
        return typeHoliday;
    }

    public void setTypeHoliday(String typeHoliday) {
        this.typeHoliday = typeHoliday;
    }

    public String getCountryHoliday() {
        return countryHoliday;
    }

    public void setCountryHoliday(String countryHoliday) {
        this.countryHoliday = countryHoliday;
    }
}
