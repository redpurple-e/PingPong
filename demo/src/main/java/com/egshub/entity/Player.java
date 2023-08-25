package com.egshub.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.egshub.main.Game;

public class Player extends Entity {
    
    public boolean left = false;
    public boolean right = false;
    
    public Player(double x, double y, double speed) {
        super(x, y, speed);

        setOffset(1);
        setWidth(25);
        setHeight(4);
    }
    
    public void tick() {
        if(left) {
            setX(getX() - getSpeed());
        } else if(right) {
            setX(getX() + getSpeed());
        }
        
        if(getX() > Game.WIDTH - getWidth() + getOffset()) {
            setX(Game.WIDTH - getWidth() - getOffset());
        }
        if(getX() < getOffset()) {
            setX(getOffset());
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)getX() * Game.SCALE, (int)getY() * Game.SCALE, getWidth() * Game.SCALE, getHeight() * Game.SCALE);
    }
}
