package Mechanics;

import java.awt.*;
import java.util.ArrayList;

public class TileManager {
    GamePanel gp;
    ArrayList<TileParsed> tiles;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = (new Parser().getTiles("./../level.json",gp));
    }

    public void add(TileParsed item, int x, int y)
    {
        for(TileParsed tile: tiles)
        {
            if(tile.type.equals(item.type))
            {
                tile.coords.add(new TileParsed.Coords(x,y));
                return;
            }
        }
        item.coords.add(new TileParsed.Coords(x,y));
        tiles.add(item);
    }

    public void draw(Graphics2D g2, int deltax)
    {
        for (TileParsed t:tiles)
        {
            t.draw(g2, deltax);
        }
    }
}
