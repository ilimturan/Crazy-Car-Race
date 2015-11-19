package com.zargidi.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.zargidi.ccar.MainGame;
import com.zargidi.ccar.TextureManager;

/**
 * Created by ilimturan on 20/01/15.
 */
public class ScoreBoard extends Entity {

    BitmapFont userScoreTable;
    String userScoreCurrent;
    String userScoreHigh;

    public ScoreBoard(Vector2 pos, Vector2 direction) {

        super(new Texture(Gdx.files.internal("score_board.png")), pos, direction);
        this.eType = 4;
        userScoreTable = new BitmapFont();
        userScoreTable.setScale(3.0F);
        userScoreTable.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void update() {
        pos.add(direction);

        if (MainGame.scoreCurrent > 999) {
            userScoreTable.setScale(2.0F);
            this.pos.x = Gdx.graphics.getWidth() - (TextureManager.SCOREBOARD.getWidth() / 4 * 3);
        }

        if (MainGame.scoreCurrent > 0) {
            userScoreCurrent = "" + MainGame.scoreCurrent;
        } else {
            userScoreCurrent = "0";
        }
    }

    public void render(SpriteBatch sb) {

        sb.draw(texture, pos.x, pos.y);
        userScoreTable.draw(sb, "" + MainGame.scoreCurrent, (this.pos.x + this.texture.getWidth() / 4), (this.pos.y + this.texture.getHeight() / 2));

    }


}
