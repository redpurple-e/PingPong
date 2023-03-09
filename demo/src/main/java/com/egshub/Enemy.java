package com.egshub;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

    public double x, y;

    public static int width = 25;
    public static int height = 4;

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)x * Game.SCALE, (int)y * Game.SCALE, width * Game.SCALE, height * Game.SCALE);
    }

}
