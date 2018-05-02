import java.util.ArrayList;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class RectangleTester
{
    public static void main(String[] args) {
        Block b1 = new Block (100,0,1,1,1);
        Block b2 = new Block (300,0,1,1,1);
        ArrayList<Block> allBlocks = new ArrayList<Block>();
        allBlocks.add(b1);
        allBlocks.add(b2);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0,0, 1024, 768);

        // for(Block b : allBlocks){
        // window.getContentPane().add(new JComponent() { 
        // Block myBlock = b;
        // public void paint(Graphics g) {
        // g.drawRect(myBlock.x, myBlock.y, myBlock.width, myBlock.height);

        // myBlock.moveDown();
        // repaint();

        // }
        // });
        // }
        while(true && rectangleY<=768-100){
                try{
                    Thread.sleep(1);
                }
                catch(Exception e){

                }
                window.repaint();
                rectangleY+=2;
            }
        window.setVisible(true);
    }

    public void paintComponent(Graphics g){
        g.drawRect(b1.x,b1.y,b1.width,b1.height);
    }
}
