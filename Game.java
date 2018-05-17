import java.util.Timer;
import java.util.TimerTask;
/**
 * Write a description of class AnimationRunner here.
 *
 * @author (your name)qer
 * @version (a version number or a date)
 */
public class Game
{

    public static void main(String[] args) throws Exception
    {
        
        long offset = 0;
        
        GameAnimation app = new GameAnimation();
        TimerTask gameTask = new GameTimerTask(app);
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(gameTask,offset,10);

        
        final int width = 1024;
        final int height =768;
        
        app.debug(width,height);
        
        
    }
}
