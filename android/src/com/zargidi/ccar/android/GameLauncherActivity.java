package com.zargidi.ccar.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.zargidi.ccar.MainGame;


public class GameLauncherActivity extends FragmentActivity implements AndroidFragmentApplication.Callbacks {

    public boolean gameOver;
    public Integer scoreCurrent;
    public Integer scoreHigh;
    public static Boolean devMode;
    public static int level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        gameOver = false;

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // 6. Finally, replace the AndroidLauncher activity content with the Libgdx Fragment.
        GameFragment fragment = new GameFragment();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();

        trans.replace(android.R.id.content, fragment);
        trans.commit();

    }

    // 4. Create a Class that extends AndroidFragmentApplication which is the Fragment implementation for Libgdx.
    public class GameFragment extends AndroidFragmentApplication implements MainGame.MyGameCallback {

        // 5. Add the initializeForView() code in the Fragment's onCreateView method.
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            MainGame game = new MainGame(devMode, level);
            game.setMyGameCallback((MainGame.MyGameCallback) this);
            game.gameOver = gameOver;
            return initializeForView(game);
        }

        @Override
        public void showGameOverScreen(Integer scoreCurrent, Integer scoreHigh, Boolean gameWin) {

            SharedPreferences userScores = getSharedPreferences("userScore", MODE_PRIVATE);
            SharedPreferences.Editor userScoreEditor = userScores.edit();

            userScoreEditor.putBoolean("gameWin", gameWin);
            userScoreEditor.putInt("scoreCurrent", scoreCurrent);

            int oldScoreHigh = userScores.getInt("scoreHigh", 0);

            if (scoreCurrent > oldScoreHigh) {
                userScoreEditor.putInt("scoreHigh", scoreCurrent);
            }

            userScoreEditor.commit();

            Intent intent = new Intent(getApplicationContext(), GameOverActivity.class);
            //intent.putExtra("Username", organization_name.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public void exit() {
        gameOver = false;
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
        startActivity(intent);
        // 720 x 1280
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
