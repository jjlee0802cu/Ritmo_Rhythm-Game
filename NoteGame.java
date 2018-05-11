import java.util.*;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;


public class NoteGame extends Thread
{
    ArrayList<Note> noteList = new ArrayList<Note>();
    public void dropNotes(){
        noteList.add(new Note(228, 0, "short"));
        Note note = new Note(228,0,"short");
        
        note.start();
        noteList.add(note);
        
        noteList.add(new Note(332, 580, "short"));
        noteList.add(new Note(436, 500, "short"));
        noteList.add(new Note(540, 340, "long"));
        noteList.add(new Note(744, 325, "short"));
        noteList.add(new Note(848, 305, "short"));
        noteList.add(new Note(952, 305, "short"));

    }
        Image noteBasicImage = Toolkit.getDefaultToolkit().getImage("whitebox.jpg");
    public void screenDraw(Graphics2D g2){

        g2.drawImage(noteBasicImage, 0,0, null);
        for (int i=0;i<noteList.size();i++){
            Note note = noteList.get(i);
            note.screenDraw(g2);
        }
    }
    public NoteGame(){
        dropNotes();
    }
}
