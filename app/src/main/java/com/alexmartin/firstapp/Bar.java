package com.alexmartin.firstapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Bar extends AppCompatActivity {
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton btnadd = findViewById(R.id.fab);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Bar.this, "Fab clicked", Toast.LENGTH_SHORT).show();
            }
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Bar.this, "Menu clicked", Toast.LENGTH_SHORT).show();
            }
        });
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.heart:
                        Toast.makeText(Bar.this, "added to favorite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(Bar.this, "beginning search", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}