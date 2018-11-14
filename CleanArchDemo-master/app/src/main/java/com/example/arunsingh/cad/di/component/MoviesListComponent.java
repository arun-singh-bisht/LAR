package com.example.arunsingh.cad.di.component;

import com.example.arunsingh.cad.di.module.ApplicationContextModule;
import com.example.arunsingh.cad.di.module.MoviesListModule;
import com.example.arunsingh.cad.ui.movie.MoviesActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MoviesListModule.class,ApplicationContextModule.class})
public interface MoviesListComponent {

    public void inject(MoviesActivity activity);
}
