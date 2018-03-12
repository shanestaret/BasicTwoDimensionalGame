package game.twodgame;

import game.twodgame.game.twodgame.display.Display;
import game.twodgame.game.twodgame.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by Shane on 3/11/2018.
 */
public class Game implements Runnable {
    private Display display;
    private String title;
    private int width, height;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage test;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void init() {
        display = new Display(title, width, height);
        test = ImageLoader.loadImage("/textures/AllSprites.png");
    }

    private void update() {

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0,width,height);
        //Draw Stuff
        g.drawImage(test, 20, 20, null);
        //Stop Drawing
        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        while(running) {
            update();
            render();
        }

        stop();
    }

    public synchronized void start() {
        if(!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if(running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
