package com.edu.news.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.edu.news.Activities.LoginActivity;
import com.edu.news.Activities.RegisterActivity;
import com.edu.news.R;

public class SplashActivity extends AppCompatActivity {
    View mContentView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        set hide title and action bar
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getSupportActionBar().hide();
//
//        mContentView = findViewById(R.id.imageViewLogo);
//        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
//                |View.SYSTEM_UI_FLAG_FULLSCREEN
//                |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

            }
        }, 4000);
    }
}
