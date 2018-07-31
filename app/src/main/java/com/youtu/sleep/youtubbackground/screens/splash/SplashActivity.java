package com.youtu.sleep.youtubbackground.screens.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.youtu.sleep.youtubbackground.R;
import com.youtu.sleep.youtubbackground.screens.BaseActivity;
import com.youtu.sleep.youtubbackground.screens.main.YoutubeMainActivity;
import com.youtu.sleep.youtubbackground.utils.navigator.Navigator;

public class SplashActivity extends BaseActivity {
    public static final int TIME_DELAY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handleSplash();
    }

    /**
     * handle next screen
     */

    public void handleSplash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, YoutubeMainActivity.class);
                Navigator navigator = new Navigator(SplashActivity.this);
                navigator.startActivity(intent);
                finish();
            }
        }, TIME_DELAY);
    }
}
