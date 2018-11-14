package com.example.arunsingh.cad.di.component;


import com.example.arunsingh.cad.di.module.ApplicationContextModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationContextModule.class)
public interface ApplicationContextComponent {

    //Context getApplicationContext();
}
