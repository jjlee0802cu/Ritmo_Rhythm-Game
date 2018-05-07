import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
public class BlockTester
{

    public static void main(String[] args) {
        ArrayList<Block> allBlocks = new ArrayList<Block>();
        Block b1 = new Block(100,0,1,1);
        Block b2 = new Block(300,0,1,1);
        
        allBlocks.add(b1);
        allBlocks.add(b2);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0,0, 1024, 768);

        window.getContentPane().add(new JComponent() {  
                Block myBlock = b1; //make it go throught hte loop and go through the allBlocks array list and paint them.   
                public void paint(Graphics g) {
                    g.drawRect(myBlock.x, myBlock.y, myBlock.width, myBlock.height);
                }
            });

        window.setVisible(true);
    }
}
