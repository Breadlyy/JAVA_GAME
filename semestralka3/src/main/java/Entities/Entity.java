package Entities;

import Mechanics.Item;
import Mechanics.TileParsed;


import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Entity
{
    public float x = 500;
    public float y = 500;
    public int speed = 4;

    public boolean can_be_moved;
    public int attack_speed;
    public String direction = "left";
    public String type;
    public double radiusToGet;
    public int radiusAttack;

    public ArrayList<Item> items;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public BufferedImage actualImage;

    public float xNext = 500;
    public float yNext = 500;
    public int spriteCounter = 0;
    public int spriteNum;

    public int health;
    public int damage;
    public Rectangle solidArea;
    public boolean collision_on = false;


    public Entity()
    {

    }
    public Entity(Entity e)
    {
        this.type = e.type;
        this.radiusAttack = e.radiusAttack;
        this.items = e.items;
        this.x = e.x;
        this.y = e.y;
        this.up1 = e.up1;
        this.up2 = e.up2;
        this.down1 = e.down1;
        this.down2 = e.down2;
        this.left1 = e.left1;
        this.left2 = e.left2;
        this.right1 = e.right1;
        this.right2 = e.right2;
        this.health = e.health;
        this.damage = e.damage;;

    }


    public int getHealth() {
        return health;
    }

    public void give(TileParsed tile){

    }

    public void draw(Graphics2D g2)
    {

        g2.drawImage(actualImage, Math.round(x), Math.round(y), 64, 64, null);

    }

    public void draw(Graphics2D g2, int deltax)
    {

        g2.drawImage(actualImage, Math.round(x+deltax), Math.round(y),64,64, null);

    }

    public void update()
    {

    }
}
