package com.example.arunsingh.cad.data;

import com.example.arunsingh.cad.data.pref.SharedPrefsHelper;
import com.example.arunsingh.cad.data.pref.SharedPrefsInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager implements SharedPrefsInterface {


    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(SharedPrefsHelper sharedPrefsHelper) {
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    @Override
    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.saveAccessToken(accessToken);
    }

    @Override
    public String getAccessToken() {
        return mSharedPrefsHelper.getAccessToken();
    }

    @Override
    public void clearSharedPref() {
        mSharedPrefsHelper.clearSharedPref();
    }

}
