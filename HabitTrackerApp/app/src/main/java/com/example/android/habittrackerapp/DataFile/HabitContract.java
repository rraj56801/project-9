package com.example.android.habittrackerapp.DataFile;

import android.provider.BaseColumns;

/**
 * Created by RajBaba on 23-08-2017.
 */
public class HabitContract {

    public static abstract class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habitTable";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_COMMENT = "comment";
        public static final String COLUMN_HABIT_DURATION = "duration";
        public static final String COLUMN_HABIT_REPEAT = "repeat";
        public static final String COLUMN_HABIT_TIME = "time";
    }
}
