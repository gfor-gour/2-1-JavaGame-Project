package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.Sprites.Plane;

public class PlayState extends State  {
    private Plane plane;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        plane = new Plane(50,300);
        cam.setToOrtho(false, Game.WIDTH/2,Game.HEIGHT/2);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        plane.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(plane.getPlane(),plane.getPosition().x,plane.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
