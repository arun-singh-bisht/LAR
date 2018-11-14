package com.example.arunsingh.cad.rest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.JsonElement;

import static com.example.arunsingh.cad.rest.Status.ERROR;
import static com.example.arunsingh.cad.rest.Status.LOADING;
import static com.example.arunsingh.cad.rest.Status.SUCCESS;


public class ApiResponse {

    public final Status status;

    @Nullable
    public final InterfaceResponseData data;

    @Nullable
    public final Throwable error;

    private ApiResponse(Status status, @Nullable InterfaceResponseData data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static ApiResponse success(@NonNull InterfaceResponseData data) {
        return new ApiResponse(SUCCESS, data, null);
    }

    public static ApiResponse error(@NonNull Throwable error) {
        return new ApiResponse(ERROR, null, error);
    }

}
