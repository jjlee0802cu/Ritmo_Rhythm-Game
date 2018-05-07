
import java.awt.*;
import javax.swing.*;

public class Block extends Rectangle
{
    private int speed;
    private int lane;
    private int time;
    private int rectangleX;

    public Block(int x, int y, int s, int l){

        

        super(x,y,100,20);
        rectangleX = x;
        speed = s;
        lane = l;
    }

    public int getSpeed(){
        return speed;
    }

    public int getLane(){
        return lane;
    }
    
    
}
