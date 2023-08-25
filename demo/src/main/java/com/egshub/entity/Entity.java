package com.egshub.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
    
    private double x, y, speed;
    private int width, height;
    private int offset;

    private Rectangle bounds;
    
    public Entity(double x, double y, double speed) {
        this.x = x - width/2;
        this.y = y + offset;
        this.speed = speed;
        
        bounds = new Rectangle((int) x, (int) y, width, height);
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    
}
