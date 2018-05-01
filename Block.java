import java.awt.*;
import javax.swing.*;
public class Block extends Rectangle
{
    private int speed;
    private int lane;
    public Block(int x, int y, int s, int l){
        super(x,y,100,20);
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
