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
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_Z) {
            AePlayWave ae =  new  AePlayWave("soft-hitclap.wav");
            ae.run();
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            AePlayWave ae =  new  AePlayWave("Hihat.wav");
            ae.run();
        }
        if (e.getKeyCode() == KeyEvent.VK_C) {
            AePlayWave ae =  new  AePlayWave("soft-slidertick.wav");
            ae.run();
        }
        if (e.getKeyCode() == KeyEvent.VK_V) {
            AePlayWave ae =  new  AePlayWave("Snare.wav");
            ae.run();
        }

    }

    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new KeyListenerTester("Key Listener Tester");
        AePlayWave ae =  new  AePlayWave("YMCA oriental remix.wav");
        ae.run();

    
    }
}