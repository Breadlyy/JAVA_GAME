package draw;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background
{
    public BufferedImage image;
    public int x;
    public Background(String url) {
        synchronized (this)
        {
            try {
                image = ImageGetter.getImage(url);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics2D g2, int deltax)
    {
        g2.drawImage(image, deltax, 0, 1920, 800, null);
    }

}
