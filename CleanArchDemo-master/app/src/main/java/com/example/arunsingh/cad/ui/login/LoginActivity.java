package com.example.arunsingh.cad.ui.login;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;


import com.example.arunsingh.cad.CustomApplication;
import com.example.arunsingh.cad.R;
import com.example.arunsingh.cad.rest.ApiResponse;
import com.example.arunsingh.cad.ui.BaseActivity;
import com.example.arunsingh.cad.ui.MainActivity;
import com.example.arunsingh.cad.ui.movie.MoviesActivity;
import com.example.arunsingh.cad.ui.signup.SignupActivity;
import com.example.arunsingh.cad.utils.GeneralUtil;
import com.example.arunsingh.cad.utils.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.ed_email_address)
    EditText ed_email_address;
    @BindView(R.id.ed_password)
    EditText ed_password;

    private LoginViewModel loginViewModel;
    private ProgressDialog progressDialog;
    @Override
    protected int layoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initialize() {

        ((CustomApplication)getApplication()).getComponent().inject(this);

        progressDialog = GeneralUtil.getProgressDialog(this, "Please wait...");
        loginViewModel = ViewModelProviders.of(this,viewModelFactory).get(LoginViewModel.class);
        loginViewModel.getLoginResponse().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(@Nullable ApiResponse apiResponse) {
                consumeResponse(apiResponse);
            }
        });
    }

    @OnClick(R.id.text_login_button)
    void login() {

        String email_address = ed_email_address.getText().toString();
        String password = ed_password.getText().toString();
        loginViewModel.login(email_address,password);
    }

    @OnClick(R.id.text_new_account)
    void newAcount() {
        startActivity(new Intent(this,SignupActivity.class));
    }

    private void consumeResponse(ApiResponse apiResponse) {

        switch (apiResponse.status) {

            case LOADING:
                progressDialog.show();
                break;

            case SUCCESS:
                progressDialog.dismiss();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                break;

            case ERROR:
                progressDialog.dismiss();
                //Toast.makeText(LoginActivity.this,"Error in API calling.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MoviesActivity.class));
                break;

            default:
                break;
        }
    }
}
