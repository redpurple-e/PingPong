package com.egshub;

import java.awt.image.BufferedImage;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


public class Game extends Canvas implements Runnable {

    public static int WIDTH = 240;
    public static int HEIGHT = 120;
    public static int SCALE = 3;

    public static int SWIDTH = WIDTH* SCALE;
    public static int SHEIGHT = HEIGHT * SCALE;
    

    public BufferedImage layer = new BufferedImage(SWIDTH, SHEIGHT, BufferedImage.TYPE_INT_RGB);
    
    public Player player;

    public Game() {
        this.setPreferredSize(new Dimension(SWIDTH, SHEIGHT));

        player = new Player();
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
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = layer.getGraphics();
        player.render(g);

        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, SWIDTH, SHEIGHT, null);

        bs.show();
    }




    @Override
    public void run() {
        // TODO Auto-generated method stub
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
}
