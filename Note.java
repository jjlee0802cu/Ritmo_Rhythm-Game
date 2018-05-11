import java.awt.Image;
import javax.swing.ImageIcon;
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

public class Note extends Thread{
    private Image noteBasicImage = Toolkit.getDefaultToolkit().getImage("whitebox.jpg");
    private int x,y;
    private String noteType;

    public Note(int x, int y, String noteType){
        this.x = x;
        this.y = y;
        this.noteType = noteType;
    }

    public void screenDraw(Graphics2D g2){
        if (noteType.equals("short")){
            g2.drawImage(noteBasicImage, x,y, null);
        }
        else if(noteType.equals("long")){
            g2.drawImage(noteBasicImage, x,y, null);
            g2.drawImage(noteBasicImage, x+100,y, null);
        }
    }

    public void drop(){
        y+= Main.NOTE_SPEED;

    }

    @Override
    public void run(){
        try{
            while(true){
                drop();
                Thread.sleep(Main.SLEEP_TIME);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

}