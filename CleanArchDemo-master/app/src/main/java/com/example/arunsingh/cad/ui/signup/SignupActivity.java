package com.example.arunsingh.cad.ui.signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.arunsingh.cad.R;
import com.example.arunsingh.cad.ui.BaseActivity;
import com.example.arunsingh.cad.utils.GeneralUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends BaseActivity {

    @BindView(R.id.ed_name)
    EditText ed_name;
    @BindView(R.id.ed_email_address)
    EditText ed_email_address;
    @BindView(R.id.ed_password)
    EditText ed_password;

    @Override
    protected int layoutRes() {
        return R.layout.activity_signup;
    }

    @Override
    protected void initialize() {
        findViewById(R.id.text_title).setVisibility(View.GONE);
        findViewById(R.id.image_actionbar_right).setVisibility(View.GONE);
    }

    @OnClick(R.id.image_actionbar_left)
    void back() {
        finish();
    }

    @OnClick(R.id.text_register_button)
    void registerUser() {
        // TODO call server...
        if(ed_name.getText().toString().isEmpty())
            Toast.makeText(this,"Please enter Name.", Toast.LENGTH_SHORT).show();
        else if(!GeneralUtil.isValidEmail(ed_email_address.getText().toString()))
            Toast.makeText(this,"Please enter valid email address.", Toast.LENGTH_SHORT).show();
        else if(!GeneralUtil.isValidPassword(ed_password.getText().toString()))
            Toast.makeText(this,"Please enter valid password.", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Register.", Toast.LENGTH_SHORT).show();
    }


}
