package com.egshub;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    

    public void tick() {

    }

    public void render(Graphics g) {
        
        final int w_bar = 25 * Game.SCALE;
        final int h_bar = 4 * Game.SCALE;

        final int x_pos = 5 * Game.SCALE;
        final int y_pos = Game.SHEIGHT - (h_bar + 1 * Game.SCALE);

        g.setColor(Color.blue);
        g.fillRect(x_pos, y_pos, w_bar, h_bar);
    }

}
