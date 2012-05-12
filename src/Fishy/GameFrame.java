/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fishy;

import javax.swing.JFrame;


public class GameFrame extends JFrame
{
    private ScreenManager sm;
    
    public GameFrame()
    {
        super("Fishy");
            
        sm = new ScreenManager();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(sm.getCurrentDisplayMode().getWidth(), sm.getCurrentDisplayMode().getHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        
        add(new Game());
        
        setVisible(true);

   }
}
