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
import java.util.Timer;
import java.util.Arrays;

public class GameAnimation extends Applet implements ActionListener, KeyListener 
{
    public boolean debugging;
    Graphics bg; //bufferGraphics
    BufferedImage renderFrame;
    Dimension dim;

    /*Integer[] OneYArray = {-40,130,250,100, 100,50,160,170,50};
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
    int coord4Length = coord4.length();*/

    private Coordinates coord1, coord2, coord3, coord4;
    private int coord1Length, coord2Length, coord3Length, coord4Length;

    Image picture = Toolkit.getDefaultToolkit().getImage("keypress.png");

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground;

    //for tracking
    int qInt=0;
    int wInt=0;
    int eInt=0;
    int rInt=0;
    boolean playQ=true;
    boolean playW=true;
    boolean playE=true;
    boolean playR=true;
    double yNow=0;
<<<<<<< HEAD
    //

    //for scoring
    int score = 1;
=======
    
    int score = 0;
>>>>>>> 899ec2553d42e4ddb1da8f619fa5f6438442499a
    int tempScore = 0;
    ArrayList<Integer> scoreDigits= new ArrayList<Integer>();

    public void debug(int width, int height) throws Exception {
        Beatmap currentLevel = new Beatmap("beatmap.osu");
        coord1 = currentLevel.getMap().get(0);
        coord2 = currentLevel.getMap().get(1);
        coord3 = currentLevel.getMap().get(2);
        coord4 = currentLevel.getMap().get(3);

        coord1Length = coord1.length();
        coord2Length = coord2.length();
        coord3Length = coord3.length();
        coord4Length = coord4.length();

        //for scoring
        
        
        Applet applet = this;
        debugging = true;
        String windowTitle = applet.getClass().getName();
        JFrame frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height + 20);
        frame.setBackground(Color.BLACK);
        frame.addKeyListener(this);
        frame.setResizable(false);
        applet.setSize(width, height+frame.getY());
        dim = getSize();
        frame.add(applet);

        PlaySound psBackground =  new  PlaySound("YukiOnna.wav");
        psBackground.stop();
        psBackground.play();

        applet.init();      // simulate browser call(1)
        applet.start();      // simulate browser call(2)

        frame.setVisible(true);

        introBackground = new ImageIcon("SnowyMountain.jpg").getImage();

