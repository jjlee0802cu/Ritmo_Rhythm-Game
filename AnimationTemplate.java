import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
import java.util.ArrayList;
public class AnimationTemplate extends Applet implements ActionListener, KeyListener
{
    public boolean debugging;
    public void debug(int width, int height) {
        Applet applet = this;
        debugging = true;
        String windowTitle = applet.getClass().getName();
        JFrame frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height + 20);
        frame.setBackground(Color.BLACK);
        frame.addKeyListener(this);
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
    
    static boolean q=false;;
    static boolean w=false;
    static boolean e=false;
    static boolean r=false;
    public void keyReleased(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = false;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = false;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = false;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = false;
        }
    }
    public void keyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
        }
    }
    public void keyTyped(KeyEvent e){

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
    public ArrayList<Integer> OneYGaps = new ArrayList<Integer>(Array.asList(1,2));
    
    public void paint(Graphics g)
    {   
        g.setColor(Color.WHITE);
        g.drawRect(100,768-150,400,20);
        g.fillRect(100,0,2,768-150);
        g.fillRect(200,0,2,768-150);
        g.fillRect(300,0,2,768-150);
        g.fillRect(400,0,2,768-150);
        g.fillRect(500,0,2,768-150);

        if(q){
            g.fillRect(100,768-150,100,20);
        }
        if(w){
            g.fillRect(200,768-150,100,20);
        }
        if(e){
            g.fillRect(300,768-150,100,20);
        }
        if(r){
            g.fillRect(400,768-150,100,20);
        }
        
        //draw the picture
        g.setColor(Color.WHITE);
        g.drawRect(x,y,100,20);
        //at the END of the method, make changes to the x and y values
        // so they move slightly on the next redraw
        x+=xInc;
        y+=yInc;

        //often, you'll want to check for the edges of the screen
        //and make your picture change direction instead of going
        //off the screen.
        if(y>768-100){
            y=0;
        }
    }
}

