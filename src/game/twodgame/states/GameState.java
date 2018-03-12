package game.twodgame.states;

import java.awt.*;

import static game.twodgame.gfx.Assets.charLeft;

/**
 * Created by Shane on 3/12/2018.
 */
public class GameState extends State {
    public GameState() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(charLeft, 0, 0, null);
    }
}
