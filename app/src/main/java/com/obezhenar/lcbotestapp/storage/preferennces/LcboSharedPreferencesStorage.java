package com.obezhenar.lcbotestapp.storage.preferennces;

import android.content.Context;
import android.content.SharedPreferences;

public class LcboSharedPreferencesStorage {
    private static final String NAME = "app_settings.txt";
    private static final String DB_DROP_TIME = "db_drop_time";
    private SharedPreferences sharedPreferences;

    public LcboSharedPreferencesStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public void saveDatabaseDropTime(long dropTime) {
        sharedPreferences.edit()
                .putLong(DB_DROP_TIME, dropTime)
                .apply();
    }

    public long getDbDropTime() {
        return sharedPreferences.getLong(DB_DROP_TIME, 0);
    }
}
