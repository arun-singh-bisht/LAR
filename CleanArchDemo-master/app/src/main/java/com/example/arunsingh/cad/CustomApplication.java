package com.example.arunsingh.cad;

import android.app.Application;

import com.example.arunsingh.cad.di.component.ApplicationComponent;
import com.example.arunsingh.cad.di.component.DaggerApplicationComponent;
import com.example.arunsingh.cad.di.module.ApplicationModule;
import com.example.arunsingh.cad.di.module.RestModule;


public class CustomApplication extends Application {

    ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .restModule(new RestModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
