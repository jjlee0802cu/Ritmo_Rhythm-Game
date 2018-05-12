import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
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
    
    public Coordinates(ArrayList<Integer> input){
        coords = new ArrayList<Integer>();
        for (Integer i : input){
            coords.add((-i/10)+618);
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
