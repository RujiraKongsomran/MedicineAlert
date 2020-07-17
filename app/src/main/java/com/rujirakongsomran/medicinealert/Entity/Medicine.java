package com.rujirakongsomran.medicinealert.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "medicine_table")
public class Medicine {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private float volume;

    private float number;

    private int times;

    private String when;

    private String description;

    private Date[] datetimeMed;

    private String Note;

    public Medicine() {
    }

    public Medicine(String name, float volume, float number, int times, String when, String description, Date[] datetimeMed, String note) {
        this.name = name;
        this.volume = volume;
        this.number = number;
        this.times = times;
        this.when = when;
        this.description = description;
        this.datetimeMed = datetimeMed;
        Note = note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getVolume() {
        return volume;
    }

    public float getNumber() {
        return number;
    }

    public int getTimes() {
        return times;
    }

    public String getWhen() {
        return when;
    }

    public String getDescription() {
        return description;
    }

    public Date[] getDatetimeMed() {
        return datetimeMed;
    }

    public String getNote() {
        return Note;
    }
}
