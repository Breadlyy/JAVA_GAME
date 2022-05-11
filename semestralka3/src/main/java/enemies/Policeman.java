package enemies;

import Entities.Entity;
import Mechanics.GamePanel;
import draw.ImageGetter;

import java.util.Random;

public class Policeman extends Entity {
    private int actionLockCounter = 0;


    public Policeman(GamePanel gp)
    {
        speed = 3;
        health = 100;
        attack_speed = 2;
        x = 850;
        y = 230;

        getImage();
    }

    public void getImage()
    {
        down1 = ImageGetter.getImage("enemies/policeman_down1.png");
    }
    public void setAction()
    {

        if(!can_be_moved)
        {
            speed = 0;
        }
        else speed = 1;

        actionLockCounter ++;
        if(actionLockCounter == 100)
        {
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i <= 25)
            {

                can_be_moved = false;
                if(y > 80){
                    can_be_moved = true;
                    if(can_be_moved)
                    {
                        direction = "up";
                    }
                }

            }
            if(i > 25 && i <= 50)
            {
                can_be_moved = false;
                if(y < 800 - 80)
                {
                    can_be_moved = true;
                    if(can_be_moved)
                    {
                        direction = "down";
                    }
                }
            }
            if(i > 50 && i <= 75)
            {
                can_be_moved = false;
                if(x > 80)
                {
                    can_be_moved = true;
                    if(can_be_moved)
                    {
                        direction = "left";
                    }
                }

            }
            if(i > 75 && i <= 100)
            {
                can_be_moved = false;
                if(x <  1920 - 80)
                {
                    can_be_moved = true;
                    if(can_be_moved)
                    {
                        direction = "right";
                    }

                }


                direction = "up";
            }
            if(i > 25 && i <= 50)
            {
                direction = "down";
            }
            if(i > 50 && i <= 75)
            {
                direction = "left";
            }
            if(i > 75 && i <= 100)
            {
                direction = "right";

            }
            actionLockCounter = 0;
        }
        if(direction == "up")
        {
         y = y - speed;
        }
        if(direction == "down")
        {
        y = y + speed;
        }
        if(direction == "left")
        {
        x = x - speed;
        }
        if(direction == "right")
        {
        x = x + speed;
        }
        }

    }


