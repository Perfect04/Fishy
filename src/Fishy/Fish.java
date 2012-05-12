package Fishy;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fish 
{
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected boolean isRight = true;
    protected BufferedImage p;
    
    
    
    public void move()
    {
        if(dx < 0 && isRight)
        {
            p = flipImage(p);
            isRight = false;
        }
        else if(dx > 0 && !isRight )
        {
            p = flipImage(p);
            isRight = true;
        }
       
        x += dx;
        y += dy;
    }
    
    public BufferedImage getImage() 
    {
        if(p == null)
        {
            try 
            {
                throw new Exception("No Image was found for Fish");
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(Fish.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        return p;
    }
    
    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }
    
    public void setDx(int dx) 
    {
        this.dx = dx;
        
    }
    
    public void setDy(int dy) 
    {
        this.dy = dy;
    }
    
  
    public BufferedImage flipImage(BufferedImage i)
    {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-i.getWidth(), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(i, null);
    }
    
}
