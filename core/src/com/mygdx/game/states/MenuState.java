package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;

public class MenuState extends State {
    private Texture background;
    private Texture playbtn;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playbtn = new Texture("plybtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
              gsm.set(new PlayState(gsm));
              dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
            sb.begin();
            sb.draw(background,0,0 , Game.WIDTH,Game.HEIGHT);
            sb.draw(playbtn, (Game.WIDTH/2)- (playbtn.getWidth()/2),Game.HEIGHT/2);
            sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
    }
}