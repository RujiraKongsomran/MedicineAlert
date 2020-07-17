package com.rujirakongsomran.medicinealert.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.rujirakongsomran.medicinealert.Dao.MedicineDao;
import com.rujirakongsomran.medicinealert.Database.MedicineDatabase;
import com.rujirakongsomran.medicinealert.Entity.Medicine;

import java.util.List;

public class MedicineRepository {

    private MedicineDao medicineDao;
    private LiveData<List<Medicine>> allMedicines;

    public MedicineRepository(Application application) {
        MedicineDatabase database = MedicineDatabase.getInstance(application);
        medicineDao = database.medicineDao();
        allMedicines = medicineDao.getAllMedicines();
    }

    public void insert(Medicine medicine) {
        new InsertMedicineAsyncTask(medicineDao).execute(medicine);

    }

    public void update(Medicine medicine) {
        new UpdateMedicineAsyncTask(medicineDao).execute(medicine);

    }

    public void delete(Medicine medicine) {
        new DeleteMedicineAsyncTask(medicineDao).execute(medicine);
    }

    public void deleteAllMedicines() {
        new DeleteAllMedicineAsyncTask(medicineDao).execute();
    }

    public LiveData<List<Medicine>> getAllMedicines() {
        return allMedicines;
    }

    private static class InsertMedicineAsyncTask extends AsyncTask<Medicine, Void, Void> {
        private MedicineDao medicineDao;

        private InsertMedicineAsyncTask(MedicineDao medicineDao) {
            this.medicineDao = medicineDao;
        }

        @Override
        protected Void doInBackground(Medicine... medicines) {
            medicineDao.insert(medicines[0]);
            return null;
        }
    }

    private static class UpdateMedicineAsyncTask extends AsyncTask<Medicine, Void, Void> {
        private MedicineDao medicineDao;

        private UpdateMedicineAsyncTask(MedicineDao medicineDao) {
            this.medicineDao = medicineDao;
        }

        @Override
        protected Void doInBackground(Medicine... medicines) {
            medicineDao.update(medicines[0]);
            return null;
        }
    }

    private static class DeleteMedicineAsyncTask extends AsyncTask<Medicine, Void, Void> {
        private MedicineDao medicineDao;

        private DeleteMedicineAsyncTask(MedicineDao medicineDao) {
            this.medicineDao = medicineDao;
        }

        @Override
        protected Void doInBackground(Medicine... medicines) {
            medicineDao.delete(medicines[0]);
            return null;
        }
    }

    private static class DeleteAllMedicineAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedicineDao medicineDao;

        private DeleteAllMedicineAsyncTask(MedicineDao medicineDao) {
            this.medicineDao = medicineDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            medicineDao.deleteAllMedicines();
            return null;
        }
    }
}
