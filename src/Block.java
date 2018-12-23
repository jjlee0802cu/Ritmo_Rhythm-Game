import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Throw is a class that represents a move in the game RPSLKH.
 * In this simplified representation of a throw, it is represented with a String or shape and additional properties such as
 * color, font, size, and a hit box that surrounds the Throw.
 * @author Justin Lee jjl2245.
 *
 */
public class Block{
	
	/**
	 * Constructs a Throw, whose properties are determined by the inputed parameters.
	 * @param windowWidth The window width of the applet
	 * @param windowHeight The window height of the applet
	 */
	public Block(int yCoord) {
		
		this.yCoord = 0;

		blockRectangle = new Rectangle2D.Double(xCoord, yCoord, BLOCKWIDTH, BLOCKHEIGHT);
	}
	
	/**
	 * Paints the Throw whose properties, positions and appearances are specified by the inputed instance
	 * @param g Graphics that will be drawn
	 */
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRect((int) blockRectangle.getX(), (int) blockRectangle.getY(), (int) blockRectangle.getWidth(), (int) blockRectangle.getHeight());
		
	}

	/**
	 * Translates or moves the Throw by altering the position of the Throw by its velocity.
	 * Also checks for whether or not the Throw has surpassed the boundaries of the applet window.
	 * Also translates or moves the hit box that surrounds the Throw. 
	 * @param windowWidth The window width of the applet
	 * @param windowHeight The window height of the applet
	 */
	public void translate(int dy) {
		yCoord += dy;
		
		blockRectangle = new Rectangle2D.Double(xCoord, yCoord, blockRectangle.getWidth(), blockRectangle.getHeight());
	}
	
	/**
	 * Gets the hit box rectangle that surrounds the Throw
	 * @return The hit box rectangle that surrounds the Throw
	 */
	public void setRectangleXCoord(int inXCoord) {
		xCoord = inXCoord;
	}
	
	private int xCoord;
	private int yCoord;
	private int dx;
	private int dy;
	
	private final int BLOCKWIDTH = 100;
	private final int BLOCKHEIGHT = 20;
	
	
	private Rectangle2D blockRectangle;
}
