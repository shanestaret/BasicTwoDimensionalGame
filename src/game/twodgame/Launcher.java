package game.twodgame;

import game.twodgame.game.twodgame.display.Display;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Tile Game!", 640, 360);
        game.start();
    }
}
