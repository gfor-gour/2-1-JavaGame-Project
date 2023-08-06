package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Game;
import com.mygdx.game.Sprites.Plane;
import com.mygdx.game.Sprites.Tube;

public class PlayState extends State  {

    private static final int TUBE_SPACING = 200;
    private static final int TUBE_COUNT = 4;
    private Plane plane;
    private Texture bg;

    private com.badlogic.gdx.utils.Array<Tube> tubes;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        plane = new Plane(20,400);
        cam.setToOrtho(false, Game.WIDTH/2,Game.HEIGHT/2);
        bg = new Texture("bg.png");

        tubes = new Array<Tube>();
            for(int i=1; i<= TUBE_COUNT; i++){
                tubes.add(new Tube(i*(TUBE_SPACING + Tube.TUBE_WIDTH)));
            }

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
        cam.position.x = plane.getPosition().x + 80;
        for(Tube tube: tubes){
            if(cam.position.x - (cam.viewportWidth/2)> tube.getPosTopTube().x + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }

            if(tube.collides(plane.getBounds()))
                gsm.set(new PlayState(gsm));
        }
        cam.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2),0);
        sb.draw(plane.getPlane(),plane.getPosition().x,plane.getPosition().y);
        for(Tube tube : tubes){
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x,tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(),tube.getPosBotTube().x,tube.getPosBotTube().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
