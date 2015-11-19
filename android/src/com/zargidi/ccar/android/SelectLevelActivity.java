package com.zargidi.ccar.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class SelectLevelActivity extends Activity {

    public int devModeClickCount;
    public boolean devMode;


    private Button selectLevel1;
    private Button selectLevel2;
    private Button selectLevel3;

    private Animation levelCarAnimation1;
    private Animation levelCarAnimation2;
    private Animation levelCarAnimation3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);

        Intent intent = getIntent();

        selectLevel1 = (Button) findViewById(R.id.buttonSelectLevel1);
        selectLevel2 = (Button) findViewById(R.id.buttonSelectLevel2);
        selectLevel3 = (Button) findViewById(R.id.buttonSelectLevel3);

        levelCarAnimation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.level_car_zoom_in_1);
        levelCarAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.level_car_zoom_in_2);
        levelCarAnimation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.level_car_zoom_in_3);

        selectLevel1.startAnimation(levelCarAnimation1);
        selectLevel2.startAnimation(levelCarAnimation2);
        selectLevel3.startAnimation(levelCarAnimation3);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void selectLevelBtn(View v){
        switch (v.getId()){
            case R.id.buttonSelectLevel1 :
                playGame(1);
                break;
            case R.id.buttonSelectLevel2 :
                playGame(2);
                break;
            case R.id.buttonSelectLevel3 :
                playGame(3);
                break;

            case R.id.devmode:
                devModeClickCount++;

                if(devModeClickCount > 6){
                    devMode = true;
                }
                break;
            default:
                break;
        }
    }

    public void playGame(int level) {

        Intent intent = new Intent(getApplicationContext(), GameLauncherActivity.class);
        GameLauncherActivity.devMode = devMode;
        GameLauncherActivity.level = level;
        startActivity(intent);
    }

}
