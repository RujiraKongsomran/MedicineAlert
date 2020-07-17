package com.rujirakongsomran.medicinealert.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.rujirakongsomran.medicinealert.Dao.MedicineDao;
import com.rujirakongsomran.medicinealert.Entity.Medicine;

import java.text.SimpleDateFormat;

@Database(entities = {Medicine.class}, version = 1)
public abstract class MedicineDatabase extends RoomDatabase {

    private static MedicineDatabase instance;

    public abstract MedicineDao medicineDao();

    public static synchronized MedicineDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MedicineDatabase.class, "medicine_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private MedicineDao medicineDao;

        private PopulateDbAsyncTask(MedicineDatabase db) {
            medicineDao = db.medicineDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            medicineDao.insert(new Medicine("PROPRANOLOL", 10, 1, 2, "หลังอาหารเช้า เย็น", "ยาในโรคหัวใจและหลอดเลือด, ลดใจสั่น, ป้องกันไมเกรน", null, "เก็บยานี้ให้พ้นแสง, เป็นยาตัวเดียวกับ BETALOL 10 MG"));
            medicineDao.insert(new Medicine("MOCYDONE", 10, 1, 3, "ก่อนอาหารเช้า กลางวัน เย็น", "ยาปรับการเคลื่อนไหวของทางเดินอาหาร, ลดการคลื่นไส้อาเจียน", null, null));
            return null;
        }
    }
}
