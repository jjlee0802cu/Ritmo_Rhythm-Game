import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Component extends JComponent
{
    static int rectangleY;
    static int rectangleX;
    static int lane;
    static boolean fill;
    public static void main(String s[]) {
        JFrame f = new JFrame();
        Component component = new Component();

        f.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent e)
                {
                    if(e.getKeyCode() == KeyEvent.VK_UP)
                    {
                        fill = true;
                    }
                }
            });
        f.add(component);
        f.setSize(1024, 768);
        f.setVisible(true);

        int[] lanes = {1,2,3,4,1,2,3,4};
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
        g.setColor(Color.RED);
        g.drawRect(rectangleX,rectangleY,100,50);
        if(fill){g.fillRect(rectangleX,rectangleY,100,50);
        }
    }
}
