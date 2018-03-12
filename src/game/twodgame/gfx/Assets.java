package game.twodgame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Shane on 3/11/2018.
 */
public class Assets {
    public static BufferedImage charLeft, charRight, oBlock, bBlock, gCoin;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/AllSprites.png"));
        charLeft = sheet.crop(0, 0, 26, 101);
        charRight = sheet.crop(26, 0, 26, 101);
        oBlock = sheet.crop(52, 69, 32, 32);
        bBlock = sheet.crop(52, 37, 32, 32);
        gCoin = sheet.crop(64, 17, 20, 20);
    }
}
