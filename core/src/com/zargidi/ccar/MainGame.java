package com.zargidi.ccar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zargidi.screen.GameScreen;
import com.zargidi.screen.ScreenManager;

import static com.badlogic.gdx.graphics.GL20.*;

public class MainGame extends ApplicationAdapter {
    // Local variable to hold the callback implementation
    private MyGameCallback myGameCallback;

    public static Boolean gameOver = false;

    //Finish game
    public static Boolean gameWin = false;
    public static Integer scoreCurrent = 0;
    public static Integer scoreHigh = 0;

    SpriteBatch batch;

    public static boolean debug = false;
    public static int level = 1;

    public interface MyGameCallback {
        public void showGameOverScreen(Integer scoreCurrent, Integer scoreHigh, Boolean gameWin);
    }

    public MainGame(Boolean devMode, int selectedLevel){

        debug = devMode;
        level = selectedLevel;
    }

	@Override
	public void create () {

		batch = new SpriteBatch();
        ScreenManager.setCurrentScreen(new GameScreen());
	}

    @Override
    public void dispose() {

        batch.dispose();
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().dispose();
        }

    }

	@Override
	public void render () {

        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().update();
        }
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().render(batch);

        }

        if(gameOver){
            ScreenManager.clearScreen();
            dispose();
            Gdx.app.exit();
            myGameCallback.showGameOverScreen(scoreCurrent, scoreHigh, gameWin);
        }

	}

    @Override
    public void resize(int width, int height) {

        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().resize(width, height);
        }
    }

    @Override
    public void pause() {

        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().pause();
        }
    }

    @Override
    public void resume() {
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().resume();
        }

    }

    // Setter for the callback
    public void setMyGameCallback(MyGameCallback callback) {

        myGameCallback = callback;
    }

}
