package Entities;

import Mechanics.Item;
import Mechanics.TileParsed;


import java.awt.*;
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
    public ArrayList<TileParsed> items;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public int attack_speed;

    public String direction = "left";
    public String type;
    public double radiusToGet;
    public ArrayList<TileParsed> items;
    BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public ArrayList<Item> items;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public float xNext = 500;
    public float yNext = 500;
    public int spriteCounter = 0;
    public int spriteNum;

    public int health;
    public int damage;
    public Rectangle solidArea;
    public boolean collision_on = false;


    public int getHealth() {
        return health;
    }

    public void give(TileParsed tile){

    }

    public void draw(Graphics2D g2)
    {

        BufferedImage image = down1;
        g2.drawImage(image, Math.round(x), Math.round(y), 64, 64, null);

    }

    public void draw(Graphics2D g2, int deltax)
    {


        BufferedImage image = down1;
        g2.drawImage(image, Math.round(x+deltax), Math.round(y), 64, 64, null);

    }

    public void update()
    {

    }
}
