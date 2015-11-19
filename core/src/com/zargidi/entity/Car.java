package com.zargidi.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.zargidi.ccar.MainGame;
import com.zargidi.ccar.TextureManager;

/**
 * Created by ilimturan on 18/01/15.
 */
public abstract  class Car extends Entity {

    protected String lane = "L";
    protected int carWidth;
    protected int carHeight;
    protected ParticleEffect smokeEffect;

    public Car(String name, String lane, Texture texture, Vector2 pos, Vector2 direction) {

        super(texture, pos, direction);

        this.eType = 1;

        if(name.equals("CAR1")){
            carWidth = TextureManager.CAR1.getWidth();
            carHeight = TextureManager.CAR1.getHeight();
        }else if(name.equals("CAR2")){
            carWidth = TextureManager.CAR2.getWidth();
            carHeight = TextureManager.CAR2.getHeight();
        }


        smokeEffect = new ParticleEffect();
        smokeEffect.load(Gdx.files.internal("effects/car_smoke_1.p"), Gdx.files.internal("effect_img"));
        smokeEffect.setPosition(this.pos.x + carWidth / 2, this.pos.y + carHeight / 10 );
        smokeEffect.start();
    }



    @Override
    public void render(SpriteBatch sb){
        smokeEffect.draw(sb);
        sb.draw(texture, this.pos.x, this.pos.y);
    }
}
