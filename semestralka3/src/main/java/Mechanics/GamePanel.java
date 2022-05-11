package Mechanics;

<<<<<<< HEAD
<<<<<<< HEAD
import Entities.Entity;
import Entities.Player;
//import draw.AllObjects;
import draw.AssetSetter;
import draw.Background;
import draw.UI;
import enemies.Policeman;
=======
import Entities.Player;
//import draw.AllObjects;
import draw.Background;
import draw.UI;
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853
=======
import Entities.Entity;
import Entities.Player;
//import draw.AllObjects;
//import draw.AssetSetter;
import draw.Background;
import draw.UI;
import enemies.Policeman;
>>>>>>> 317e7494f493cf3a2bea6ef0ddcf464a8b208d08

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable
{
    public static final int runState  = 1;
    public static final int inventoryState = 2;
    public static final int menuState = 0;
    public static final String healthSrc = "icons/health.png";
    public static final String healthSrc1 = "icons/health1.png";


    final int originalTileSize = 16;
    public static final int scale= 4;
    public final int tilesize = originalTileSize *  scale;

    public static final int maxScreenCol  = 480;
    public static final int maxScreenRow = 200;

    public Player player;
    public static final int screenWidth = maxScreenCol * scale;
    final int screenHeight = maxScreenRow* scale;

    public int gameState = GamePanel.menuState;//Stopped = 0 running = 1 inventory = 2
    
    public TileManager tm = new TileManager(this);
    private EntityManager em = new EntityManager(this);

    KeyHandler keyh = new KeyHandler(this);
    Thread gameThread;
    public int deltax;
    Background bg;
    public CollisionChecker cc = new CollisionChecker(this);
    public UI ui = new UI(this);

<<<<<<< HEAD
<<<<<<< HEAD
    AssetSetter aSetter = new AssetSetter(this);
    public Entity enemies [] = new Entity[10];
    public Policeman policeman = new Policeman(this);

=======
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853
=======
    //AssetSetter aSetter = new AssetSetter(this);
    public ArrayList<Entity> enemies = new ArrayList<>();
    //public Policeman policeman = new Policeman(this);

>>>>>>> 317e7494f493cf3a2bea6ef0ddcf464a8b208d08



    public GamePanel ()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);

        synchronized (this){
            bg = new Background("./background/bg.png");
            player= new Player(this, keyh);}
        gameThread.start();
    }

    @Override
    public void run() {


        double drawINterval = 1000000000/60;
        double nextTime = System.nanoTime() + drawINterval;

        long delta;
        while(gameThread!=null)
        {
            update();

            repaint();

            try {
                double remainingtime = nextTime - System.nanoTime();
                remainingtime/=1000000;
                if(remainingtime< 0) remainingtime = 0;
                Thread.sleep((long)remainingtime);
                nextTime += drawINterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update()
    {
        if(gameState==runState) {
            player.update();
<<<<<<< HEAD
            player.contactPoliceman(this.policeman);
            policeman.setAction();
            bg.x = player.deltax;
            deltax = player.deltax;
            em.update();
        }
//        for(int i = 0; i < enemies.length; i++)
//        {
//            if(enemies[i] != null)
//            {
//                enemies[i].update();
//            }
//        }
<<<<<<< HEAD
=======
            bg.x = player.deltax;
            deltax = player.deltax;
        }
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853
=======
>>>>>>> 317e7494f493cf3a2bea6ef0ddcf464a8b208d08
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
<<<<<<< HEAD
<<<<<<< HEAD
        setUpGame();
        Graphics2D g2 = (Graphics2D) g;


=======
        Graphics2D g2 = (Graphics2D) g;
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853
=======
      //  setUpGame();
        Graphics2D g2 = (Graphics2D) g;


>>>>>>> 317e7494f493cf3a2bea6ef0ddcf464a8b208d08
        if(gameState==runState) {
            bg.draw(g2, deltax);
            tm.draw(g2, deltax);
            //System.out.println("a");
            em.draw(g2, deltax);
            player.draw(g2);
            ui.draw(g2);
<<<<<<< HEAD
           policeman.draw(g2);
=======
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853

          // policeman.draw(g2);

        }
        if(gameState == menuState)
        {
            ui.draw(g2);
        }

    }
<<<<<<< HEAD
<<<<<<< HEAD
    public void PaintEnemies(Graphics g)
=======
   /* public void PaintEnemies(Graphics g)
>>>>>>> 317e7494f493cf3a2bea6ef0ddcf464a8b208d08
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(gameState == runState)
        {
            for(int i = 0; i <= enemies.length; i++)
            {
                enemies[i].draw(g2);
            }
        }
    }
    public void setUpGame()
    {
        aSetter.setMonster();
    }
<<<<<<< HEAD

=======
>>>>>>> 0b76d89526d7162e8f3fae84e78f97cade5d7853
=======
*/
>>>>>>> 317e7494f493cf3a2bea6ef0ddcf464a8b208d08
}
