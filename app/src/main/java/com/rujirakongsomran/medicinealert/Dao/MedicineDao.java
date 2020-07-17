package com.rujirakongsomran.medicinealert.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rujirakongsomran.medicinealert.Entity.Medicine;

import java.util.List;

@Dao
public interface MedicineDao {
    @Insert
    void insert(Medicine medicine);

    @Update
    void update(Medicine medicine);

    @Delete
    void delete(Medicine medicine);

    @Query("DELETE FROM medicine_table")
    void deleteAllMedicines();

    @Query("SELECT * FROM medicine_table ORDER BY name DESC")
    LiveData<List<Medicine>> getAllMedicines();
}
