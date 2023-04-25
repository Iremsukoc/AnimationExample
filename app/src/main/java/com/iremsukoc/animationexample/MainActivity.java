package com.iremsukoc.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    //Variables
    LottieAnimationView lottieAnimationView;
    TextView slogan;
    Animation animation;
    private final static int ANIMATIONTIME = 5000;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        animation = AnimationUtils.loadAnimation(this,R.anim.slide_anim);

        //Hooks
        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        slogan = findViewById(R.id.sloganMain);

        slogan.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(lottieAnimationView,"cloverLeafImage");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(intent,options.toBundle());
            }
        },ANIMATIONTIME);



    } // end onCreate() method


} // end class