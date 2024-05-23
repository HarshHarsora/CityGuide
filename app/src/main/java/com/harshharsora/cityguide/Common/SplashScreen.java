package com.harshharsora.cityguide.Common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.harshharsora.cityguide.R;
import com.harshharsora.cityguide.User.UserDeshbordActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER=5000;

    ImageView backgroundImage;
    TextView PoweredByLine;

    Animation sideAnim,bottomAnim;

    SharedPreferences onBordingScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        backgroundImage= findViewById(R.id.background_image);
        PoweredByLine= findViewById(R.id.powered_by_line);

        //animation

        sideAnim= AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim= AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set animation in image
        backgroundImage.setAnimation(sideAnim);
        PoweredByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBordingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime = onBordingScreen.getBoolean( "firstTime",true);

               if (isFirstTime) {

                   SharedPreferences.Editor editor = onBordingScreen.edit();
                   editor.putBoolean("firstTime", false);
                   editor.commit();
                   Intent intent = new Intent(getApplicationContext(), OnBoardingActivity.class);
                   startActivity(intent);
                   finish();
               }
               else {
                   Intent intent=new Intent(getApplicationContext(), UserDeshbordActivity.class);
                   startActivity(intent);
                   finish();
               }
            }
        },SPLASH_TIMER);
    }
}