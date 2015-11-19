package com.zargidi.ccar.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread() {

            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        startActivity(new Intent(getBaseContext(), MainMenuActivity.class));
                        finish();
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    public void onBackPressed() {
        //Nothing bro
    }


}
