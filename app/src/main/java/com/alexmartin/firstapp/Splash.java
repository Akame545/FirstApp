package com.alexmartin.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 *
 * @author eramiro
 * trabajando en mejora de la animación
 *
 */

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openApp(true);


        //implements and starts animation
        ImageView logo = findViewById(R.id.logosplash);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.blink);
        logo.startAnimation(myanim);

      
        ImageView mSea = findViewById(R.id.backView);

        Glide.with(this)
                .load("https://1.bp.blogspot.com/-XBOvQhJ4e3E/YINVEJxvRyI/AAAAAAAAATo/S-PlEpwNLzs250tmpWEzkmiLt_Fbeu5UACLcBGAsYHQ/s476/Nyan%2Bcat.gif")
          //     .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(10))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.azul)))
//                .circleCrop()
                .into(mSea);


    }

    private void openApp(boolean locationPermission) {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, Login.class);
                startActivity(intent);
            }
        }, 2000);


    }

}