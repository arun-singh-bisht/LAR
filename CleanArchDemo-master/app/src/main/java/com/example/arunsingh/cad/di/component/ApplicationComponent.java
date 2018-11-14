package com.example.arunsingh.cad.di.component;

import android.app.Activity;

import com.example.arunsingh.cad.CustomApplication;
import com.example.arunsingh.cad.data.DataManager;
import com.example.arunsingh.cad.data.pref.SharedPrefsHelper;
import com.example.arunsingh.cad.di.module.ApplicationModule;
import com.example.arunsingh.cad.di.module.RestModule;
import com.example.arunsingh.cad.ui.BaseActivity;
import com.example.arunsingh.cad.ui.MainActivity;
import com.example.arunsingh.cad.ui.login.LoginActivity;
import com.example.arunsingh.cad.ui.login.Repository;
import com.example.arunsingh.cad.ui.movie.MoviesActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RestModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);
    void inject(LoginActivity loginActivity);
    void inject(MoviesActivity moviesActivity);

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

}
