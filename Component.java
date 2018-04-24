import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Component extends JComponent
{
    static int rectangleX;
    public static void main(String s[]) {
        JFrame f = new JFrame();
        Component component = new Component();

        // f.addKeyListener(new KeyAdapter()
        // {
            // public void keyPressed(KeyEvent e)
            // {
                // if(e.getKeyCode() == KeyEvent.VK_UP)
                // {
                    
                // }
            // }
        // });
        f.add(component);
        f.setSize(1024, 768);
        f.setVisible(true);
        
        while(true){
            try{
                Thread.sleep(10);
            }
            catch(Exception e){
                
            }
            f.repaint();
            rectangleX++;
        }
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(100,100,50,200);
        
    }

}
