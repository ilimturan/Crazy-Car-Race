package com.zargidi.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.zargidi.ccar.MainGame;
import com.zargidi.ccar.TextureManager;

/**
 * Created by ilimturan on 18/01/15.
 */
public class TreeOne extends Tree {


    public TreeOne(Vector2 pos, Vector2 direction) {

        super(new Texture(Gdx.files.internal("tree1.png")), pos, direction);
        this.eType = 3;
    }

    @Override
    public void update() {
        pos.add(direction);

    }


}
