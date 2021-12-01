package com.alexmartin.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
/**
 * @author Alejandro Martin
 */
public class Login extends AppCompatActivity {
    Button confirmar;
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
    }
    public void openMain(View v) {
        Intent intent = new Intent(Login.this, Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void openSignup(View v) {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
}