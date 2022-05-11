package Entities;

import Mechanics.*;
import draw.ImageGetter;
<<<<<<< HEAD
import enemies.Policeman;
=======
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity
{
    GamePanel gp;
    KeyHandler keyh;

    public int deltax, deltaxNext;
    boolean collision;
    private boolean haskey = false;
    public int damage;
    public int radius;
    public Item ItemSelected;
    public int selected;
    public Item[] inventory = new Item[10];
    public int last = 0;
    private static final int defaultRadius = 20;
    private static final int defaultDamage = 4;
<<<<<<< HEAD
    public boolean invincible;
    private int invincibleCounter = 0;
=======
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853

    public Player(GamePanel gp, KeyHandler keyh) {
        this.gp = gp;
        this.keyh = keyh;
        this.radiusToGet = 20;
<<<<<<< HEAD
        health = 20;
        getImage();
        solidArea = new Rectangle(0, 0, 16,16);

=======
        health = 19;
        getImage();
<<<<<<< HEAD
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853
=======
        solidArea = new Rectangle(0, 0, 16,16);

>>>>>>> 317e7494f493cf3a2bea6ef0ddcf464a8b208d08
    }

    public boolean getSpacetyped()
    {
        return keyh.space;
    }

    public void getImage()
    {
            up1 = ImageGetter.getImage("entities/up1.png");
            up2 = ImageGetter.getImage("entities/up2.png");
            down1 = ImageGetter.getImage("entities/down1.png");
            down2 = ImageGetter.getImage("entities/down2.png");
            left1 = ImageGetter.getImage("entities/left1.png");
            left2 = ImageGetter.getImage("entities/left2.png");
            right1 = ImageGetter.getImage("entities/right1.png");
            right2 = ImageGetter.getImage("entities/right2.png");
    }

    public void give(Item item)
    {
        int index = getFirstNull();
        if(index!=-1) {
            if (item.type.equals("magnet"))
            {
                this.radiusToGet *= 1.10;
            }
            if (item.type.equals("key"))
            {
                System.out.println("Player has key");
                haskey = true;
            }
            inventory[index] = item;
        }
    }

    public void throwOut()
    {
        if(ItemSelected!=null)
        {

            gp.tm.add(ItemSelected, (int)x+20, (int)y);
            ItemSelected = null;
            inventory[selected] = null;
        }
    }

    public boolean isHaskey() {
        return haskey;
    }

    public void selectItem(int num)
    {
        ItemSelected = inventory[num-1];
        selected = num-1;
        if(inventory[num-1]!=null && inventory[num-1].getClass() == Weapon.class)
        {
            damage = ((Weapon)ItemSelected).damage;
            radius = ((Weapon)ItemSelected).radius;

        }
        else
        {
            damage = defaultDamage;
            radius = defaultRadius;
        }
        System.out.println("Selected "+num);
    }
<<<<<<< HEAD
    public void contactPoliceman(Policeman policeman)
    {
        if(x < policeman.x + policeman.radiusAttack && x > policeman.x - policeman.radiusAttack && y < policeman.y + policeman.radiusAttack && y > policeman.y - policeman.radiusAttack)
        {
                health = health - policeman.damage;
                System.out.println("Damaged. Health = " + health);
                invincible = true;
        }
    }
    public void update()
    {
        if(invincible)
        {
            invincibleCounter++;
            if(invincibleCounter > 60)
            {
                invincible = false;
                invincibleCounter = 0;
            }


        }
=======

    public void update()
    {
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853
        synchronized (this){
        if(keyh.right || keyh.up || keyh.left || keyh.down)  spriteCounter++;
        if(keyh.right && keyh.up)
        {
            direction = "up";
            if(y>0 && x < 1920-64) {
                if(deltax > -380 && x >= 1200)
                {
                    deltaxNext=Math.round(deltax-speed/(1.4f));
                    xNext = x + speed/(1.4f) ;
                    yNext= y - speed/(1.4f);
                }
                else {
                    xNext = x + speed / (1.4f);
                    yNext = y - speed / (1.4f);
                }
            }
            else if(y>0){
                yNext = y - speed;
                xNext = x;
            }
            else if(x<1920-64) {
                if(deltax > -380 && x >= 1200)
                {
                    deltaxNext-= deltax - speed;
                    xNext = x;
                    yNext = y;
                }
                else {
                    xNext = x + speed;
                    yNext = y;
                }
            }
        }
        else if (keyh.up && keyh.left)
        {
            direction = "up";
            if(y<800-64 && x > 0 )
            {
                if(deltax < 0 && x < 800)
                {
                    deltaxNext=Math.round(deltax + speed/(1.4f));
                    xNext = x - speed/(1.4f);
                    yNext = y - speed/(1.4f);
                }
                else {
                    xNext = x - speed / (1.4f);
                    yNext = y - speed / (1.4f);
                }
            }
            else if(y<800-64)
            {
                xNext = x;
                yNext= y - speed;
            }
            else if(x>0) if(deltax<0 && x < 800)
            {
                deltaxNext= deltax + speed;
                xNext = x - speed;
                yNext = y;
            }
            else
            {
                xNext = x - speed;
                yNext = y;
                deltaxNext = deltax;
            }
        }

        else if (keyh.left && keyh.down)
        {
            direction = "down";
            if(y<800-64 && x > 0 )
            {
                if(deltax<0 && x < 300 - deltax)
                {
                    deltaxNext=Math.round(deltax + speed/(1.4f));
                    xNext = x - speed/(1.4f);
                    yNext= y + speed/(1.4f);
                }
                else {
                    xNext = x - speed / (1.4f);
                    yNext = y + speed / (1.4f);
                }
            }
            else if(y<800-64)
            {
                yNext=y + speed;
            }
            else if(x>0) if(deltax<0 && x < 300 - deltax)
            {
                deltaxNext=deltax + speed;
                xNext = x - speed;
            }
            else xNext=x-speed;
        }
        else if(keyh.down && keyh.right)
        {
            direction = "down";
            if(y<800-64 && x < 1920-64) {
                if(deltax > -380 && x >= 1200)
                {
                    deltaxNext=Math.round(deltax-speed/(1.4f));
                    xNext = x + speed/(1.4f);
                    yNext = y + speed / (1.4f);
                }
                else {
                    xNext = x + speed / (1.4f);
                    yNext = y + speed / (1.4f);
                }
            }
            else if(y<800-64) yNext= y + speed;
            else if(x<1920-64) {
                if(deltax > -380 && x >= 1200)
                {
                    deltaxNext = deltax - speed;
                    xNext = x + speed;
                }
                else xNext=x+speed;
            }
        }
        else if(keyh.right)
        {
            direction = "right";
            if(x<1920-64)
            {
                if(deltax > -380 && x >= 1200)
                {
                    deltaxNext= deltax-speed;

                }
                xNext= x +speed;
            }
        }
        else if (keyh.up)
        {
            direction = "up";
            if(y>0) yNext = y-speed;
        }
        else if(keyh.left)
        {
            direction = "left";
            if(x>0)
            {
                if(deltax<0 && x < 300 - deltax)
                {
                    deltaxNext=deltax+speed;
                }
                xNext=x-speed;
            }
        }
        else if (keyh.down)
        {
            direction = "down";
            if(y<800-64) yNext = y + speed;
        }

        if(spriteCounter>10)
        {
            spriteCounter = 0;
            spriteNum = spriteNum==1?2:1;
        }


        if(gp.cc.checkTile(this))
        {
            y = yNext;
            x = xNext;
            deltax = deltaxNext;
        }
    }}

    public void draw(Graphics2D g2)
    {

        BufferedImage image = null;
        switch (direction)
        {
            case("up"): image = (spriteNum==1)?up1:up2; break;
            case("left"): image = (spriteNum==1)?left1:left2; break;
            case("down"): image = (spriteNum==1)?down1:down2; break;
            case("right"): image = (spriteNum==1)?right1:right2; break;
            default: image = left1;
            System.out.println("coords" + x+ " " + y);
        }

        g2.drawImage(image, Math.round(x + deltax), Math.round(y), 64, 64, null);

    }

    public Item getItemSelected() {
        return ItemSelected;
    }

    public int getFirstNull()
    {
        for (int i = 0; i < 10; i++)
        {
            if(inventory[i]==null) return i;
        }
        return -1;
    }

}
