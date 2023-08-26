package com.egshub.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.egshub.main.Game;

public class Ball extends Entity {

    public double dx, dy;
    private double mod;

    public Ball(double x, double y, double speed) {
        super(x, y, speed);

        setWidth(4);
        setHeight(4);

        dx = new Random().nextGaussian();
        dy = new Random().nextGaussian();
        
        mod = Math.sqrt(dx*dx + dy*dy);
        if(new Random().nextInt(2) == 1) mod *= -1;
    }
    
    public void tick() {
        setX(getX() + Math.cos(mod) * getSpeed());
        setY(getY() + Math.sin(mod) * getSpeed());
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int) getX()*Game.SCALE, (int) getY()*Game.SCALE, getWidth()*Game.SCALE, getHeight()*Game.SCALE);
        ///g.fillRect((int)getX() * Game.SCALE, (int)getY() * Game.SCALE, getWidth() * Game.SCALE, getHeight() * Game.SCALE);
    }
}
