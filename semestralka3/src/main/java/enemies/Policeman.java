package enemies;

import Entities.Entity;
import Entities.Player;
import Mechanics.EntityManager;
import Mechanics.GamePanel;
import draw.ImageGetter;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Policeman extends Entity {
    private int actionLockCounter = 0;
    private Player agressiveOn;
    private GamePanel gp;
    private static final int maxAgressive = 1000;
    private static final int maxCooldown = 60;
    private int agressiveCounter = 0;
    private int cooldown = 0;
    private int spritecounter = 0;

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }

    public Policeman(Entity e) {
        super(e);
        actualImage = down1;
    }

    public Policeman(GamePanel gp) {
        speed = 3;
        health = 100;
        attack_speed = 2;
        x = 850;
        y = 230;
        getImage();
    }

    public void getImage() {
        down1 = ImageGetter.getImage("enemies/policeman_down1.png");
    }

    public void update() {
        setAction();
    }

    public void setAction() {

        if(near(gp.player, radiusAttack) && cooldown == 0)
        {
            gp.player.contactPoliceman(this);
            cooldown = 100;
        }

        if(cooldown>0)cooldown--;

        if (!can_be_moved) {
            speed = 0;
        } else speed = 1;

        if(near(gp.player, 50))
        {
            agressiveOn = gp.player;
            agressiveCounter = maxAgressive;
        }

        if(agressiveCounter==0)
        {
            agressiveOn=null;
        }

        spritecounter++;
        if(spritecounter > 10) {
            System.out.println("aaa");
            switch (direction) {
                case ("up"): {
                    actualImage = (actualImage == up1) ? up2 : up1;
                    break;
                }
                case ("right"): {
                    actualImage = (actualImage == right1) ? right2 : right1;
                    break;
                }
                case ("left"): {
                    actualImage = (actualImage == left1) ? left2 : left1;
                    break;
                }
                case ("down"): {
                    actualImage = (actualImage == down1) ? down2 : down1;
                    break;
                }
            }
        }


        if (agressiveOn != null && !near(agressiveOn, radiusAttack)) {
            agressiveCounter--;

            if (agressiveOn.x > x && Math.abs(agressiveOn.x - x) > radiusAttack)
            {
                xNext += speed;
            } else if (agressiveOn.x < x && Math.abs(agressiveOn.x - x) > radiusAttack) {
                xNext -= speed;

            } else if (agressiveOn.y > y && Math.abs(agressiveOn.y - y) > radiusAttack) {
                yNext += speed;

            } else  if (Math.abs(agressiveOn.y - y) > radiusAttack){
                yNext -= speed;

            }}
        else{
                actionLockCounter++;
                if (actionLockCounter == 100) {
                    Random random = new Random();
                    int i = random.nextInt(100) + 1;
                    if (i <= 25) {

                        can_be_moved = false;
                        if (y > 80) {
                            can_be_moved = true;
                            if (can_be_moved) {
                                direction = "up";
                            }
                        }

                    }
                    if (i > 25 && i <= 50) {
                        can_be_moved = false;
                        if (y < 800 - 80) {
                            can_be_moved = true;
                            if (can_be_moved) {
                                direction = "down";
                            }
                        }
                    }
                    if (i > 50 && i <= 75) {
                        can_be_moved = false;
                        if (x > 80) {
                            can_be_moved = true;
                            if (can_be_moved) {
                                direction = "left";
                            }
                        }

                    }
                    if (i > 75 && i <= 100) {
                        can_be_moved = false;
                        if (x < 1920 - 80) {
                            can_be_moved = true;
                            if (can_be_moved) {
                                direction = "right";
                            }

                        }
                        direction = "up";
                    }
                    if (i > 25 && i <= 50) {
                        direction = "down";
                    }
                    if (i > 50 && i <= 75) {
                        direction = "left";
                    }
                    if (i > 75 && i <= 100) {
                        direction = "right";

                    }
                    actionLockCounter = 0;
                }
                if (direction == "up") {
                    yNext = y - speed;
                }
                if (direction == "down") {
                    yNext = y + speed;
                }
                if (direction == "left") {
                    xNext = x - speed;
                }
                if (direction == "right") {
                    xNext = x + speed;
                }
            }
        x = xNext;
        y = yNext;
        if(spritecounter>12) spritecounter=0;
        }

        private boolean near(Player p, int rad)
        {
            return (Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y)) < rad);
        }
    }



