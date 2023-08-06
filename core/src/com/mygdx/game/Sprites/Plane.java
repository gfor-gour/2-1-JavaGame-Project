package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Plane {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Texture plane;

    public Plane(int x,int y){
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        plane = new Texture("plane.png");
    }

    public void update(float dt){
        if(position.y > 0)
        velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(MOVEMENT*dt,velocity.y,0);
        if(position.y <0)
            position.y = 0;
        velocity.scl(1/dt);
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
}
