
package Fishy;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Guppy extends Fish
{
    public Guppy()
    {
        try 
        {
            p = ImageIO.read(new File("Images\\Guppy.png"));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Guppy.class.getName()).log(Level.SEVERE, null, ex);
        }
 
       x = 50;
       y = 50;
    }
}
