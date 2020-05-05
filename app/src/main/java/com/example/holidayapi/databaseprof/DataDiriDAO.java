package com.example.holidayapi.databaseprof;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDiriDAO {

    @Insert
    long insertMahasiswa(MahasiswaModel mahasiswaModel);

    @Delete
    int deleteMahasiswa(MahasiswaModel mahasiswaModel);

    @Query("SELECT * FROM data_mahasiswa")
    List<MahasiswaModel> getMahasiswa();


}
