import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerTester extends JFrame implements KeyListener {

    JLabel label;
    public KeyListenerTester(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Press the 'z','x','c','v' keys!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(500, 500);
        setVisible(true);

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            PlaySound ms=new PlaySound("soft-hitnormal.wav");
            ms.stop();
            ms.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_C) {
            PlaySound ms=new PlaySound("soft-slidertick.wav");
            ms.stop();
            ms.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_V) {
            PlaySound ms=new PlaySound("drum-hitclap.wav");
            ms.stop();
            ms.play();
        }

    }
    
    public void anotherKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            PlaySound ms=new PlaySound("soft-hitnormal.wav");
            ms.stop();
            ms.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_C) {
            PlaySound ms=new PlaySound("soft-slidertick.wav");
            ms.stop();
            ms.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_V) {
            PlaySound ms=new PlaySound("drum-hitclap.wav");
            ms.stop();
            ms.play();
        }

    }
    
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new KeyListenerTester("Key Listener Tester");
        //PlaySound psBackground =  new  PlaySound("YMCA oriental remix.wav");
        //psBackground.stop();
        //psBackground.play();
    
    }
}