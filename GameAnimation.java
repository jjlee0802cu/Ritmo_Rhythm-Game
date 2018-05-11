import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.sound.sampled.AudioSystem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class GameAnimation extends Applet implements ActionListener, KeyListener
{
    public boolean debugging;

    //for tracking
    int qInt=0;
    int qIntH=0;
    int wInt=0;
    int wIntH=0;
    int eInt=0;
    int eIntH=0;
    int rInt=0;
    int rIntH=0;
    double yNow=0;
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
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play(); 
            qIntH=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            wIntH=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            eIntH=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            rIntH=1;
        }
    }

    public void secondkeyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            qIntH=qInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            wIntH=wInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            eIntH=eInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            rIntH=rInt+1;
        }
    }

    public void thirdkeyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            qIntH=qInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            wIntH=wInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            eIntH=eInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            rIntH=rInt+1;
        }
    }

    public void fourthkeyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            qIntH=qInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            wIntH=wInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            eIntH=eInt+1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            ms.play();
            rIntH=rInt+1;
        }
    }

    public void keyTyped(KeyEvent ke){
    }

    /** All code changes go below this point **/
    /** Variables declared here can be used in ALL following methods.
     * Generally, only those variables needed for animation purposes
     * should go here.
     */
    private double x,y;       //shape starting point
    private double xInc,yInc; //controls how much to move shape
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
        x=100.0;
        y=0.0;
        // How much to move in each direction when we redraw
        xInc=0.0;
        yInc=1.0;
        //initialize other needed variables
        ctr=0;
        // define the timer and start it
        timer = new Timer(10,this); // 10 ms. Larger numbers = slower
        timer.start();
        //setup background color
        setBackground(Color.BLACK);

    }
    //-95 appears as 523 milliseconds
    Integer[] OneYArray = {-231,130,250,100, 100,50,160,170,50};
    YGap ygap1 = new YGap(OneYArray);
    Coordinates coord1 = new Coordinates(ygap1);
    int coord1Length = coord1.length();

    Integer[] TwoYArray = {40,350,50,100, 100,60,170,150, 200};
    YGap ygap2 = new YGap(TwoYArray);
    Coordinates coord2 = new Coordinates(ygap2);
    int coord2Length = coord2.length();

    Integer[] ThreeYArray = {60,330,100,250,40, 100, 300, 100};
    YGap ygap3 = new YGap(ThreeYArray);
    Coordinates coord3 = new Coordinates(ygap3);
    int coord3Length = coord3.length();

    Integer[] FourYArray = {80,310,300,50,40,40, 150, 60, 150, 60, 70, 100};
    YGap ygap4 = new YGap(FourYArray);
    Coordinates coord4 = new Coordinates(ygap4);
    int coord4Length = coord4.length();

    Image picture = Toolkit.getDefaultToolkit().getImage("keypress.png");
    public void paint(Graphics g)
    {   
        long startTime = System.currentTimeMillis();

        double totalTime;  
        startTime = System.currentTimeMillis();

        g.setColor(Color.WHITE);
        g.drawRect(100,768-150,400,20);
        g.fillRect(100,0,2,768-130);
        g.fillRect(200,0,2,768-130);
        g.fillRect(300,0,2,768-130);
        g.fillRect(400,0,2,768-130);
        g.fillRect(500,0,2,768-130);

        if(q){
            g.fillRect(100,768-150,100,20);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(picture, 100, 120, this);
        }
        if(w){
            g.fillRect(200,768-150,100,20);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(picture, 200, 120, this);
        }
        if(e){
            g.fillRect(300,768-150,100,20);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(picture, 300, 120, this);
        }
        if(r){
            g.fillRect(400,768-150,100,20);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(picture, 400, 120, this);
        }

        //draw the picture

        for (int i=0;i<coord1Length;i++){
            g.drawRect(100,coord1.getCoord(i)+(int)y,100,20);
        }
        for (int i=0;i<coord2Length;i++){
            g.drawRect(200,coord2.getCoord(i)+(int)y,100,20);
        }
        for (int i=0;i<coord3Length;i++){
            g.drawRect(300,coord3.getCoord(i)+(int)y,100,20);
        }
        for (int i=0;i<coord4Length;i++){
            g.drawRect(400,coord4.getCoord(i)+(int)y,100,20);
        }
        //Array instead of arraylist is much less lag. 
        //for loop instead of foreach is much less lag.
        long endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        //at the END of the method, make changes to the x and y values
        // so they move slightly on the next redraw

        //***********I think ticks can be implemented here
        x+=xInc;
        y+=1;
        //often, you'll want to check for the edges of the screen
        //and make your picture change direction instead of going
        //off the screen.

        //made to "track" the time when the rectangles should hit the line
        g.setColor(Color.RED);
        if(qIntH>qInt){
            if(qIntH==1){
                yNow=y;
                qIntH=2;
            }
            g.drawString(""+yNow,150,100); 
        }
        if(wIntH>wInt){
            if(wIntH==1){
                yNow=y;
                wIntH=2;
            }
            g.drawString(""+yNow,150,100);   
        }
        if(eIntH>eInt){
            if(eIntH==1){
                yNow=y;
                eIntH=2;
            }
            g.drawString(""+yNow,150,100);   
        }
        if(rIntH>rInt){
            if(rIntH==1){
                yNow=y;
                rIntH=2;
            }
            g.drawString(""+yNow,150,100); 
        }
    }

}

