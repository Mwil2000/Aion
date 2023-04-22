package com.example.gif;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.*;

import java.util.*;


public class Splash_Screen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startSplashTimer();
    }
    private void  startSplashTimer()
    {
        try{
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    Intent intent = new Intent(Splash_Screen.this, activity_login.class);
                    startActivity(intent);
                    finish();
                }
            }, 4000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}