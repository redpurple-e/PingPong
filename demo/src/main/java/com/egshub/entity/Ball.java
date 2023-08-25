package com.egshub.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.egshub.main.Game;

public class Ball {
    public double x, y;

    public static int width = 4;
    public static int height = 4;

    public double dx, dy, speed;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;

        dx = new Random().nextGaussian();
        dy = new Random().nextGaussian();
        speed = 0.5;
    }
    
    public void tick() {
        x += dx * speed;
        y += dy * speed;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x * Game.SCALE, (int)y * Game.SCALE, width * Game.SCALE, height * Game.SCALE);
    }

}
