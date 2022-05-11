package Mechanics;

import Entities.Entity;
import Entities.Player;
import draw.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

public class CollisionChecker
{
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    synchronized public boolean checkTile(Entity entity)
    {

        int leftX = Math.round( entity.xNext) + 16 + 1;
        int rightX = Math.round(entity.xNext) + 16 + 16 - 1 ;
        int topY = Math.round(entity.yNext) + 16 + 1;
        int bottomY = Math.round(entity.yNext) + 16 + 16 - 1;

        if(!entity.direction.equals("up")) {topY+= entity.speed;}
        if(!entity.direction.equals("down")){bottomY-=entity.speed;}
        if(!entity.direction.equals("left")){leftX+=entity.speed;}
        if(!entity.direction.equals("right")){rightX-=entity.speed;}

        if(gp.tm.tiles == null) return true;
        for(TileParsed tiletype: gp.tm.tiles)
        {

            if(entity.getClass()==Player.class)//TBD method only for player
            {
                Player player = (Player) entity;
                if (player.getClass() == Player.class) {
                    ArrayList<TileParsed.Coords> toRemove = new ArrayList<>();
                    for (TileParsed.Coords c : tiletype.coords)
                {
                        if (Math.sqrt((c.x - player.x - 32) * (c.x - player.x - 32) + (c.y - player.y - 32) * (c.y - player.y - 32)) <=  player.radiusToGet) {


                            if(tiletype.getClass() == Item.class ||tiletype.getClass() == gKey.class  || tiletype.getClass() == Weapon.class) {
                                System.out.println("close to sth");
                                if(player.last < 10) {
                                    player.give((Item)tiletype);
                                    toRemove.add(c);
                                }
                            }

                        }
                        /*player.y < yTop && p(player, (xleft, yTop)) < radius ||
player.y > yTop && player.y < yBottom && (leftX - player.x) < radius ||
player.y > yBottom && p(player, (xleft, yBottom)) < radius ||
*/



                        if(tiletype.type.equals("door") && player.getSpacetyped() && !((Door)tiletype).opened && player.getItemSelected()!=null &&player.getItemSelected().getClass()==gKey.class &&
                                ((player.y + 32 < c.y &&  ((c.x - player.x - 32) * (c.x - player.x - 32) + (c.y - player.y - 32) * (c.y - player.y - 32)) <= 25)
                                        || (player.y + 32 > c.y && player.y + 32 < (c.y + tiletype.height) && (c.x - player.x - 32) <= 20)
                                        ||(player.y + 32 < c.y && ((c.x - player.x - 32) * (c.x - player.x - 32) + (c.y + tiletype.height - player.y - 32) * (c.y+ tiletype.height - player.y - 32)) <= 25)))
                        {

                           ((Door)tiletype).open();
                        }
                    }
                    for (TileParsed.Coords trc : toRemove) {
                        tiletype.coords.remove(trc);
                    }
                }

            }
            if(tiletype.collision==true) {
                for (TileParsed.Coords c:tiletype.coords)
                {
                    if((((
                            ( leftX>c.x && leftX<(c.x + tiletype.width) )||( rightX>c.x && rightX<(c.x + tiletype.width)  )
                    ) && (
                            ( topY>c.y && topY<(c.y + tiletype.height) )||( bottomY>c.y && bottomY<(c.y + tiletype.height) )
                    )
                    )||(
                            (
                                    ( c.x>leftX && c.x<rightX )||( (c.x + tiletype.width)>leftX && (c.x + tiletype.width)<rightX  )
                            ) && (
                                    ( c.y>topY && c.y<bottomY )||( (c.y + tiletype.height)>topY && (c.y + tiletype.height)<bottomY )
                            )
                    )
                    )||(
                            (
                                    (
                                            ( leftX>c.x && leftX<(c.x + tiletype.width) )||( rightX>c.x && rightX<(c.x + tiletype.width)  )
                                    ) && (
                                            ( c.y>topY && c.y<bottomY )||( (c.y + tiletype.height)>topY && (c.y + tiletype.height)<bottomY )
                                    )
                            )||(
                                    (
                                            ( c.x>leftX && c.x<rightX )||( (c.x + tiletype.width)>leftX && (c.x + tiletype.width)<rightX  )
                                    ) && (
                                            ( topY>c.y && topY<(c.y + tiletype.height) )||( bottomY>c.y && bottomY<(c.y + tiletype.height) )
                                    )
                            )
                    ))
                    {
                        System.out.println("LeftX " + leftX +" < " + (c.x + tiletype.width));
                        System.out.println("rightX " + rightX + " > " + c.x);
                        System.out.println("topY " + topY + " < " + (c.y + tiletype.height));
                        System.out.println("bottomY " + bottomY + " > "+  c.y);
                        return false;
                    }

                /*if(leftX < (c.x + tiletype.width) || rightX > c.x || topY < (c.y + tiletype.height) || bottomY > c.y)
                {
                    System.out.println("LeftX " + leftX +" < " + (c.x + tiletype.width));
                    System.out.println("rightX " + rightX + " > " + c.x);
                    System.out.println("topY " + topY + " < " + (c.y + tiletype.height));
                    System.out.println("bottomY " + bottomY + " > "+  c.y);
                    return false;
                }*/
                }}
        }
        //System.out.println("Ok");
        return true;
    }
}
