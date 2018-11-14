package com.example.arunsingh.cad.data.pref;

public interface SharedPrefsInterface {

    public static String PREF_KEY_ACCESS_TOKEN = "access-token";

    public void saveAccessToken(String accessToken);
    public String getAccessToken();
    public void clearSharedPref();
}
