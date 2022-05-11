package Mechanics;

import java.awt.image.BufferedImage;

public class Item extends TileParsed
{
    public Item(GamePanel gp) {
        super(gp);
    }

    public Item(TileParsed tp)
    {
        super(tp);
    }

    public BufferedImage getImage()
    {
        return this.image;
    }
}
