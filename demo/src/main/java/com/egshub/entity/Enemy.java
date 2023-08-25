package com.egshub.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.egshub.main.Game;

public class Enemy extends Entity {

    public Enemy(double x, double y) {
        super(x, y, 0);
        
        setOffset(1);
        setWidth(25);
        setHeight(4);
    }
    
    public void tick() {
        setX(getX() + Game.ball.x - getX());

        
        if(getX() > Game.WIDTH - getWidth() - getOffset()) {
            setX(Game.WIDTH - getWidth() - getOffset());
        }

        if(getX() < getOffset()) {
            setX(getOffset());
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)getX() * Game.SCALE, (int)getY() * Game.SCALE, getWidth() * Game.SCALE, getHeight() * Game.SCALE);
    }

}
