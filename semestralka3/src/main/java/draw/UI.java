package draw;

import Entities.Player;
import Mechanics.GamePanel;
import Mechanics.HealthIcon;
import Mechanics.Item;
import Mechanics.gKey;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class UI {
    GamePanel gp;
    Font font;
    Graphics2D g2;
    public int numberChosen;
    HealthIcon healthIco = new HealthIcon(GamePanel.healthSrc, GamePanel.healthSrc1);

    public UI(GamePanel gp) {
        this.gp = gp;

        InputStream is = getClass().getResourceAsStream("/font/VT323-Regular.ttf");
        InputStream is2 = getClass().getResourceAsStream("/font/Macondo-Regular.ttf");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, 32F);

            System.out.println("Font found");
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        /*g2.setFont(font);
        g2.setColor(Color.black);
        g2.drawString("Key = " + gp.player.isHaskey(), 50, 50);
*/
        if (gp.gameState == GamePanel.menuState) {
            drawTitle();
        }
        else if (gp.gameState==GamePanel.runState)
        {
            healthIco.draw(g2, gp.player.getHealth());
            drawInventory(g2);
            /*if(gp.player.isHaskey())
            {
                g2.drawImage(gKey.getImage(),30, 60, null);
            }*/
        }
    }

    private void drawTitle() {
        g2.setFont(font.deriveFont(Font.PLAIN, 96F));
        g2.setColor(Color.white);
        String text = "Metro discoverer";
        int x = centeredText(text);
        int y = gp.tilesize * 4;
        g2.drawString(text, x, y);

        if (numberChosen == 0) {
            printRed("start", y);
            y += gp.tilesize;
            printWhite("finish", y);
        } else {
            printWhite("start", y);
            y += gp.tilesize;
            printRed("finish", y);
        }


    }

    void printRed(String text, int y) {
        g2.setColor(Color.RED);
        g2.setFont(font.deriveFont(Font.PLAIN, 72F));
        int x = centeredText(text);
        y += gp.tilesize * 3;
        g2.drawString(text, x, y);
        g2.drawString(">", x - gp.tilesize, y);
        g2.setColor(Color.WHITE);
    }

    private void printWhite(String text, int y) {
        g2.setColor(Color.white);
        g2.setFont(font.deriveFont(Font.PLAIN, 72F));
        int x = centeredText(text);
        y += gp.tilesize * 3;
        g2.drawString(text, x, y);
    }

    private int centeredText(String s) {
        int len = (int) g2.getFontMetrics().getStringBounds(s, g2).getWidth();
        return gp.getWidth() / 2 - len / 2;
    }

    public void submit()
    {
        if (numberChosen==0)
        {
            gp.gameState=GamePanel.runState;
        }
        else
        {
            System.exit(-1);
        }
    }

    public void drawInventory(Graphics2D g2)
    {
        int x = 20;
        int y = 60;
        for(int i = 0; i < 10; i ++)
        {
            {
                g2.setColor(Color.gray);
                g2.fillRect(x,y,30, 30);
            }
            if(gp.player.inventory[i]!=null)
            {
                g2.drawImage(gp.player.inventory[i].getImage(), x, y, 30, 30, null);
            }
            y+=33;
        }
        Item selected = gp.player.getItemSelected();
        if(selected!=null)
        {
            g2.drawImage(selected.getImage(), 1450, 30, 40, 40, null);
        }
    }

}
