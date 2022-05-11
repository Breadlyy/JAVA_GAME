package Mechanics;

import draw.ImageGetter;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class HealthIcon
{

    BufferedImage image, image1;

    public HealthIcon(String src, String src1)
    {
        image = ImageGetter.getImage(src);
        image1 = ImageGetter.getImage(src1);
    }

    public void draw(Graphics2D g2, int count)
    {
        int x = 30, y = 30;
        int vertPadding = 2;
        int gorisontPadding = 2;
        g2.setColor(Color.gray);
        //Rectangle2D rect = new Rectangle(x-gorisontPadding, y-vertPadding, (image.getWidth()+vertPadding)*10 + gorisontPadding, image.getHeight()+2*vertPadding);

        g2.fillRect(x-gorisontPadding, y-vertPadding, (image.getWidth()+vertPadding)*10 + gorisontPadding, image.getHeight()+2*vertPadding);

        while (count>1)
        {
            count-=2;
            g2.drawImage(image, x, y, null);
            x+=9;
        }
        if(count==1)
        {
            g2.drawImage(image1, x, y, null);
        }
    }
}
