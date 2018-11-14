package com.example.arunsingh.cad.utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.arunsingh.cad.ui.login.LoginViewModel;
import com.example.arunsingh.cad.ui.login.Repository;
import com.example.arunsingh.cad.ui.movie.MovieViewModel;

import javax.inject.Inject;


public class ViewModelFactory implements ViewModelProvider.Factory {

    private Repository repository;

    @Inject
    public ViewModelFactory(Repository repository) {
        this.repository = repository;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(repository);
        }else if(modelClass.isAssignableFrom(MovieViewModel.class))
        {
            return (T) new MovieViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
