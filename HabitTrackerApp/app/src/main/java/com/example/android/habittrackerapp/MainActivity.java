package com.example.android.habittrackerapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.habittrackerapp.DataFile.HabitContract;
import com.example.android.habittrackerapp.DataFile.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        habitDbHelper.insertHabit("Jogging", "Everyday", 30, 7, "5 AM");
        habitDbHelper.insertHabit("Playing", "Love Badminton", 100, 3, "6 PM");
        habitDbHelper.insertHabit("Singing", "Everyday", 45, 7, "9 PM");
        habitDbHelper.insertHabit("Movie", "Weekend", 100, 2, "10 PM");
        Cursor cursor = habitDbHelper.readHabit();
        try {
            int idColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_NAME);
            int commentColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_COMMENT);
            int durationColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_DURATION);
            int repeatColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_REPEAT);
            int timeColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_TIME);
            Log.d(TAG, "ID | NAME | COMMENT | DURATION | REPEAT | TIME");
            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                String name = cursor.getString(nameColumnIndex);
                String comment = cursor.getString(commentColumnIndex);
                int duration = cursor.getInt(durationColumnIndex);
                int repeat = cursor.getInt(repeatColumnIndex);
                String time = cursor.getString(timeColumnIndex);
                Log.d(TAG, id + " " + name + " " + comment + " " + duration + " " + repeat + " " + time);
            }
        } finally {
            cursor.close();
        }
    }
}

