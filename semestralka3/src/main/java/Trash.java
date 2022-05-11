/*import Mechanics.TileParsed;
import Mechanics.GamePanel;
import Mechanics.Parser;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Trash
{
    public static void main(String[] args) {
        ArrayList<Mechanics.TileParsed> alltiles = new ArrayList<>();
        Mechanics.TileParsed tile = new Mechanics.TileParsed(new Mechanics.GamePanel());
        tile.addCoord(23,23);
        tile.addCoord(23+115, 23);
        tile.addCoord(23, 23+115);
        tile.addCoord(23+115, 23+115);
        tile.setImage("tiles/tile1.png");

        alltiles.add(tile);

        JSONArray arr = new JSONArray();
        JSONObject obj;
        FileWriter file = null;




        for(Mechanics.TileParsed tile1: alltiles)
        {
            obj = new JSONObject();
            obj.put("bg", tile1.src);
            JSONArray array = new JSONArray();
            for (Mechanics.TileParsed.Coords c: tile.coords) {
                array.put(c.toJSON());
            }
            obj.put("coords", array);
            arr.put(obj);
        }
        try {
            file = new FileWriter("./../level.json");
            file.write(arr.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Mechanics.Parser p = new Mechanics.Parser();
        p.getTiles("./../level.json", new Mechanics.GamePanel());
    }
}*/