        System.out.println(currentLevel.getMap().get(0));

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
            playQ=true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = false;
            playW=true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = false;
            playE=true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = false;
            playR=true;
        }
    }

    public void keyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playQ){
                ms.play(); 
                playQ=!playQ;
            }
            qInt=1;
            score++;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playW){
                ms.play(); 
                playW=!playW;
            }
            wInt=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playE){
                ms.play(); 
                playE=!playE;
            }
            eInt=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playR){
                ms.play(); 
                playR=!playR;
            }
            rInt=1;
        }
    }

    public void secondkeyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playQ){
                ms.play(); 
                playQ=!playQ;
            }
            qInt=1;
            score++;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playW){
                ms.play(); 
                playW=!playW;
            }
            wInt=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playE){
                ms.play(); 
                playE=!playE;
            }
            eInt=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playR){
                ms.play(); 
                playR=!playR;
            }
            rInt=1;
        }
    }

    public void thirdkeyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playQ){
                ms.play(); 
                playQ=!playQ;
            }
            qInt=1;
            score++;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playW){
                ms.play(); 
                playW=!playW;
            }
            wInt=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playE){
                ms.play(); 
                playE=!playE;
            }
            eInt=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playR){
                ms.play(); 
                playR=!playR;
            }
            rInt=1;
        }
    }

    public void fourthkeyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_Q)
        {
            q = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playQ){
                ms.play(); 
                playQ=!playQ;
            }
            qInt=1;
            score++;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W)
        {
            w = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playW){
                ms.play(); 
                playW=!playW;
            }
            wInt=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_E)
        {
            e = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playE){
                ms.play(); 
                playE=!playE;
            }
            eInt=1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_R)
        {
            r = true;
            PlaySound ms=new PlaySound("normal-hitnormalh.wav");
            ms.stop();
            if(playR){
                ms.play(); 
                playR=!playR;
            }
            rInt=1;
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

        /*// This is where the moving shape STARTS
        x=100.0;
        y=0.0;
        // How much to move in each direction when we redraw
        xInc=0.0;
        yInc=1.0;
        //initialize other needed variables
        ctr=0;
        // define the timer and start it
        timer = new Timer(10,this); // 10 ms. Larger numbers = slower
        timer.start();*/

        setBackground(Color.BLACK);
        dim = getSize();
        renderFrame = new BufferedImage(dim.width,dim.height,2);
        bg = renderFrame.createGraphics();

    }
    //-95 appears as 523 milliseconds
    //-40 lands on first note on JL computer

    public void update(Graphics g){
        paint(g);
    }


    private Image score0 = new ImageIcon("default-0.png").getImage();
    private Image score1 = new ImageIcon("default-1.png").getImage();
    private Image score2 = new ImageIcon("default-2.png").getImage();
    private Image score3 = new ImageIcon("default-3.png").getImage();
    private Image score4 = new ImageIcon("default-4.png").getImage();
    private Image score5 = new ImageIcon("default-5.png").getImage();
    private Image score6 = new ImageIcon("default-6.png").getImage();
    private Image score7 = new ImageIcon("default-7.png").getImage();
    private Image score8 = new ImageIcon("default-8.png").getImage();
    private Image score9 = new ImageIcon("default-9.png").getImage();


    public void paint(Graphics g)
    {   
        long startTime = System.currentTimeMillis();

        double totalTime;  
        startTime = System.currentTimeMillis();

        //Clear previous graphics
        bg.clearRect(0,0,dim.width,dim.width); 

        bg.drawImage(introBackground, 0, 0, null);

        bg.setColor(Color.WHITE);
        bg.drawRect(100,768-150,400,20);
        bg.fillRect(100,0,2,768-130);
        bg.fillRect(200,0,2,768-130);
        bg.fillRect(300,0,2,768-130);
        bg.fillRect(400,0,2,768-130);
        bg.fillRect(500,0,2,768-130);

        Graphics2D g2 = (Graphics2D) bg;
        if(q){
            bg.fillRect(100,768-150,100,20);
            g2.drawImage(picture, 100, 120, this);
        }
        if(w){
            bg.fillRect(200,768-150,100,20);
            g2.drawImage(picture, 200, 120, this);
        }
        if(e){
            bg.fillRect(300,768-150,100,20);
            g2.drawImage(picture, 300, 120, this);
        }
        if(r){
            bg.fillRect(400,768-150,100,20);
            g2.drawImage(picture, 400, 120, this);
        }

        //draw the picture
        for (int i=0;i<coord1Length;i++){
            bg.fillRect(100,coord1.getCoord(i)+(int)y,100,20);
        }
        for (int i=0;i<coord2Length;i++){
            bg.fillRect(200,coord2.getCoord(i)+(int)y,100,20);
        }
        for (int i=0;i<coord3Length;i++){
            bg.fillRect(300,coord3.getCoord(i)+(int)y,100,20);
        }
        for (int i=0;i<coord4Length;i++){
            bg.fillRect(400,coord4.getCoord(i)+(int)y,100,20);
        }

        //Scoring
        bg.drawString("Score: "+score,850,100);

        tempScore = score;
        // if(tempScore==0){
            // scoreDigits.add(0);
        // } else {
            // while(tempScore>0){
                // scoreDigits.add(tempScore%10);
                // tempScore = tempScore/10;
            // }
        // }
        while(tempScore>0){
                scoreDigits.add(tempScore%10);
                tempScore = tempScore/10;
            }

<<<<<<< HEAD
        // if(scoreDigits.get(0) == 0){
            // bg.drawImage(score0, 850, 100, null);
        // } else if (scoreDigits.get(0) == 1){
            // bg.drawImage(score1, 850, 100, null);
        // }else if (scoreDigits.get(0) == 2){
            // bg.drawImage(score2, 850, 100, null);
        // }else if (scoreDigits.get(0) == 3){
            // bg.drawImage(score3, 850, 100, null);
        // }else if (scoreDigits.get(0) == 4){
            // bg.drawImage(score4, 850, 100, null);
        // }else if (scoreDigits.get(0) == 5){
            // bg.drawImage(score5, 850, 100, null);
        // }else if (scoreDigits.get(0) == 6){
            // bg.drawImage(score6, 850, 100, null);
        // }else if (scoreDigits.get(0) == 7){
            // bg.drawImage(score7, 850, 100, null);
        // }else if (scoreDigits.get(0) == 8){
            // bg.drawImage(score8, 850, 100, null);
        // }else {
            // bg.drawImage(score9, 850, 100, null);
        // }
        bg.drawString(""+scoreDigits.size(),850,300);
        int ydisp=0;
        for(int i:scoreDigits){

            bg.drawString(""+i,850+ydisp,200);
        ydisp+=10;
    }
=======
        if(scoreDigits.get(0) == 0){
            bg.drawImage(score0, 850, 100, null);
        } else if (scoreDigits.get(0) == 1){
            bg.drawImage(score1, 850, 100, null);
        }else if (scoreDigits.get(0) == 2){
            bg.drawImage(score2, 850, 100, null);
        }else if (scoreDigits.get(0) == 3){
            bg.drawImage(score3, 850, 100, null);
        }else if (scoreDigits.get(0) == 4){
            bg.drawImage(score4, 850, 100, null);
        }else if (scoreDigits.get(0) == 5){
            bg.drawImage(score5, 850, 100, null);
        }else if (scoreDigits.get(0) == 6){
            bg.drawImage(score6, 850, 100, null);
        }else if (scoreDigits.get(0) == 7){
            bg.drawImage(score7, 850, 100, null);
        }else if (scoreDigits.get(0) == 8){
            bg.drawImage(score8, 850, 100, null);
        }else {
            bg.drawImage(score9, 850, 100, null);
        }
>>>>>>> 899ec2553d42e4ddb1da8f619fa5f6438442499a



            //***********I think ticks can be implemented here
        x+=xInc;
        y+=1;

        //Array instead of arraylist is much less lag. 
        //for loop instead of foreach is much less lag.
        /*long endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        //at the END of the method, make changes to the x and y values
        // so they move slightly on the next redraw

        //often, you'll want to check for the edges of the screen
        //and make your picture change direction instead of going
        //off the screen.

        //made to "track" the time when the rectangles should hit the line
        g.setColor(Color.RED);
        if(qInt>0){
        if(qInt==1){
        yNow=y;
        qInt=2;
        }
        g.drawString(""+yNow,150,100); 
        }
        if(wInt>0){
        if(wInt==1){
        yNow=y;
        wInt=2;
        }
        g.drawString(""+yNow,150,100);   
        }
        if(eInt>0){
        if(eInt==1){
        yNow=y;
        eInt=2;
        }
        g.drawString(""+yNow,150,100);   
        }
        if(rInt>0){
        if(rInt==1){
        yNow=y;
        rInt=2;
        }
        g.drawString(""+yNow,150,100); 
        }*/
        g.drawImage(renderFrame,0,0,this);

        for(int i=0;i<scoreDigits.size();i++){
            scoreDigits.remove(i);
        }

    }
}

