import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.*;
import javax.swing.Timer;

/**
 * Playground is a class which represents the 2 dimensional "play ground" where the game RPSLKH is
 * played out. Playground produces a Java Applet onto which the graphics associated with the game RPSLKH are displayed.
 * @author Justin Lee jjl2245. Code attributed to cay horstmann, modified by Justin Lee.
 *
 */
public class Playground extends Applet {
	

	
	/**
	 * Initializes the Playground by creating components of the game with specified properties taken from Playground.html
	 * Specifically, this method initializes the Font details as specified by the html, creates the Throws and puts them
	 * into a ThrowCollection, and creates the Timer associated with this Playground.
	 */
	public void init() {
		Graphics2D g2D = (Graphics2D) getGraphics();	
		overlayImage = createImage(getWidth(), getHeight());
		bufferedGraphics = overlayImage.getGraphics();
		
		for(int i = 0; i < 4; i++) {
			collection1.add(new Block((int) (Math.random() * 100)));
		}
		
		for(int i = 0; i < 4; i++) {
			collection2.add(new Block((int) (Math.random() * 100)));
		}
		
		for(int i = 0; i < 4; i++) {
			collection3.add(new Block((int) (Math.random() * 100)));
		}
		
		for(int i = 0; i < 4; i++) {
			collection4.add(new Block((int) (Math.random() * 100)));
		}
		createTimer();
	}

	/**
	 * Paints the Playground.
	 * Specifically, the Playground is painted by painting its associated ThrowCollection and a message that displays
	 * "Game Over" in the case that the game is over. In the instance that a collision is detected, the paint method
	 * pauses the Playground's associated Timer.
	 */
	public void paint(Graphics g) {
		
		bufferedGraphics.clearRect(0, 0, getWidth(), getHeight());
		
		collection1.paint(bufferedGraphics);
		collection2.paint(bufferedGraphics);
		collection3.paint(bufferedGraphics);
		collection4.paint(bufferedGraphics);
				
		
		g.drawImage(overlayImage, 0, 0, this);
		
//		if(collection.getCollisionDetected() && !collection.getTieCollisionDetected()) {
//			pause(1000);
//		}
//		if(gameOver) {
//			g.setColor(new Color(150, 150, 150, 127));
//			g.setFont(new Font("Garamond", Font.BOLD, 30));
//			g.drawString("Game Over", (int) (getWidth() * 0.3), (int) (getHeight() * 0.3));
//		}
	}
	
	/**
	 * Updates the Playground by painting the components of the Playground.
	 */
	public void update(Graphics g) {
		paint(g);		
	}

	/**
	 * Starts the Timer associated with the Playground.
	 */
	public void start() {
		appletTimer.start();
	}
	
	/**
	 * Stops the Timer associated with the Playground.
	 */
	public void stop() {
		appletTimer.stop();
	}

	/**
	 * This method is called just before an applet is terminated. 
	 * However, because there is no need to perform any cleanup prior to the destruction of the applet, 
	 * there is no operation in this method.
	 */
	public void destroy() {
	}

	/**
	 * Pauses the Timer associated with the Playground by stopping the Timer, waiting for the specified delay, and then
	 * starting the Timer once again.
	 * @param delay The time length of the pause in milliseconds
	 */
	public void pause(int delay) {
		stop();
		try {
			Thread.sleep(delay);
		} catch (Exception e) {
		}
		start();
	}
	
	/*
	 * Initializes all font details as specified by the html and saves it in a data structure for easy future reference.
	 */
	private void initializeFontDetails() {
		htmlThrowNames = getParameter("throw").split(",");
//		for(int i = 0; i < Rules.getTHROWS().length; i++) {
//			htmlFontNames.add(getParameter("fontname").split(",")[i]);
//			String colorHexCode = getParameter("fontcolor").split(",")[i];
//			htmlFontColors.add(Color.decode(colorHexCode));
//			htmlFontSizes.add(Integer.parseInt(getParameter("fontsize").split(",")[i]));			
//		}
	}
	
	/*
	 * Creates a Timer associated with the Playground, which translates the ThrowCollection associated with the Playground
	 * at time intervals specified by the html. 
	 * If the time since the last collision event exceeds a time interval specified by the html, it is game over, and the 
	 * Timer stops. 
	 */
	private void createTimer() {
		htmlDelay = Integer.parseInt(getParameter("delay"));
		appletTimer = new Timer(htmlDelay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				collection1.translate();
				collection2.translate();
				collection3.translate();
				collection4.translate();
				
//				if(collection.getCollisionDetected()) {
//					noEventStartTime = System.currentTimeMillis();
//				}

//				long noEventTimeElapsed = System.currentTimeMillis() - noEventStartTime;
//				if(noEventTimeElapsed > htmlWaitTime) {
//					gameOver = true;
//					stop();
//				}	
				repaint();
				
			}
		});
	}
	
	private String[] htmlThrowNames;
	private ArrayList<String> htmlFontNames = new ArrayList<String>();
	private ArrayList<Color> htmlFontColors = new ArrayList<Color> ();
	private ArrayList<Integer> htmlFontSizes = new ArrayList<Integer>();
	
	private Rectangle2D throwRectangle;
	private BlockCollection collection1 = new BlockCollection(1);
	private BlockCollection collection2 = new BlockCollection(2);
	private BlockCollection collection3 = new BlockCollection(3);
	private BlockCollection collection4 = new BlockCollection(4);
	
	
	private int htmlDelay;
	private Timer appletTimer;
	private int htmlWaitTime;
	private long noEventStartTime = System.currentTimeMillis();
	private boolean gameOver = false;
	
	private Image overlayImage;
	private Graphics bufferedGraphics;
}
