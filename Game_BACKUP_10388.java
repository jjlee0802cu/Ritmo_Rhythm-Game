import java.util.Timer;
import java.util.TimerTask;
/**
 * Write a description of class AnimationRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{

    public static void main(String[] args)
    {
        /** Change "GraphicApp" in the line
         * below to be the name of your
         * application file.
         */
        long offset = 0;
        
        GameAnimation app = new GameAnimation();
        TimerTask gameTask = new GameTimerTask(app);
        
<<<<<<< HEAD
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(gameTask,offset,10);
=======
        
        
        Timer timer;
        timer.scheduleAtFixedRate(TimerTask task, offset,10);
>>>>>>> 7333befd28e430eefb649f02551d48253cb63e02
        
        int width = 1024;
        int height =768;
        PlaySound psBackground =  new  PlaySound("YukiOnna.wav");
        psBackground.stop();
        psBackground.play();
        app.debug(width,height);
        
    }
}
