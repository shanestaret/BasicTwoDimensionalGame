package game.twodgame;

import game.twodgame.game.twodgame.display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

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

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void init() {
        display = new Display(title, width, height);
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
