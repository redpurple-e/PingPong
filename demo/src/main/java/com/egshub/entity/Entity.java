package com.egshub.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
    
    private double x, y, speed;
    private static int width, height;
    private final int offset = 1;

    private Rectangle bounds;

    
    public Entity(double x, double y, double speed) {
        this.x = x - width/2;
        this.y = y + offset;
        this.speed = speed;

        bounds = new Rectangle((int) x, (int) y, width, height);
    }
    
    public void tick() {}

    public void render(Graphics g) {}

    
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public double getSpeed() {
        return this.speed;
    }
    public int getOffset() {
        return this.offset;
    }

}
