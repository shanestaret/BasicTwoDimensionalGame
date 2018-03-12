package game.twodgame;

import game.twodgame.game.twodgame.display.Display;

/**
 * Created by Shane on 3/11/2018.
 */
public class Game implements Runnable {
    private Display display;
    private String title;
    private int width, height;
    private boolean running = false;
    private Thread thread;

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
