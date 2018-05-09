import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class comp extends JComponent
{
    static int rectangleY;
    static int rectangleX;
    static int lane;
    static boolean fill;
    static boolean q;
    static boolean w;
    static boolean e;
    static boolean r;
    static boolean clear;
    public static void main(String s[]) {
        JFrame f = new JFrame();
        Color background = new Color(0,0,0);
        f.getContentPane().setBackground( background );
        Component component = new comp();

        f.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent ke)
                {
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
        
        //int[] lanes = new int[100];
        //for(int i = 0;i<100;i++){
        //    lanes[i] = (int)(Math.random()*4)+1;
        //}
        int[] lanes = {1,2,3,4,12,13,14,23,24,34,123,124,134,234,1234};
        for(int i:lanes){
            lane = i;
            while(true && rectangleY<=768-100){
                try{
                    Thread.sleep(1);
                }
                catch(Exception e){

                }
                f.repaint();
                rectangleY+=2;
            }
            rectangleY=0;
        }
        clear = true;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(100,768-150,400,20);
        g.fillRect(100,0,2,768-150);
        g.fillRect(200,0,2,768-150);
        g.fillRect(300,0,2,768-150);
        g.fillRect(400,0,2,768-150);
        g.fillRect(500,0,2,768-150);
        
        if(lane>1000){
            g.fillRect(100*(lane%10),rectangleY,100,20);
            g.fillRect(100*(((int)lane/10)%10),rectangleY,100,20);
            g.fillRect(100*(((int)lane/100)%10),rectangleY,100,20);
            g.fillRect(100*(((int)lane/1000)%10),rectangleY,100,20);
        } else if(lane>100){
            g.fillRect(100*(lane%10),rectangleY,100,20);
            g.fillRect(100*(((int)lane/10)%10),rectangleY,100,20);
            g.fillRect(100*(((int)lane/100)%10),rectangleY,100,20);
        } else if(lane>10){
            g.fillRect(100*(lane%10),rectangleY,100,20);
            g.fillRect(100*(((int)lane/10)%10),rectangleY,100,20);
        } 
        else {g.fillRect(lane*100,rectangleY,100,20);}


        if(q){
            g.fillRect(100,768-150,100,20);
        }
        if(w){
            g.fillRect(200,768-150,100,20);
        }
        if(e){
            g.fillRect(300,768-150,100,20);
        }
        if(r){
            g.fillRect(400,768-150,100,20);
        }
        if(clear){g.setColor(Color.black);
        g.fillRect(100,0,410,768);
    }   
    }
}
