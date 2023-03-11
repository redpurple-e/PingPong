package com.egshub;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    
    public int x;
    public int y;
    public int speed = 3;

    private final int offset = 1;

    public int width = 25;
    public int height = 4;

    public boolean left = false;
    public boolean right = false;

    public Player(int x, int y) {
        this.x = x - width/2;
        this.y = y - height - offset;
    }

    public void tick() {
        if (left) {
            x -= speed;
        }
        if (right) {
             x += speed;
        }


        if(x > Game.WIDTH - width - offset) {
            x = Game.WIDTH - width - offset;
        }

        if(x < offset) {
            x = offset;
        }
    }

    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.fillRect(x * Game.SCALE, y * Game.SCALE, width * Game.SCALE, height * Game.SCALE);
    }

}
