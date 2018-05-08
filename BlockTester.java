import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
public class BlockTester
{
    static ArrayList<Block> allBlocks = new ArrayList<Block>();
    static Block b1 = new Block(100,0,1,1);
    static Block b2 = new Block(300,0,1,1);


    public static void main(String[] args) {
        allBlocks.add(b1);
        allBlocks.add(b2);
        
        Color background = new Color(0,0,0);
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0,0, 1024, 768);
        window.getContentPane().setBackground( background );
        
        Block component = new comp();
        window.add(component)
        
        window.setVisible(true);
        while(b1.getX()<=100){
            try{
                Thread.sleep(1);
            }
            catch(Exception e){

            }
            b1.moveBlockDown();
            window.repaint();
        }
        
        
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(b1.x, b1.y, b1.width, b1.height);
    }
}
