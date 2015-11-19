package com.zargidi.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zargidi.camera.OrthoCamera;
import com.zargidi.ccar.MainGame;
import com.zargidi.entity.EntityManager;

/**
 * Created by ilimturan on 18/01/15.
 */
public class GameScreen extends Screen {

    private OrthoCamera camera;
    private EntityManager entityManager;


    Pixmap px;
    Texture backgroundImg1;
    Texture backgroundImg2;

    public static int speed;
    int moveY = 0;


    @Override
    public void create() {
        // set game speed
        int sh = Gdx.graphics.getHeight();
        if(MainGame.level == 1 && MainGame.debug){
            speed = sh / 200;
        }
        else if(MainGame.level == 2 && MainGame.debug){
            speed = sh / 80;
        }
        else if(MainGame.level == 3 && MainGame.debug){
            speed = sh / 30;
        }
        else if(MainGame.level == 1){
            speed = sh / 100;
        }else if(MainGame.level == 2){
            speed = sh / 80;
        }else if(MainGame.level == 3){
            speed = sh / 60;
        }

        //set user score
        MainGame.scoreCurrent = 0;
        if (MainGame.scoreHigh == null) MainGame.scoreHigh = 0;

        camera = new OrthoCamera();
        entityManager = new EntityManager();

        //For background img
        px = new Pixmap(Gdx.files.internal("background.png"));
        backgroundImg1 = new Texture(px);
        backgroundImg1.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
        backgroundImg2 = backgroundImg1;

    }

    @Override
    public void update() {
        camera.update();
        entityManager.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        moveY = moveY + speed;

        sb.begin();
        int backW = Gdx.graphics.getWidth();
        int backH = Gdx.graphics.getHeight();
        sb.draw(backgroundImg1, 0, 0 - moveY, backW, backH);
        sb.draw(backgroundImg2, 0, backH - moveY, backW, backH);
        sb.end();

        if (moveY >= backH) moveY = 0;
        sb.begin();
        entityManager.render(sb);
        sb.end();


    }

    @Override
    public void resize(int width, int height) {

        camera.resize();
    }

    @Override
    public void dispose() {
        //System.out.println("dispose");
        Gdx.app.exit();

    }

    @Override
    public void pause() {
        //System.out.println("pause");
    }

    @Override
    public void resume() {
        //System.out.println("resume");
    }
}
