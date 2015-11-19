package com.zargidi.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ilimturan on 18/01/15.
 */
public abstract class Entity {

    public int eType = 0;
    protected Texture texture;
    protected Vector2 pos, direction;

    public Entity(Texture texture, Vector2 pos, Vector2 direction){
        this.texture = texture;

        this.pos = pos;
        this.direction = direction;

    }

    public abstract void update();

    public void render(SpriteBatch sb){

        sb.draw(texture, pos.x, pos.y);

    }

    public Vector2 getPos(){
        return pos;
    }

    public void setDirection(float x, float y){
        direction.set(x,y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }

    public float getCenterX(){
        return this.pos.x + (this.texture.getWidth() / 2);
    }

    public float getCenterY(){
        return this.pos.y + (this.texture.getHeight() / 2);
    }

    public Rectangle getBounds(){

        if(this instanceof CarOne || this instanceof  CarTwo){
            return new Rectangle(this.pos.x, this.pos.y, texture.getWidth(), texture.getHeight());
        }

        //for coin
        return new Rectangle(this.pos.x, this.pos.y - texture.getHeight(), texture.getWidth(), texture.getHeight() * 3 / 2 );
    }



}
