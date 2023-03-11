package com.egshub;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemy {

    public double x, y;
    public double speed = 4;

    public int width = 25;
    public int height = 4;

    private int offset = 1;
    public double chance = new Random().nextInt(9);
    
    public Enemy(double x, double y) {
        this.x = x - width/2;
        this.y = y + offset;
    }
    
    public void tick() {
        
        x += (Game.ball.x - x) * (chance + 10) / 100;

        if(x > Game.WIDTH - width - offset) {
            x = Game.WIDTH - width - offset;
        }
        
        if(x < offset) {
            x = offset;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)x * Game.SCALE, (int)y * Game.SCALE, width * Game.SCALE, height * Game.SCALE);
    }

}
