package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;

public class PlayState extends State  {
    private Texture plane;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        plane = new Texture("plane.png");
        cam.setToOrtho(false, Game.WIDTH/2,Game.HEIGHT/2);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(plane,50,50);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
