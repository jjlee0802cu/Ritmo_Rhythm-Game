import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
<<<<<<< HEAD
public class Rectangle
{
=======

public class Rectangle {
>>>>>>> 962c02aa739e1696cb1b0d602964154732efa0e4
    public int x;
    public int y;
    public int width, height;

    public Rectangle(int x, int y, int w, int h) {
<<<<<<< HEAD
        this.x = x;    
        this.y = y;    
        width = w;     
        height = h;
    }

}
=======
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
>>>>>>> 962c02aa739e1696cb1b0d602964154732efa0e4
