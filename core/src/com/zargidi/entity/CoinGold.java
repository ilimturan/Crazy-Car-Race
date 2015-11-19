package com.zargidi.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.zargidi.ccar.TextureManager;

/**
 * Created by ilimturan on 18/01/15.
 */
public class CoinGold extends Entity {

    //protected ParticleEffect smokeEffect;

    public CoinGold(Vector2 pos, Vector2 direction) {

        super(new Texture(Gdx.files.internal("coin_gold.png")), pos, direction);
        this.eType = 2;
        /*
        smokeEffect = new ParticleEffect();
        smokeEffect.load(Gdx.files.internal("effects/get_golds_3.p"), Gdx.files.internal("effect_img"));
        smokeEffect.setPosition(this.pos.x + 50, this.pos.y + 50);
        smokeEffect.start();
        */

    }

    @Override
    public void update() {
        pos.add(direction);
    }


    public void render(SpriteBatch sb){
        //this.smokeEffect.draw(sb);
        //sb.draw(texture, pos.x, pos.y, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 20.2F);
        sb.draw(texture, this.pos.x, this.pos.y);

    }

}
