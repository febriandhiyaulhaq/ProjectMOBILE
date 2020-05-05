package com.example.holidayapi.tow;

import android.content.Context;
import android.os.AsyncTask;

import com.example.holidayapi.DbHoliday.AppDatabase;
import com.example.holidayapi.DbHoliday.DataHoliday;
import com.example.holidayapi.view.MainContact;

public class TowDao implements MainContact.datapresenter {
    MainContact.view view;
    MainContact.hapus viewH;

    public TowDao(MainContact.view view) {
        this.view = view;
    }

    public TowDao(MainContact.hapus viewH) {
        this.viewH = viewH;
    }


    @Override
    public void deleteData(AppDatabase database, DataHoliday dataHoliday) {
        new DeleteData(database, dataHoliday).execute();
    }
    
    class DeleteData extends AsyncTask<Void, Void, Void> {
        private AppDatabase database;
        private DataHoliday dataHoliday;
        Context context;
        public DeleteData(AppDatabase database, DataHoliday dataHoliday){
            this.database = database;
            this.dataHoliday = dataHoliday;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataHoliday);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewH.sukses();
        }
    }
}
