package Fishy;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Shark extends Fish
{
    private Random r;
    
    public Shark()
    {
        try 
        {
            p = ImageIO.read(new File("Images\\Shark.png"));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Shark.class.getName()).log(Level.SEVERE, null, ex);
        }
       r = new Random();
       x = r.nextInt(1600) - 400;
       y = r.nextInt(1200) - 300;

    }
    
    public void move(Fish f)
    {
        if(f.getX() > x)
        {
            if(!isRight)
            {
                p = flipImage(p);
                isRight = true;
            }
            
            x += 1;
        }
        else if(f.getX() < x)
        {
            if(isRight)
            {
                p = flipImage(p);
                isRight = false;
            }
            
            x -= 1;
        }
        
        if(f.getY() > y)
        {
            y += 1;
        }
        else if(f.getY() < y)
        {
            y -= 1;
        }   
    }
     
}
