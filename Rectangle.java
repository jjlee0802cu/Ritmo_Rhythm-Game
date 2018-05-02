import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Rectangle {
    public int x;
    public int y;
    public int width, height;

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;
    }
    
    public void moveDown(){
        y++;
    }
    public int getY(){
        return y;
    }
}