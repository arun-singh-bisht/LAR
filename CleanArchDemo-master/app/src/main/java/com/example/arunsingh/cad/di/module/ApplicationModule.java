package com.example.arunsingh.cad.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.arunsingh.cad.data.DataManager;
import com.example.arunsingh.cad.data.pref.SharedPrefsHelper;
import com.example.arunsingh.cad.ui.login.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

}
