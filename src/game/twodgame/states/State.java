package game.twodgame.states;

import java.awt.*;

/**
 * Created by Shane on 3/12/2018.
 */
public abstract class State {
    private static State currentState = null;

    public static void setCurrentState(State state) {
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public abstract void update();
    public abstract void render(Graphics g);

}
