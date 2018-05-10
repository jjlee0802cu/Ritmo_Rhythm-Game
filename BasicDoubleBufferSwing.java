 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BasicDoubleBufferSwing {
    
    public static class Canvas extends JPanel {
        
        private static final long serialVersionUID = 1L;
                
        private Image offScreenImage = null;
        private Graphics offScreenGraphics = null;
        private Image offScreenImageDrawed = null;
        private Graphics offScreenGraphicsDrawed = null;              
        private Timer timer = new Timer();
        private int counter = 0;
        
        public Canvas() {
            timer.schedule(new AutomataTask(), 0, 100);
            this.setPreferredSize(new Dimension(800, 600));
            this.setBackground(Color.white);
        }
        /** 
         * Use double buffering.
         * @see java.awt.Component#update(java.awt.Graphics)
         */
        @Override
        public void update(Graphics g) {                                
            paint(g);
            System.out.println("update called ----------->");
        }
              
        /**
         * Draw this generation.
         * @see java.awt.Component#paint(java.awt.Graphics)
         */
        @Override
        public void paint(final Graphics g) {

            final Dimension d = getSize();
            if (offScreenImageDrawed == null) {   
                // Double-buffer: clear the offscreen image.                
                offScreenImageDrawed = createImage(d.width, d.height);   
            }          
            offScreenGraphicsDrawed = offScreenImageDrawed.getGraphics();      
            offScreenGraphicsDrawed.setColor(Color.white);
            offScreenGraphicsDrawed.fillRect(0, 0, d.width, d.height) ;                           
            /////////////////////
            // Paint Offscreen //
            /////////////////////
            renderOffScreen(offScreenImageDrawed.getGraphics());
            g.drawImage(offScreenImageDrawed, 0, 0, null);
        }
        
        public void renderOffScreen(final Graphics g) {
            g.setColor(Color.black);
            g.drawString("Test - " + counter, 100, 100);                                 
            System.out.println("INFO: paint - " + counter);
            counter++;
        }
        
        private class AutomataTask extends java.util.TimerTask {
            public void run() {
                // Run thread on event dispatching thread
                if (!EventQueue.isDispatchThread()) {
                    EventQueue.invokeLater(this);
                } else {
                    if (Canvas.this != null) {
                        Canvas.this.repaint();                        
                    }
                }
                
            } // End of Run
        }        
    }
    
    public static void main(final String [] args) {
        
        System.out.println("Running");
        final JFrame frame = new JFrame("Simple Double Buffer") {
            private static final long serialVersionUID = 1L;
            public void processWindowEvent(java.awt.event.WindowEvent e) {
                super.processWindowEvent(e);
                if (e.getID() == java.awt.event.WindowEvent.WINDOW_CLOSING) {
                    System.exit(-1);
                }
              }
        };
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setBackground(Color.white);
        frame.add(new Canvas());
        frame.pack();
        frame.setVisible(true);
      
    }
    
} // End of the Class //