
package Fishy;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


public class Player extends Guppy
{
    private int lastCheck;
    private int points;
    private int width;
    private int height;
    
    public Player()
    {
        points = 0;
        lastCheck = 0;
        width = p.getWidth();
        height = p.getHeight();
    }
    
    
    public void checkToResize()
    {
        if(points % 100 == 0 && points != lastCheck)
        {
            lastCheck = points;
            width++;
            height++;
            resizeImageWithHint(width, height);
        }
    }
    
    public void resizeImageWithHint(int IMG_WIDTH, int IMG_HEIGHT)
    {
            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, p.getType());
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(p, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();	
            g.setComposite(AlphaComposite.Src);

            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

            p = resizedImage;
    }
}
