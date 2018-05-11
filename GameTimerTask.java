import java.util.TimerTask;

/**
 * Write a description of class GameTimerTask here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameTimerTask extends TimerTask
{
    private GameAnimation g;
    
    public GameTimerTask(GameAnimation inputThing){
        g = inputThing;
    }
    
    public void run(){
        g.repaint();
    }
}
