package com.alexmartin.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
/**
 * @author Alejandro Martin
 */
public class Login extends AppCompatActivity {
    Button confirmar;

    public static String getLogin_name() {
        return login_name;
    }
    public static String getpassword() {
        return password;
    }
    public static void setLogin_name(String s) {
        login_name = s;
    }
    public static void setpassword(String s) {
        password = s;
    }

    public static String login_name;
    EditText inp_name;
    public static String password;
    EditText inp_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//        confirmar = (Button) findViewById(R.id.confirm);
//        confirmar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent1 = new Intent(Login.this, MainActivity.class);
//                startActivity(intent1);
//            }
//        });
        inp_name =(EditText) findViewById(R.id.et_1);
        inp_password =(EditText) findViewById(R.id.et_2);

    }
    public void openMain(View v) {
        Intent intent = new Intent(Login.this, Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        login_name = inp_name.getText().toString();
        password = inp_password.getText().toString();
        startActivity(intent);
    }
    public void openSignup(View v) {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
}