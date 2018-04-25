import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Component extends JComponent
{
    static int rectangleY;
    static int rectangleX;
    static int lane;
    static boolean fill;
    static boolean q;
    static boolean w;
    static boolean e;
    static boolean r;
    public static void main(String s[]) {
        JFrame f = new JFrame();
        Color background = new Color(0,0,0);
        f.getContentPane().setBackground( background );
        Component component = new Component();

        f.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent ke)
                {
                    if(ke.getKeyCode() == KeyEvent.VK_UP)
                    {
                        fill = true;
                    }
                    if(ke.getKeyCode() == KeyEvent.VK_DOWN)
                    {
                        fill = false;
                    }
                    
                    if(ke.getKeyCode() == KeyEvent.VK_Q)
                    {
                        q = true;
                    }
                    if(ke.getKeyCode() == KeyEvent.VK_W)
                    {
                        w = true;
                    }
                    if(ke.getKeyCode() == KeyEvent.VK_E)
                    {
                        e = true;
                    }
                    if(ke.getKeyCode() == KeyEvent.VK_R)
                    {
                        r = true;
                    }
                }

                public void keyReleased(KeyEvent ke) {
                    if(ke.getKeyCode() == KeyEvent.VK_Q)
                    {
                        q = false;
                    }
                    if(ke.getKeyCode() == KeyEvent.VK_W)
                    {
                        w = false;
                    }
                    if(ke.getKeyCode() == KeyEvent.VK_E)
                    {
                        e = false;
                    }
                    if(ke.getKeyCode() == KeyEvent.VK_R)
                    {
                        r = false;
                    }
                }
            });

        f.add(component);
        f.setSize(1024, 768);
        f.setVisible(true);

        int[] lanes = {1,2,4,3,1,4,1,2,1,3,2,4};
        for(int i:lanes){
            rectangleX=i*100;
            while(true && rectangleY<=768-100){
                try{
                    Thread.sleep(1);
                }
                catch(Exception e){

                }
                f.repaint();
                rectangleY++;

            }
            rectangleY=0;
        }

    }

    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.drawLine(0,768-150,1024,768-150);
        g.drawLine(100,768-150,100,0);
        g.drawLine(200,768-150,200,0);
        g.drawLine(300,768-150,300,0);
        g.drawLine(400,768-150,400,0);
        g.drawLine(500,768-150,500,0);
        
        g.drawRect(rectangleX,rectangleY,100,50);
        if(fill){g.fillRect(rectangleX,rectangleY,100,50);
        }

        if(q){
            g.fillRect(100,768-150,100,50);
        }
        if(w){
            g.fillRect(200,768-150,100,50);
        }
        if(e){
            g.fillRect(300,768-150,100,50);
        }
        if(r){
            g.fillRect(400,768-150,100,50);
        }
    }
}
