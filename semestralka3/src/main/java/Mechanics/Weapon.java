package Mechanics;

public class Weapon extends Item
{
    public int radius;
    public int damage;

    public Weapon(GamePanel gp) {
        super(gp);
    }

    public Weapon(TileParsed tp)
    {
        super(tp);
    }
}
