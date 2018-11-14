package com.example.arunsingh.cad.data.pref;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SharedPrefsHelper implements SharedPrefsInterface {


    private SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefsHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }


    @Override
    public void saveAccessToken(String value) {
        mSharedPreferences.edit().putString(PREF_KEY_ACCESS_TOKEN, value).apply();
    }

    @Override
    public String getAccessToken() {
        return mSharedPreferences.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void clearSharedPref() {
        mSharedPreferences.edit().clear().commit();
    }
}
