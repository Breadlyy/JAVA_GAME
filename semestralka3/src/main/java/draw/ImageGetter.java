package draw;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageGetter
{
    public static BufferedImage getImage(String url)
    {
        BufferedImage image = null;
        try {
             image = ImageIO.read(ImageGetter.class.getResourceAsStream("/"+url));
        } catch (IOException e) {
            e.printStackTrace();
        };
        return image;
    }
}
