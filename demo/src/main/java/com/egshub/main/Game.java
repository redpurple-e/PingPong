package com.egshub.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.egshub.entity.Ball;
import com.egshub.entity.Enemy;
import com.egshub.entity.Player;


public class Game extends Canvas implements Runnable, KeyListener {

    public static int WIDTH = 230;
    public static int HEIGHT = 120;
    public static int SCALE = 3;

    public static int SWIDTH = WIDTH* SCALE;
    public static int SHEIGHT = HEIGHT * SCALE;
    

    public BufferedImage layer = new BufferedImage(SWIDTH, SHEIGHT, BufferedImage.TYPE_INT_RGB);
    
    public Player player;
    public Enemy enemy;
    public static Ball ball;

    public Game() {
        this.setPreferredSize(new Dimension(SWIDTH, SHEIGHT));
        this.addKeyListener(this);

        player = new Player(HEIGHT, WIDTH/2, 2);
        enemy = new Enemy(WIDTH/2, 1);
        ball = new Ball(WIDTH/2, HEIGHT/2, 1);
    }
    
    public static void main( String[] args ) {
    
        Game game = new Game();
        JFrame frame = new JFrame("Meu Ping Pong");
    
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new Thread(game).start();
    }

    public void tick() {
        player.tick();
        enemy.tick();
        ball.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = layer.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SWIDTH, SHEIGHT);
        player.render(g);
        enemy.render(g);
        ball.render(g);

        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, SWIDTH, SHEIGHT, null);

        bs.show();
    }

    @Override
    public void run() {
        requestFocus();
       // throw new UnsupportedOperationException("Unimplemented method 'run'");

        while(true) {
            tick();
            render();
            
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;
        }
        
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = false;
        }
        
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = false;
        }

    }
}
