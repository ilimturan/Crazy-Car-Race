package com.zargidi.ccar.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainMenuActivity extends Activity {

    public int devModeClickCount;
    public boolean devMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ImageView playButton = (ImageView) findViewById(R.id.buttonPlay);
        Animation shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake);
        playButton.clearAnimation();
        playButton.setAnimation(shakeAnim);

        devModeClickCount = 0;
        devMode = false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void menuButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.buttonPlay:
                selectLevelActivity();
                break;
            case R.id.buttonGameCenter:
                howToPlay();
                break;
            case R.id.buttonPlayMarketStar:
                playMarketStar();
                break;
            case R.id.buttonPlayMarketHeart:
                playMarketHeart();
                break;
            default:
                break;
        }
    }

    private void selectLevelActivity() {

        Intent intent = new Intent(getApplicationContext(), SelectLevelActivity.class);
        startActivity(intent);
    }

    public void showErrorDialog(final String title, final String message) {

        AlertDialog aDialog = new AlertDialog.Builder(this).setMessage(message).setTitle(title).create();
        aDialog.show();

    }


    public void howToPlay() {

        Intent intent = new Intent(getApplicationContext(), HowToPlayActivity.class);
        startActivity(intent);

    }

    public void playMarketStar() {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Zargidi%20Games"));
        startActivity(intent);
    }

    public void playMarketHeart() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.zargidi.ccar.android"));
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        //Nothing bro
    }


}
