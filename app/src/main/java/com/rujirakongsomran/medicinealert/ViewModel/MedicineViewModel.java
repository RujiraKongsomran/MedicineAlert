package com.rujirakongsomran.medicinealert.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rujirakongsomran.medicinealert.Entity.Medicine;
import com.rujirakongsomran.medicinealert.Repository.MedicineRepository;

import java.util.List;

public class MedicineViewModel extends AndroidViewModel {

    private MedicineRepository repository;
    private LiveData<List<Medicine>> allMedicines;

    public MedicineViewModel(@NonNull Application application) {
        super(application);
        repository = new MedicineRepository(application);
        allMedicines = repository.getAllMedicines();
    }

    public void insert(Medicine medicine) {
        repository.insert(medicine);
    }

    public void update(Medicine medicine) {
        repository.update(medicine);
    }

    public void delete(Medicine medicine) {
        repository.delete(medicine);
    }

    public void deleteAllMedicines() {
        repository.deleteAllMedicines();
    }

    public LiveData<List<Medicine>> getAllMedicines() {
        return allMedicines;
    }
}
