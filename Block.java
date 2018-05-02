
public class Block extends Rectangle
{
    private int speed;
    private int lane;
    private int time;
    
    public Block(int x, int y, int t, int l, int s){
        super(x,y,100,20);
        speed = s;
        lane = l;
    }
}
