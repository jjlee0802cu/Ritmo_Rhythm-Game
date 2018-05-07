<<<<<<< HEAD
import java.awt.*;
import javax.swing.*;
=======

>>>>>>> 962c02aa739e1696cb1b0d602964154732efa0e4
public class Block extends Rectangle
{
    private int speed;
    private int lane;
<<<<<<< HEAD
    public Block(int x, int y, int s, int l){
=======
    private int time;
    
    public Block(int x, int y, int t, int l, int s){
>>>>>>> 962c02aa739e1696cb1b0d602964154732efa0e4
        super(x,y,100,20);
        speed = s;
        lane = l;
    }
<<<<<<< HEAD
    public int getSpeed(){
        return speed;
    }
    public int getLane(){
        return lane;
    }
=======
>>>>>>> 962c02aa739e1696cb1b0d602964154732efa0e4
}
