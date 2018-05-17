//
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
import java.awt.image.BufferedImageOp;

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
    int startCoord1 = 0;
    int startCoord2 = 0;
    int startCoord3 = 0;
    int startCoord4 = 0;

    Image picture = Toolkit.getDefaultToolkit().getImage("keypress.png");

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground;

    //for tracking
    private int qInt=0;
    private int wInt=0;
    private int eInt=0;
    private int rInt=0;
    private boolean playQ=true;
    private boolean playW=true;
    private boolean playE=true;
    private boolean playR=true;
    private double yNow=0;

    //for scoring
    private int scoreL1 = 0;
    private int scoreL2 = 0;
    private  int scoreL3 = 0;
    private int scoreL4 = 0;
    private int score = scoreL1 + scoreL2 + scoreL3 + scoreL4;
    private String preciseQ;
    private String preciseW;
    private String preciseE;
    private String preciseR;
    private int combo=0;
    ArrayList<Integer> scoreDigits= new ArrayList<Integer>();

    public void debug(int width, int height) throws Exception {
        Beatmap currentLevel = new Beatmap("beatmap.osu");
        coord1 = currentLevel.getMap().get(0);
        coord2 = currentLevel.getMap().get(1);
        coord3 = currentLevel.getMap().get(2);
        coord4 = currentLevel.getMap().get(3);

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

        //System.out.println(currentLevel.getMap().get(0));
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

    static int line = 768-150;

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

            if(startCoord1<coord1.length()){
                double timing = y + coord1.getCoord(startCoord1);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL1+=300+((300*combo)/25);
                    startCoord1++;
                    preciseQ="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL1+=200+((200*combo)/25);
                    startCoord1++;
                    preciseQ="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL1+=100+((100*combo)/25);
                    startCoord1++;
                    preciseQ="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL1+=50+((50*combo)/25);
                    startCoord1++;
                    preciseQ="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord1++;
                    preciseQ="miss";
                    combo=0;
                } else {
                    preciseQ="miss";
                    combo=0;
                }
            }
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

            if(startCoord2<coord2.length()){
                double timing = y + coord2.getCoord(startCoord2);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL2+=300+((300*combo)/25);
                    startCoord2++;
                    preciseW="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL2+=200+((200*combo)/25);
                    startCoord2++;
                    preciseW="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL2+=100+((100*combo)/25);
                    startCoord2++;
                    preciseW="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL2+=50+((50*combo)/25);
                    startCoord2++;
                    preciseW="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord2++;
                    preciseW="miss";
                    combo=0;
                } else {
                    preciseW="miss";
                    combo=0;
                }
            }
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

            if(startCoord3<coord3.length()){
                double timing = y + coord3.getCoord(startCoord3);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL3+=300+((300*combo)/25);
                    startCoord3++;
                    preciseE="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL3+=200+((200*combo)/25);
                    startCoord3++;
                    preciseE="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL3+=100+((100*combo)/25);
                    startCoord3++;
                    preciseE="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL3+=50+((50*combo)/25);
                    startCoord3++;
                    preciseE="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord3++;
                    preciseE="miss";
                    combo=0;
                } else {
                    preciseE="miss";
                    combo=0;
                }
            }
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

            if(startCoord4<coord4.length()){
                double timing = y + coord4.getCoord(startCoord4);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL4+=300+((300*combo)/25);
                    startCoord4++;
                    preciseR="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL4+=200+((200*combo)/25);
                    startCoord4++;
                    preciseR="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL4+=100+((100*combo)/25);
                    startCoord4++;
                    preciseR="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL4+=50+((50*combo)/25);
                    startCoord4++;
                    preciseR="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord4++;
                    preciseR="miss";
                    combo=0;
                } else {
                    preciseR="miss";
                    combo=0;
                }
            }
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

            if(startCoord1<coord1.length()){
                double timing = y + coord1.getCoord(startCoord1);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL1+=300+((300*combo)/25);
                    startCoord1++;
                    preciseQ="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL1+=200+((200*combo)/25);
                    startCoord1++;
                    preciseQ="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL1+=100+((100*combo)/25);
                    startCoord1++;
                    preciseQ="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL1+=50+((50*combo)/25);
                    startCoord1++;
                    preciseQ="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord1++;
                    preciseQ="miss";
                    combo=0;
                } else {
                    preciseQ="miss";
                    combo=0;
                }
            }
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

            if(startCoord2<coord2.length()){
                double timing = y + coord2.getCoord(startCoord2);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL2+=300+((300*combo)/25);
                    startCoord2++;
                    preciseW="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL2+=200+((200*combo)/25);
                    startCoord2++;
                    preciseW="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL2+=100+((100*combo)/25);
                    startCoord2++;
                    preciseW="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL2+=50+((50*combo)/25);
                    startCoord2++;
                    preciseW="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord2++;
                    preciseW="miss";
                    combo=0;
                } else {
                    preciseW="miss";
                    combo=0;
                }
            }
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

            if(startCoord3<coord3.length()){
                double timing = y + coord3.getCoord(startCoord3);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL3+=300+((300*combo)/25);
                    startCoord3++;
                    preciseE="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL3+=200+((200*combo)/25);
                    startCoord3++;
                    preciseE="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL3+=100+((100*combo)/25);
                    startCoord3++;
                    preciseE="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL3+=50+((50*combo)/25);
                    startCoord3++;
                    preciseE="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord3++;
                    preciseE="miss";
                    combo=0;
                } else {
                    preciseE="miss";
                    combo=0;
                }
            }
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

            if(startCoord4<coord4.length()){
                double timing = y + coord4.getCoord(startCoord4);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL4+=300+((300*combo)/25);
                    startCoord4++;
                    preciseR="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL4+=200+((200*combo)/25);
                    startCoord4++;
                    preciseR="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL4+=100+((100*combo)/25);
                    startCoord4++;
                    preciseR="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL4+=50+((50*combo)/25);
                    startCoord4++;
                    preciseR="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord4++;
                    preciseR="miss";
                    combo=0;
                } else {
                    preciseR="miss";
                    combo=0;
                }
            }
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

            if(startCoord1<coord1.length()){
                double timing = y + coord1.getCoord(startCoord1);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL1+=300+((300*combo)/25);
                    startCoord1++;
                    preciseQ="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL1+=200+((200*combo)/25);
                    startCoord1++;
                    preciseQ="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL1+=100+((100*combo)/25);
                    startCoord1++;
                    preciseQ="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL1+=50+((50*combo)/25);
                    startCoord1++;
                    preciseQ="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord1++;
                    preciseQ="miss";
                    combo=0;
                } else {
                    preciseQ="miss";
                    combo=0;
                }
            }
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

            if(startCoord2<coord2.length()){
                double timing = y + coord2.getCoord(startCoord2);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL2+=300+((300*combo)/25);
                    startCoord2++;
                    preciseW="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL2+=200+((200*combo)/25);
                    startCoord2++;
                    preciseW="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL2+=100+((100*combo)/25);
                    startCoord2++;
                    preciseW="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL2+=50+((50*combo)/25);
                    startCoord2++;
                    preciseW="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord2++;
                    preciseW="miss";
                    combo=0;
                } else {
                    preciseW="miss";
                    combo=0;
                }
            }
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

            if(startCoord3<coord3.length()){
                double timing = y + coord3.getCoord(startCoord3);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL3+=300+((300*combo)/25);
                    startCoord3++;
                    preciseE="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL3+=200+((200*combo)/25);
                    startCoord3++;
                    preciseE="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL3+=100+((100*combo)/25);
                    startCoord3++;
                    preciseE="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL3+=50+((50*combo)/25);
                    startCoord3++;
                    preciseE="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord3++;
                    preciseE="miss";
                    combo=0;
                } else {
                    preciseE="miss";
                    combo=0;
                }
            }
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

            if(startCoord4<coord4.length()){
                double timing = y + coord4.getCoord(startCoord4);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL4+=300+((300*combo)/25);
                    startCoord4++;
                    preciseR="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL4+=200+((200*combo)/25);
                    startCoord4++;
                    preciseR="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL4+=100+((100*combo)/25);
                    startCoord4++;
                    preciseR="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL4+=50+((50*combo)/25);
                    startCoord4++;
                    preciseR="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord4++;
                    preciseR="miss";
                    combo=0;
                } else {
                    preciseR="miss";
                    combo=0;
                }
            }
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

            if(startCoord1<coord1.length()){
                double timing = y + coord1.getCoord(startCoord1);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL1+=300+((300*combo)/25);
                    startCoord1++;
                    preciseQ="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL1+=200+((200*combo)/25);
                    startCoord1++;
                    preciseQ="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL1+=100+((100*combo)/25);
                    startCoord1++;
                    preciseQ="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL1+=50+((50*combo)/25);
                    startCoord1++;
                    preciseQ="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord1++;
                    preciseQ="miss";
                    combo=0;
                } else {
                    preciseQ="miss";
                    combo=0;
                }
            }
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

            if(startCoord2<coord2.length()){
                double timing = y + coord2.getCoord(startCoord2);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL2+=300+((300*combo)/25);
                    startCoord2++;
                    preciseW="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL2+=200+((200*combo)/25);
                    startCoord2++;
                    preciseW="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL2+=100+((100*combo)/25);
                    startCoord2++;
                    preciseW="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL2+=50+((50*combo)/25);
                    startCoord2++;
                    preciseW="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord2++;
                    preciseW="miss";
                    combo=0;
                } else {
                    preciseW="miss";
                    combo=0;
                }
            }
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

            if(startCoord3<coord3.length()){
                double timing = y + coord3.getCoord(startCoord3);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL3+=300+((300*combo)/25);
                    startCoord3++;
                    preciseE="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL3+=200+((200*combo)/25);
                    startCoord3++;
                    preciseE="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL3+=100+((100*combo)/25);
                    startCoord3++;
                    preciseE="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL3+=50+((50*combo)/25);
                    startCoord3++;
                    preciseE="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord3++;
                    preciseE="miss";
                    combo=0;
                } else {
                    preciseE="miss";
                    combo=0;
                }
            }
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

            if(startCoord4<coord4.length()){
                double timing = y + coord4.getCoord(startCoord4);
                if(timing<=line+10 && timing>=line-10){
                    //Perfect
                    combo++;
                    scoreL4+=300+((300*combo)/25);
                    startCoord4++;
                    preciseR="excellent";
                } 
                else if(timing<=line+20 && timing>=line-20){
                    //Great
                    combo++;
                    scoreL4+=200+((200*combo)/25);
                    startCoord4++;
                    preciseR="great";
                } 
                else if(timing<=line+30 && timing>=line-30){
                    //Good
                    combo++;
                    scoreL4+=100+((100*combo)/25);
                    startCoord4++;
                    preciseR="good";
                } 
                else if(timing<=line+40 && timing>=line-40){
                    //Bad
                    combo++;
                    scoreL4+=50+((50*combo)/25);
                    startCoord4++;
                    preciseR="bad";
                }else if(timing>=line-50){
                    //Missed 
                    startCoord4++;
                    preciseR="miss";
                    combo=0;
                } else {
                    preciseR="miss";
                    combo=0;
                }
            }
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
    private Image excellent = new ImageIcon("excellent.png").getImage();
    private Image great = new ImageIcon("great.png").getImage();
    private Image good = new ImageIcon("good.png").getImage();
    private Image bad = new ImageIcon("bad.png").getImage();
    private Image miss = new ImageIcon("miss.png").getImage();
    private Image pBarEmpty = new ImageIcon("scorebar-bg.png").getImage();
    private Image pBarFull = new ImageIcon("scorebar-colour.png").getImage();

    public void paint(Graphics g)
    {   
        long startTime = System.currentTimeMillis();

        double totalTime;  
        startTime = System.currentTimeMillis();

        //Clear previous graphics
        bg.clearRect(0,0,dim.width,dim.width); 

        bg.drawImage(introBackground, 0, 0, null);

        //Removes note if you are waaaaaay too late
        if(startCoord1<coord1.length()){
            double timing = y + coord1.getCoord(startCoord1);
            if(timing>=line+50){
                startCoord1++;
            }
        }
        if(startCoord2<coord2.length()){
            double timing = y + coord2.getCoord(startCoord2);
            if(timing>=line+50){
                startCoord2++;
            }
        }
        if(startCoord3<coord3.length()){
            double timing = y + coord3.getCoord(startCoord3);
            if(timing>=line+50){
                startCoord3++;
            }
        }
        if(startCoord4<coord4.length()){
            double timing = y + coord4.getCoord(startCoord4);
            if(timing>=line+50){
                startCoord4++;
            }
        }

        bg.setColor(Color.WHITE);
        bg.drawRect(100,768-150,400,20);
        bg.fillRect(100,0,2,768-130);
        bg.fillRect(200,0,2,768-130);
        bg.fillRect(300,0,2,768-130);
        bg.fillRect(400,0,2,768-130);
        bg.fillRect(500,0,2,768-130);
        //rectangle at bottom
        Graphics2D g2 = (Graphics2D) bg;
        yNow=y;
        if(q){
            bg.fillRect(100,768-150,100,20);
            g2.drawImage(picture, 100, 120, this);
            if(y<yNow+500){
                if(preciseQ.equals("excellent")){
                    g2.drawImage(excellent, 100, 650, this);
                }
                else if(preciseQ.equals("great")){
                    g2.drawImage(great, 100, 650, this);
                }
                else if(preciseQ.equals("good")){
                    g2.drawImage(good, 100, 650, this);
                }
                else if(preciseQ.equals("bad")){
                    g2.drawImage(bad, 100, 650, this);
                }
                else if(preciseQ.equals("miss")){
                    g2.drawImage(miss, 100, 650, this);
                }
            }
        }
        if(w){
            bg.fillRect(200,768-150,100,20);
            g2.drawImage(picture, 200, 120, this);
            if(y<yNow+500){
                if(preciseW.equals("excellent")){
                    g2.drawImage(excellent, 200, 700, this);
                }
                else if(preciseW.equals("great")){
                    g2.drawImage(great, 200, 650, this);
                }
                else if(preciseW.equals("good")){
                    g2.drawImage(good, 200, 650, this);
                }
                else if(preciseW.equals("bad")){
                    g2.drawImage(bad, 200, 650, this);
                }
                else if(preciseW.equals("miss")){
                    g2.drawImage(miss, 200, 650, this);
                }
            }
        }
        if(e){
            bg.fillRect(300,768-150,100,20);
            g2.drawImage(picture, 300, 120, this);
            if(y<yNow+500){
                if(preciseE.equals("excellent")){
                    g2.drawImage(excellent, 300, 650, this);
                }
                else if(preciseE.equals("great")){
                    g2.drawImage(great, 300, 650, this);
                }
                else if(preciseE.equals("good")){
                    g2.drawImage(good, 300, 650, this);
                }
                else if(preciseE.equals("bad")){
                    g2.drawImage(bad, 300, 650, this);
                }
                else if(preciseE.equals("miss")){
                    g2.drawImage(miss, 300, 650, this);
                }
            }
        }
        if(r){
            bg.fillRect(400,768-150,100,20);
            g2.drawImage(picture, 400, 120, this);
            if(y<yNow+500){
                if(preciseR.equals("excellent")){
                    g2.drawImage(excellent, 400, 700, this);
                }
                else if(preciseR.equals("great")){
                    g2.drawImage(great, 400, 650, this);
                }
                else if(preciseR.equals("good")){
                    g2.drawImage(good, 400, 650, this);
                }
                else if(preciseR.equals("bad")){
                    g2.drawImage(bad, 400, 650, this);
                }
                else if(preciseR.equals("miss")){
                    g2.drawImage(miss, 400, 650, this);
                }
            }
        }

        //draw the picture
        for (int i=startCoord1;i<coord1.length();i++){
            bg.fillRect(100,coord1.getCoord(i)+(int)y,100,20);
        }
        for (int i=startCoord2;i<coord2.length();i++){
            bg.fillRect(200,coord2.getCoord(i)+(int)y,100,20);
        }
        for (int i=startCoord3;i<coord3.length();i++){
            bg.fillRect(300,coord3.getCoord(i)+(int)y,100,20);
        }
        for (int i=startCoord4;i<coord4.length();i++){
            bg.fillRect(400,coord4.getCoord(i)+(int)y,100,20);
        }

        //Scoring

        score = scoreL1 + scoreL2 + scoreL3 + scoreL4;
        String scoreString = ""+score;
        String[] scoreStringParts = scoreString.split("");
        for(String s:scoreStringParts){
            scoreDigits.add(Integer.parseInt(s));
        }

        if(scoreDigits.size()>=8){
            bg.drawImage(score9, 650, 100, null);
            bg.drawImage(score9, 700, 100, null);
            bg.drawImage(score9, 750, 100, null);
            bg.drawImage(score9, 800, 100, null);
            bg.drawImage(score9, 850, 100, null);
            bg.drawImage(score9, 900, 100, null);
            bg.drawImage(score9, 950, 100, null);
        } else{

            //Million's Digit
            if(scoreDigits.size()>=7){
                if(scoreDigits.get(scoreDigits.size()-7) == 0){
                    bg.drawImage(score0, 650, 100, null);
                }else if(scoreDigits.get(scoreDigits.size()-7) == 1){
                    bg.drawImage(score1, 650, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-7) == 2){
                    bg.drawImage(score2, 650, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-7) == 3){
                    bg.drawImage(score3, 650, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-7) == 4){
                    bg.drawImage(score4, 650, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-7)== 5){
                    bg.drawImage(score5, 650, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-7) == 6){
                    bg.drawImage(score6, 650, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-7) == 7){
                    bg.drawImage(score7, 650, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-7) == 8){
                    bg.drawImage(score8, 650, 100, null);
                }else {
                    bg.drawImage(score9, 650, 100, null);
                }
            } else{bg.drawImage(score0, 650, 100, null);}

            //Hundred Thousand's Digit
            if(scoreDigits.size()>=6){
                if(scoreDigits.get(scoreDigits.size()-6) == 0){
                    bg.drawImage(score0, 700, 100, null);
                }else if(scoreDigits.get(scoreDigits.size()-6) == 1){
                    bg.drawImage(score1, 700, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-6) == 2){
                    bg.drawImage(score2, 700, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-6) == 3){
                    bg.drawImage(score3, 700, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-6) == 4){
                    bg.drawImage(score4, 700, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-6)== 5){
                    bg.drawImage(score5, 700, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-6) == 6){
                    bg.drawImage(score6, 700, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-6) == 7){
                    bg.drawImage(score7, 700, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-6) == 8){
                    bg.drawImage(score8, 700, 100, null);
                }else {
                    bg.drawImage(score9, 700, 100, null);
                }
            } else{bg.drawImage(score0, 700, 100, null);}

            //Ten Thousand's Digit
            if(scoreDigits.size()>=5){
                if(scoreDigits.get(scoreDigits.size()-5) == 0){
                    bg.drawImage(score0, 750, 100, null);
                }else if(scoreDigits.get(scoreDigits.size()-5) == 1){
                    bg.drawImage(score1, 750, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-5) == 2){
                    bg.drawImage(score2, 750, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-5) == 3){
                    bg.drawImage(score3, 750, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-5) == 4){
                    bg.drawImage(score4, 750, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-5)== 5){
                    bg.drawImage(score5, 750, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-5) == 6){
                    bg.drawImage(score6, 750, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-5) == 7){
                    bg.drawImage(score7, 750, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-5) == 8){
                    bg.drawImage(score8, 750, 100, null);
                }else {
                    bg.drawImage(score9, 750, 100, null);
                }
            } else{bg.drawImage(score0, 750, 100, null);}

            //Thousand's Digit
            if(scoreDigits.size()>=4){
                if(scoreDigits.get(scoreDigits.size()-4) == 0){
                    bg.drawImage(score0, 800, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-4) == 1){
                    bg.drawImage(score1, 800, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-4) == 2){
                    bg.drawImage(score2, 800, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-4) == 3){
                    bg.drawImage(score3, 800, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-4) == 4){
                    bg.drawImage(score4, 800, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-4)== 5){
                    bg.drawImage(score5, 800, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-4) == 6){
                    bg.drawImage(score6, 800, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-4) == 7){
                    bg.drawImage(score7, 800, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-4) == 8){
                    bg.drawImage(score8, 800, 100, null);
                }else {
                    bg.drawImage(score9, 800, 100, null);
                }
            } else {bg.drawImage(score0, 800, 100, null);}
            //Hundred's digit
            if(scoreDigits.size()>=3){
                if(scoreDigits.get(scoreDigits.size()-3) == 0){
                    bg.drawImage(score0, 850, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-3) == 1){
                    bg.drawImage(score1, 850, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-3) == 2){
                    bg.drawImage(score2, 850, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-3) == 3){
                    bg.drawImage(score3, 850, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-3) == 4){
                    bg.drawImage(score4, 850, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-3)== 5){
                    bg.drawImage(score5, 850, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-3) == 6){
                    bg.drawImage(score6, 850, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-3) == 7){
                    bg.drawImage(score7, 850, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-3) == 8){
                    bg.drawImage(score8, 850, 100, null);
                }else {
                    bg.drawImage(score9, 850, 100, null);
                }
            } else {bg.drawImage(score0, 850, 100, null);}
            //Ten's Digit
            if(scoreDigits.size()>=2){
                if(scoreDigits.get(scoreDigits.size()-2) == 0){
                    bg.drawImage(score0, 900, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-2) == 1){
                    bg.drawImage(score1, 900, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-2) == 2){
                    bg.drawImage(score2, 900, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-2) == 3){
                    bg.drawImage(score3, 900, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-2) == 4){
                    bg.drawImage(score4, 900, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-2)== 5){
                    bg.drawImage(score5, 900, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-2) == 6){
                    bg.drawImage(score6, 900, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-2) == 7){
                    bg.drawImage(score7, 900, 100, null);
                }else if (scoreDigits.get(scoreDigits.size()-2) == 8){
                    bg.drawImage(score8, 900, 100, null);
                }else {
                    bg.drawImage(score9, 900, 100, null);
                }
            } else {bg.drawImage(score0, 900, 100, null);}
            //One's Digit
            if(scoreDigits.get(scoreDigits.size()-1) == 0){
                bg.drawImage(score0, 950, 100, null);
            } else if (scoreDigits.get(scoreDigits.size()-1) == 1){
                bg.drawImage(score1, 950, 100, null);
            }else if (scoreDigits.get(scoreDigits.size()-1) == 2){
                bg.drawImage(score2, 950, 100, null);
            }else if (scoreDigits.get(scoreDigits.size()-1) == 3){
                bg.drawImage(score3, 950, 100, null);
            }else if (scoreDigits.get(scoreDigits.size()-1) == 4){
                bg.drawImage(score4, 950, 100, null);
            }else if (scoreDigits.get(scoreDigits.size()-1)== 5){
                bg.drawImage(score5, 950, 100, null);
            }else if (scoreDigits.get(scoreDigits.size()-1) == 6){
                bg.drawImage(score6, 950, 100, null);
            }else if (scoreDigits.get(scoreDigits.size()-1) == 7){
                bg.drawImage(score7, 950, 100, null);
            }else if (scoreDigits.get(scoreDigits.size()-1) == 8){
                bg.drawImage(score8, 950, 100, null);
            }else {
                bg.drawImage(score9, 950, 100, null);
            }
        }
        scoreDigits.clear();
        x+=xInc;
        y+=1.0029;

        //Progress Bar
        bg.setColor(Color.BLACK);
        bg.fillRect(0,0,1024,20);
        bg.drawImage(pBarFull,14,1,null);
        bg.fillRect((int)(578*(y/11700))+14,0,1024,20);
        bg.drawImage(pBarEmpty, 10, -15, null);

        //(int)(1024*(y/11500))
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

    }
}

