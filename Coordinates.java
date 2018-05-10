import java.util.ArrayList;
public class Coordinates
{
    
    
    private ArrayList<Integer> coords;
    public Coordinates(YGap ygapinput)
    {
        coords = new ArrayList<Integer>();
        int temp = 0;
        for(int i=0;i<ygapinput.get().size();i++){
            temp-=ygapinput.get().get(i);
            coords.add(temp);
        }
    }
    
    public String toString(){
        String temp = "";
        for (int i:coords){
            temp+=i+" ";
        }
        return temp;
    }
    public int length(){
        return coords.size();
    }
    public int getCoord(int index){
        return coords.get(index);
    }
}
