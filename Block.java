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
	public Block(int windowWidth, int windowHeight) {
		
		throwX = (int) 0;
		throwY = (int) 0;
		dx = 0;
		dy = -1;

		blockRectangle = new Rectangle2D.Double(throwX, throwY, 10.0, 10.0);
	}
	
	/**
	 * Paints the Throw whose properties, positions and appearances are specified by the inputed instance
	 * @param g Graphics that will be drawn
	 */
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int) blockRectangle.getX(), (int) blockRectangle.getY(), (int) blockRectangle.getWidth(), (int) blockRectangle.getHeight());
		
	}

	/**
	 * Translates or moves the Throw by altering the position of the Throw by its velocity.
	 * Also checks for whether or not the Throw has surpassed the boundaries of the applet window.
	 * Also translates or moves the hit box that surrounds the Throw. 
	 * @param windowWidth The window width of the applet
	 * @param windowHeight The window height of the applet
	 */
	public void translate(int windowWidth, int windowHeight) {
		throwX += dx;
		throwY -= dy;
		
		blockRectangle = new Rectangle2D.Double(throwX, throwY, blockRectangle.getWidth(), blockRectangle.getHeight());
	}
	
	/**
	 * Gets the hit box rectangle that surrounds the Throw
	 * @return The hit box rectangle that surrounds the Throw
	 */
	public Rectangle2D getRectangle() {
		return blockRectangle;
	}
	
	private int throwX;
	private int throwY;
	private int dx;
	private int dy;
	
	private Rectangle2D blockRectangle;
}
