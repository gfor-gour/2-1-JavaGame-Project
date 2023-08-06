package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.Sprites.Plane;
import com.mygdx.game.Sprites.Tube;

public class PlayState extends State  {
    private Plane plane;
    private Texture bg;
    private Tube tube;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        plane = new Plane(50,300);
        cam.setToOrtho(false, Game.WIDTH/2,Game.HEIGHT/2);
        bg = new Texture("bg.png");
        tube = new Tube(100);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched())
            plane.jump();
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
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2),0);
        sb.draw(plane.getPlane(),plane.getPosition().x,plane.getPosition().y);
        sb.draw(tube.getTopTube(), tube.getPosTopTube().x , tube.getPosTopTube().y);
        sb.draw(tube.getBottomTube(), tube.getPosBotTube().x , tube.getPosBotTube().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
