package game.twodgame.game.twodgame;

/**
 * Created by Shane on 3/11/2018.
 */
public class FPSCounter {
    private double timePerUpdate;
    private double delta;
    private long now;
    private long lastTime = System.nanoTime();

    public FPSCounter(int fps) {
        timePerUpdate = 1e9 / fps;
        delta = 0;
        lastTime = System.nanoTime();
    }

    public boolean check() {
        now = System.nanoTime();
        delta = (now - lastTime) / timePerUpdate;

        if(delta >= 1) {
            lastTime = now;
            return true;
        }

        return false;
    }
}
