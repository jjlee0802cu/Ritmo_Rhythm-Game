import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * ThrowCollection is a class that represents a collection or group of Throws 
 * @author Justin Lee jjl2245.
 *
 */
public class ColumnCollection {
	
	/**
	 * Constructs a ThrowCollection
	 */
	public ColumnCollection() {
		columnCollection = new ArrayList<Column>();
	}
	
	/**
	 * Adds a Throw to the ThrowCollection
	 * @param inThrow The Throw that is to be added to the ThrowCollection
	 */
	public void add(Column inColumn) {
		columnCollection.add(inColumn);
	}
	
	/**
	 * Paints each Throw within the ThrowCollection, and if there is a collision the collision message 
	 * that displays who won and how is drawn. 
	 * @param g Graphics to draw
	 */
	public void paint(Graphics g) {
		for(Column column : columnCollection) {
			column.paint(g);
		}
	}
	

	public void translate(double dy) {
		for(Column column : columnCollection) {
			column.translate(dy);
		}
		//checkCollision();
	}

	private ArrayList<Column> columnCollection;
	
}
