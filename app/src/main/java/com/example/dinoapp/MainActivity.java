package com.example.dinoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    ImageView image;
    Animation textAnimation, imgAnimation;
    TextView grave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // background animation
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(500);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

        // image 'raptor' animation
        imgAnimation = AnimationUtils.loadAnimation(this, R.anim.raptorjesus_animation);
        image = findViewById(R.id.imageView);
        image.setAnimation(imgAnimation);


        //text animation
        textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_enter_animation);
        grave = findViewById(R.id.grave);
        grave.setAnimation(textAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}