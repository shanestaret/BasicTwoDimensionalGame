package game.twodgame;

import game.twodgame.game.twodgame.FPSCounter;
import game.twodgame.game.twodgame.display.Display;
import game.twodgame.game.twodgame.gfx.Assets;
import game.twodgame.game.twodgame.gfx.ImageLoader;
import game.twodgame.game.twodgame.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import static game.twodgame.game.twodgame.gfx.Assets.*;

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

    int x = 0;

    public void init() {
        display = new Display(title, width, height);
        Assets.init();
    }

    private void update() {
        x++;
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
        g.drawImage(charRight, x, 100, null);
        //Stop Drawing
        bs.show();
        g.dispose();
    }

    public void run() {
        init();
        int updates = 0;
        long timer = 0, currentFPSCount = 0, lastFPSCount = System.nanoTime();
        FPSCounter counter = new FPSCounter(60);

        while(running) {
            currentFPSCount = System.nanoTime();
            timer += currentFPSCount - lastFPSCount;
            lastFPSCount = currentFPSCount;

            if(counter.check()) {
                update();
                render();
                updates++;
            }
            if(timer >= 1e9) {
                System.out.println("Ticks and Frames: " + updates);
                updates = 0;
                timer = 0;
            }

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
