package game.twodgame;

import game.twodgame.game.twodgame.display.Display;

/**
 * Created by Shane on 3/11/2018.
 */
public class Game {
    private Display display;
    private int width, height;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        display = new Display(title, width, height);
    }
}
