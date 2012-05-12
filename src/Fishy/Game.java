package Fishy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable
{
    private Player p;
    private Guppy g;
    private Shark s;
    private Thread t;
    private Image background;
    private static int screenWidth;
    private static int screenHeight;
    private final static int mapWidth = 120000;
    private final static int mapHeight = 120000;
  
    
    private ScreenManager screen;
    
    public Game()
    {
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new KeyAdapter());
        screen = new ScreenManager();
        screenWidth = screen.getCurrentDisplayMode().getWidth();
        screenHeight = screen.getCurrentDisplayMode().getHeight();
        
        try 
        {
            background = ImageIO.read(new File("Images\\underwater.png"));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        p = new Player();
        s = new Shark();
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() 
    {
       while(true)
       {
            p.move();
            s.move(p);
           
            try 
            {
                Thread.sleep(5);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }

            repaint();
        }
    }
    
   @Override
    public void paint(Graphics g)
   {
       super.paint(g);
       Graphics2D ga = (Graphics2D)g;
       
       int offsetX = getOffsetX(p);
       int offsetY = getOffsetY(p);
       
       //creating parallax background coordinates
       int x = offsetX * (screenWidth - background.getWidth(null)) / (screenWidth - mapWidth);
       int y = offsetY * (screenHeight - background.getHeight(null)) / (screenHeight - mapHeight);
       ga.drawImage(background, x, y, null);
       
       ga.drawImage(p.getImage(), p.getX() + offsetX, p.getY() + offsetY, this);
       ga.drawImage(s.getImage(), s.getX() + offsetX, s.getY() + offsetY, this);
       Toolkit.getDefaultToolkit().sync();
       g.dispose(); 
   }
   
  public static int getOffsetX(Fish p)
  {
      int offsetX = screenWidth / 2 - p.getX();
      offsetX = Math.min(offsetX, 0);
      offsetX = Math.max(offsetX, screenWidth - mapWidth);
       
      return offsetX;
  }
  
  public static int getOffsetY(Fish p)
  {
        int offsetY = screenHeight / 2 - p.getY();
        offsetY = Math.min(offsetY, 0);
        offsetY = Math.max(offsetY, screenWidth - mapHeight);
        return offsetY;
  }
     
   private class KeyAdapter implements KeyListener
   {
        @Override
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) 
        {
            p.setDx(-3);
        }

        if (key == KeyEvent.VK_D) 
        {
            p.setDx(3);
        }

        if (key == KeyEvent.VK_W) 
        {
            p.setDy(-3);
        }

        if (key == KeyEvent.VK_S) 
        {
            p.setDy(3);
        }
    }


        @Override
    public void keyReleased(KeyEvent e) 
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) 
        {
            p.setDx(0);
        }

        if (key == KeyEvent.VK_D) 
        {
            p.setDx(0);
        }

        if (key == KeyEvent.VK_W) 
        {
            p.setDy(0);
        }

        if (key == KeyEvent.VK_S) 
        {
            p.setDy(0);
        }
    }

        @Override
        public void keyTyped(KeyEvent e) 
        {
            
        }
    }
}


