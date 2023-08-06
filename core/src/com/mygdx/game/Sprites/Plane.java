package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Plane {
    private static final int GRAVITY = -35;
    private static final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Texture plane;
    private Rectangle bounds;

    public Plane(int x,int y){
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        plane = new Texture("plane.png");
        bounds = new Rectangle(x,y,plane.getWidth(), plane.getHeight());
    }

    public void update(float dt){
        if(position.y > 0)
        velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(MOVEMENT*dt,velocity.y,0);
        if(position.y <0)
            position.y = 0;
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPlane() {
        return plane;
    }
    public void jump(){
        velocity.y = 250;
    }
    public Rectangle getBounds(){
        return bounds;
    }
}
