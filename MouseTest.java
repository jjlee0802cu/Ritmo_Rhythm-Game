
/**
 * MouseTest.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;
public class MouseTest

{
    public static void main(String s[]) {
        JFrame frame = new JFrame("Rytmo");
        
        frame.setSize(1024, 768);
        frame.setVisible(true);

        Point p = MouseInfo.getPointerInfo().getLocation();


    }
}
