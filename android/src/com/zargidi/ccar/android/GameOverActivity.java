package com.zargidi.ccar.android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class GameOverActivity extends Activity {


    TextView txtTitle;
    TextView txtScoreCurrent;
    TextView txtScoreHigh;

    //google admob
    private InterstitialAd interstitial;
    private AdRequest adRequest;
    private Boolean adIsShowed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        /**
         * Ad mob closed
         */
        //loadInterstitialAd();

        SharedPreferences userScores = getSharedPreferences("userScore", MODE_PRIVATE);
        Boolean gameWin = userScores.getBoolean("gameWin", false);
        int scoreCurrent = userScores.getInt("scoreCurrent", 0);
        int scoreHigh = userScores.getInt("scoreHigh", 0);

        if (gameWin) {

            txtTitle = (TextView) findViewById(R.id.txt_game_over_title);
            txtTitle.setText("WOAH!\nYOU ARE BEST");
        }


        txtScoreCurrent = (TextView) findViewById(R.id.label_score_current);
        txtScoreCurrent.setText("" + scoreCurrent);

        txtScoreHigh = (TextView) findViewById(R.id.label_score_high);
        txtScoreHigh.setText("" + scoreHigh);


        ImageView replayButton = (ImageView) findViewById(R.id.buttonReplay);
        Animation shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake);
        replayButton.clearAnimation();
        replayButton.setAnimation(shakeAnim);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_game_over, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void menuButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.buttonReplay:

                Random rnd = new Random();
                if (interstitial.isLoaded() && rnd.nextBoolean()) {
                    interstitial.show();
                } else {
                    replayGame();
                }

                break;
            case R.id.buttonBackToLevel:
                backToLevel();
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


    public void backToLevel() {
        Intent intent = new Intent(getApplicationContext(), SelectLevelActivity.class);
        startActivity(intent);
    }


    public void replayGame() {
        Intent intent = new Intent(getApplicationContext(), GameLauncherActivity.class);
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

    private void loadInterstitialAd() {
        interstitial = new InterstitialAd(this);
        //interstitial.setAdUnitId("XXXXXXXXXX");
        adRequest = new AdRequest.Builder().build();
        //adRequest = new AdRequest.Builder().addTestDevice("34534k5jk345ff675456464564fs56456").build();
        interstitial.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        //displayInterstitial();
        //Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
        //startActivity(intent);
    }

}
