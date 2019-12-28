package com.example.myarchitecture.data.preferences;

import android.content.Context;
import android.preference.PreferenceManager;

public class PreferencesHelper {

    public int getNumberStart(String key, int defaultValue, Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(key, defaultValue);
    }

    public void setNumberStart(String key, int defaultValue, Context context) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(key, defaultValue)
                .apply();
    }
}
