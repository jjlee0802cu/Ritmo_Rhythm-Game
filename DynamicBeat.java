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

public class DynamicBeat extends JFrame{

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground;

    public DynamicBeat() {
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        introBackground = new ImageIcon("IntroBackground.jpg").getImage();
        new NoteGame();
    }

    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
        new NoteGame();
    }

    public void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        new NoteGame();
        this.repaint();

    }
}
