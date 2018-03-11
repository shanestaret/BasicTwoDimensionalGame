package game.twodgame.game.twodgame.display;

import javax.swing.*;

/**
 * Created by Shane on 3/10/2018.
 */
public class Display {

    private JFrame frame;
    private String title;
    int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
