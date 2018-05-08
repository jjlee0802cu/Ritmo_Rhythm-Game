
import java.awt.*;
import javax.swing.*;

public class Block extends Rectangle
{
    private int speed;
    private int lane;
    private int time;
    private int rectangleX;
    private int rectangleY;

    public Block(int x, int y, int s, int l){

        

        super(x,y,100,20);
        rectangleX = x;
        rectangleY = y;
        speed = s;
        lane = l;
    }
    
    public int getSpeed(){
        return speed;
    }
    public int getX(){
        return rectangleX;
    }
    public int getY(){
        return rectangleY;
    }
    public int getLane(){
        return lane;
    }
    public int moveBlockDown(){
        return rectangleX = rectangleX-1;
    }
}
