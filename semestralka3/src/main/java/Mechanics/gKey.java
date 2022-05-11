package Mechanics;

import java.awt.image.BufferedImage;

public class gKey extends Item{
    public gKey(GamePanel gp) {
        super(gp);
    }
    private static BufferedImage keyImg;

    public gKey(TileParsed tp)
    {
        super(tp);
        keyImg = tp.image;
    }

}
