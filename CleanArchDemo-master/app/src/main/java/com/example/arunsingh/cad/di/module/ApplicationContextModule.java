package com.example.arunsingh.cad.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private Context context;

    public ApplicationContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideApplicationContext()
    {
        return context;
    }
}
