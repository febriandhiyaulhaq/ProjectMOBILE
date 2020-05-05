package com.example.holidayapi.view;

import android.view.View;

import com.example.holidayapi.DbHoliday.AppDatabase;
import com.example.holidayapi.DbHoliday.DataHoliday;

import java.util.ArrayList;

public interface MainContact {
    interface view extends View.OnClickListener{
        void resetForm();
        void sukses();
        void editData(DataHoliday item);

    }
    interface datapresenter{

        void deleteData(AppDatabase database, DataHoliday dataHolidays);
    }
    interface Cetak extends View.OnClickListener{
        void getData(ArrayList<DataHoliday> list);
    }
    interface hapus{

        void sukses();
        void deleteData(DataHoliday item);
    }
}
