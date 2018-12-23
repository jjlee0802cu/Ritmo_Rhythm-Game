import java.util.ArrayList;
public class YGap
{
    private ArrayList<Integer> list;
    public YGap (Integer[] ygapinput)
    {
        list = new ArrayList<Integer>();
        for(int i:ygapinput){
            list.add(i);
        }
    }
    public ArrayList<Integer> get(){
        return list;
    }
}
