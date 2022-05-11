package Mechanics;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Entities.Entity;
import draw.ImageGetter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser
{
    public ArrayList<TileParsed> getTiles(String filename, GamePanel gp)
    {
        ArrayList<TileParsed> tiles = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

            try
            {
                FileReader reader = new FileReader(filename);
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray tileList = (JSONArray)(((JSONObject) obj).get("tiles"));

                for (Object o: tileList) {
                    JSONObject o1 = (JSONObject)o;
                    String type = o1.get("type").toString();
                    TileParsed tp = new TileParsed(gp);
                    tp.type = type;
                    tp.setImage(o1.get("bg").toString());
                    tp.collision = (boolean)o1.get("collision");
                    tp.canget = (boolean)o1.get("canget");
                    JSONArray arr = (JSONArray) o1.get("coords");
                    for(Object o2:arr)
                    {
                        int x = Integer.parseInt(((JSONObject)o2).get("x").toString());
                        int y = Integer.parseInt(((JSONObject)o2).get("y").toString());
                        if(tp.getClass() == Door.class) System.out.println(x+ " "+ y);
                        tp.addCoord(x, y);
                    }


                    if (type.equals("item"))
                    {
                        Item i = new Item (tp);
                        tiles.add(i);
                        System.out.println("There is Item");
                    }
                    if(type.equals("weapon"))
                    {
                        Weapon w = new Weapon(tp);
                        w.damage = Integer.parseInt( o1.get("damage").toString());
                        w.radius = Integer.parseInt( o1.get("radius").toString());
                        tiles.add(w);
                        System.out.println("weapon");

                    }
                    if (type.equals("key"))
                    {
                        gKey i = new gKey (tp);
                        tiles.add(i);
                        System.out.println("There is Key");
                    }
                    else if (type.equals("door"))
                    {
                        Door d = new Door(tp);
                        d.image2 = ImageGetter.getImage(o1.get("bg2").toString());
                        tiles.add(d);
                        System.out.println("Therre is door");
                    }
                    else{ tiles.add(tp);}




                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        return tiles;
    }

    public ArrayList<Entity> parseEntities(String filename, GamePanel gp)
    {
        ArrayList<Entity> entities = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
            Object obj = jsonParser.parse(reader);
            JSONArray tileList = (JSONArray)(((JSONObject) obj).get("entities"));
            for (Object o: tileList) {
                JSONObject o1 = (JSONObject) o;
                String type = o1.get("type").toString();
                int damage = Integer.parseInt (o1.get("damage").toString());
                int radius = Integer.parseInt (o1.get("radius").toString());
                int x = Integer.parseInt (o1.get("x").toString());
                int y = Integer.parseInt (o1.get("y").toString());


                JSONArray items = (JSONArray)o1.get("items");
                ArrayList<Item> items1 = new ArrayList<>();
                for(Object o2:items)
                {
                    Item item = new Item(gp);
                    JSONObject o3 = (JSONObject) o2;
                    item.type = o3.get("type").toString();
                    item.image = ImageGetter.getImage(o3.get("bg").toString());
                    if(item.type.equals("weapon"))
                    {
                        Weapon w = new Weapon(item);
                        w.damage = Integer.parseInt( o3.get("damage").toString());
                        w.radius = Integer.parseInt( o3.get("radius").toString());
                        items.add(w);
                        continue;
                    }
                    items1.add(item);
                }
                Entity e = new Entity();
                e.type = type;
                e.x = x;
                e.y = y;
                e.items = items1;
                e.damage = damage;
                e.radiusToGet = radius;
                e.down1 = ImageGetter.getImage(o1.get("down1").toString());
                e.down2 = ImageGetter.getImage(o1.get("down2").toString());
                e.up1 = ImageGetter.getImage(o1.get("up1").toString());
                e.up2 = ImageGetter.getImage(o1.get("up2").toString());
                e.left1 = ImageGetter.getImage(o1.get("left1").toString());
                e.left2 = ImageGetter.getImage(o1.get("left2").toString());
                e.right1 = ImageGetter.getImage(o1.get("right1").toString());
                e.right2 = ImageGetter.getImage(o1.get("right2").toString());



                entities.add(e);

            }
        return entities;



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }
}
