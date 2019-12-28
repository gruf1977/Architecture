package com.example.myarchitecture.interactor;

import android.content.Context;
import com.example.myarchitecture.data.preferences.PreferencesHelper;

public class MainInteractor {
    private static final String KEY_START = "KEYSTAR";
    private int number;
    private Context context;
    private PreferencesHelper preferenceHelper = new PreferencesHelper();
    public MainInteractor(Context context) {
        this.context = context;
    }

    public int getNumberStart() {
        number = preferenceHelper.getNumberStart(KEY_START, 0, context);
        setNumberStart();
        return number;
    }

    private void setNumberStart() {
        preferenceHelper.setNumberStart(KEY_START, ++number, context);
    }

    public boolean showDialog(int number){
        if (number == 2) {
            return true;
        } else {
            return (number  - 2) % 4 == 0;
        }
    }
}
