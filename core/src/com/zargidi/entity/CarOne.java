package com.zargidi.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ilimturan on 18/01/15.
 */
public class CarOne extends Car {


    public CarOne(Vector2 pos, Vector2 direction) {

        super("CAR1", "L", new Texture(Gdx.files.internal("car1.png")), pos, direction);

    }

    @Override
    public void update() {

        pos.add(direction);

        if (Gdx.input.justTouched()) {

            int touchXCoordinant = Gdx.input.getX();

            if (touchXCoordinant < Gdx.graphics.getWidth() / 2) {
                if (lane == "L") {

                    this.pos = new Vector2((3 * Gdx.graphics.getWidth() / 8) - (carWidth / 2), 20);
                    lane = "R";

                } else {
                    this.pos = new Vector2((1 * Gdx.graphics.getWidth() / 8) - (carWidth / 2), 20);
                    lane = "L";
                }


            }
        } else {
            setDirection(0, 0);
        }
        this.smokeEffect.setPosition(this.pos.x + carWidth / 2, this.pos.y + carHeight / 10);
        this.smokeEffect.update(Gdx.graphics.getDeltaTime());

    }


}
