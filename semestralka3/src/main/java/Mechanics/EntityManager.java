package Mechanics;

import Entities.Entity;
import enemies.Policeman;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager
{
    private ArrayList<Entity> entities;
    GamePanel gp;


    public EntityManager(GamePanel gp)
    {
        entities = new Parser().parseEntities("./../level.json", gp);
    }

    public void update()
    {
        if (entities == null) return;
        for (Entity e: entities)
        {
            if(e.type.equals("policeman"))
            {
                ((Policeman)e).update();
            }


        }
    }

    public void draw(Graphics2D g2, int deltax)
    {
        if (entities == null) return;
        for (Entity e: entities)
        {
            e.draw(g2, deltax);
        }
    }
}
