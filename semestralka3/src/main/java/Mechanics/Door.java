package Mechanics;

import java.awt.image.BufferedImage;

public class Door extends TileParsed
{
    public BufferedImage image2;
    boolean opened = false;
    public Door(GamePanel gp) {
        super(gp);
    }
    public Door(TileParsed tp)
    {
        super(tp);
    }

    public void open()
    {
        image = image2;
        opened = true;
        width+=height;
        height = width-height;
        width = width-height;
        coords.set(0, new Coords(coords.get(0).x-width + height, coords.get(0).y));
        System.out.println(coords.get(0).x+ " "+ coords.get(0).y);
    }
}
