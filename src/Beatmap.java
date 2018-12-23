import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Write a description of class BeatmapReader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Beatmap{
    private ArrayList<ArrayList<Integer>> lanes = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Coordinates> coords = new ArrayList<Coordinates>();
    
    
    public Beatmap(String fileLocation) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader(fileLocation));
        
        for (int i = 0; i < 4; i++){
            lanes.add(new ArrayList<Integer>()); 
        }
        
        //read files
        String currentLine;
        int previewTime = 0;
        while ((currentLine = in.readLine()) != null){
            if (currentLine.split(":")[0].equals("PreviewTime")){
                previewTime = Integer.parseInt(currentLine.split(":")[1].substring(1));
            }
            if (currentLine.equals("[HitObjects]")){
                while ((currentLine = in.readLine()) != null){
                    String[] currentLane = currentLine.split(",");
                    if (Integer.parseInt(currentLane[0])==64){
                        lanes.get(0).add((Integer.parseInt(currentLane[2])));
                    }
                    if (Integer.parseInt(currentLane[0])==192){
                        lanes.get(1).add((Integer.parseInt(currentLane[2])));
                    }
                    if (Integer.parseInt(currentLane[0])==320){
                        lanes.get(2).add((Integer.parseInt(currentLane[2])));
                    }
                    if (Integer.parseInt(currentLane[0])==448){
                        lanes.get(3).add((Integer.parseInt(currentLane[2])));
                    }
                }
            }
        }
        
        in.close();
        
        for (int i = 0; i < 4; i++){
            coords.add(new Coordinates(lanes.get(i))); 
        }
        
    }
    
    public ArrayList<Coordinates> getMap(){
        return coords;
    }
}
