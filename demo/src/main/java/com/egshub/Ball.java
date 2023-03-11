package com.egshub;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ball {
    public double x, y;

    public static int width = 4;
    public static int height = 4;

    private int offset = 1;

    public double dx, dy;
    public double speed = 1;

    public Ball(double x, double y) {
        this.x = x + width/2;
        this.y = y + height/2;

        dx = new Random().nextGaussian();
        dy = new Random().nextGaussian();
    }
    
    public void tick() {
        
        double mag = Math.sqrt(dx*dx + dy*dy);
        dx /= mag;
        dy /= mag;

        if(dx * speed + x > Game.WIDTH - width - offset) {
            dx *= -1;
            Game.enemy.chance = new Random().nextInt(99);
        }

        if(dx * speed + x < offset) {
            dx *= -1;
            Game.enemy.chance = new Random().nextInt(99);
        }

        Rectangle bounds = new Rectangle((int) (dx * speed + x), (int) (dy * speed + y), width, height);

        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
        Rectangle boundsEnemy = new Rectangle((int) (Game.enemy.x), (int) (Game.enemy.y), Game.enemy.width, Game.enemy.height);

        if(bounds.intersects(boundsPlayer)) {
            dy *= -1;
            Game.enemy.chance = new Random().nextInt(99);
        }
        if(bounds.intersects(boundsEnemy)) {
            dy *= -1;
            Game.enemy.chance = new Random().nextInt(99);
        }

        x += dx * speed;
        y += dy * speed;
        
        if(y > Game.HEIGHT - offset || y < offset) {
            // ponto do inimigo
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            new Game();
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x * Game.SCALE, (int)y * Game.SCALE, width * Game.SCALE, height * Game.SCALE);
    }

}
