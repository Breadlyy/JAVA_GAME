package Mechanics;

import draw.ImageGetter;
import draw.Tile;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class TileParsed
{

    public static class Coords
    {
        int x, y;


        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public JSONObject toJSON()
        {
            JSONObject obj = new JSONObject();
            obj.put("x", x);
            obj.put("y", y);
            return obj;
        }
    }

    GamePanel gp;
    BufferedImage image;
    public ArrayList<Coords> coords = new ArrayList<>();
    String src;
    public boolean collision;
    public boolean canget;
    public int height, width;
    public String type;

    public TileParsed(GamePanel gp) {
        this.gp = gp;
    }

    public TileParsed(TileParsed tp)
    {
        this.gp = tp.gp;
        this.image = tp.image;
        this.type = tp.type;
        this.height = tp.height;
        this.coords = tp.coords;
        this.canget = tp.canget;
        this.collision= tp.collision;
        this.width = tp.width;
        this.src = tp.src;
    }
    public void setImage(String url) {
            this.image = ImageGetter.getImage(url);
            height = image.getHeight();
            width = image.getWidth();
            src = url;
    }

    public void addCoord(int x, int y)
    {
        coords.add(new Coords(x, y));
    }
/*
    public void parse()
    {
        coords.add(new Coords(23, 23));
        coords.add(new Coords(23, 23 + 115));
        image = ImageGetter.getImage("tiles/tile1.png");
    }
*/
    public void draw(Graphics2D g2, int deltax)
    {
        for (Coords coord: coords)
        {
            g2.drawImage(image, coord.x+deltax, coord.y, null);
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}
