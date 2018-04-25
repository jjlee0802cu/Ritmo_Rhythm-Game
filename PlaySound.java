import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
public class PlaySound
{    

    public static void main(String[] args)
    {
        AePlayWave ae =  new  AePlayWave("YMCA oriental remix.wav");
        ae.run();

    }
}



