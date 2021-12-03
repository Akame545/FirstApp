package com.alexmartin.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    String login_name;
    String password;
    EditText inp_name;
    EditText inp_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        inp_name =(EditText) findViewById(R.id.sup_edt_1);
        inp_password =(EditText) findViewById(R.id.sup_edt_2);
    }
    public void openMain(View v) {
        Intent intent = new Intent(Signup.this, Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        login_name = inp_name.getText().toString();
        password = inp_password.getText().toString();
        startActivity(intent);
    }
}