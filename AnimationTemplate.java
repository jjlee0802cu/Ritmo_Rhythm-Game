import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
/**
 * Write a description of class AnimationTemplate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnimationTemplate extends Applet implements ActionListener
{
    /****************************************************
     * The following code should NOT be changed for any
     * reason. Doing so will prevent the app from running
     ****************************************************/
    public boolean debugging;
    public void debug(int width, int height) {
        Applet applet = this;
        debugging = true;
        String windowTitle = applet.getClass().getName();
        JFrame frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height + 20);
        frame.setBackground(Color.BLACK);
        applet.setSize(width, height+frame.getY());
        frame.add(applet);
        applet.init();      // simulate browser call(1)
        applet.start();      // simulate browser call(2)
        frame.setVisible(true);
    }  

    public boolean debugging() {
        return debugging;
    }

    public void actionPerformed(ActionEvent ae) {
        repaint(); 
    }

    /** All code changes go below this point **/
    /** Variables declared here can be used in ALL following methods.
     * Generally, only those variables needed for animation purposes
     * should go here.
     */
    private int x,y;       //shape starting point
    private int xInc,yInc; //controls how much to move shape
    private Timer timer;   //used to force redraw 
    private int ctr;       //other needed variables

    /**
     * This is always called before the first time that the start 
     * method is called. Here we set up the timer and initiailize 
     * the starting point for our moving shape
     */
    public void init()
    { 

        // This is where the moving shape STARTS
        x=100;
        y=200;
        // How much to move in each direction when we redraw
        xInc=0;
        yInc=3;
        //initialize other needed variables
        ctr=0;
        // define the timer and start it
        timer = new Timer(10,this); // 10 ms. Larger numbers = slower
        timer.start();
        //setup background color
        setBackground(Color.BLACK);

    }

    public void paint(Graphics g)
    {   
        //draw the picture
        
        //at the END of the method, make changes to the x and y values
        // so they move slightly on the next redraw
        
        
        //often, you'll want to check for the edges of the screen
        //and make your picture change direction instead of going
        //off the screen.
        
        }

    }

