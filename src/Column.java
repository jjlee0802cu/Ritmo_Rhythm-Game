import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * ThrowCollection is a class that represents a collection or group of Throws 
 * @author Justin Lee jjl2245.
 *
 */
public class Column {
	
	/**
	 * Constructs a ThrowCollection
	 */
	public Column(int columnNumber) {
		this.columnNumber = columnNumber;
		column = new ArrayList<Block>();
	}
	
	/**
	 * Adds a Throw to the ThrowCollection
	 * @param inThrow The Throw that is to be added to the ThrowCollection
	 */
	public void add(Block inBlock) {
		column.add(inBlock);
	}
	
	/**
	 * Paints each Throw within the ThrowCollection, and if there is a collision the collision message 
	 * that displays who won and how is drawn. 
	 * @param g Graphics to draw
	 */
	public void paint(Graphics g) {
		for(Block block : column) {
			block.setRectangleXCoord(100 + columnNumber * COLUMNWIDTH);
			block.paint(g);
		}
//		if(collisionDetected) {
//			g.setColor(winningThrow.getColor());
//			g.setFont(winningThrow.getFont().deriveFont((float) 15));
//			Rectangle2D winningThrowRectangle = winningThrow.getRectangle();
//			int collisionMessageX = (int) winningThrowRectangle.getX();
//			int collisionMessageY = (int) winningThrowRectangle.getY();
//			g.drawString(collisionMessage, collisionMessageX, collisionMessageY);
//		}
	}
	
	/**
	 * Translates each of the Throws within the ThrowCollection and checks for any resulting collisions between
	 * the Throws within the ThrowCollection.
	 * @param windowWidth The window width of the applet
	 * @param windowHeight The window height of the applet
	 */
	public void translate(double dy) {
		for(Block block : column) {
			block.translate(dy);
		}
		//checkCollision();
	}
	
	/**
	 * Checks for any collisions between the Throws within the ThrowCollection.
	 * In the instance of a collision, the game's Throws are updated, meaning the losing Throws are
	 * eliminated.
	 */
//	public void checkCollision() {
//		collisionDetected = false;
//		tieCollisionDetected = false;
//		for(int i = 0; i < collection.size() - 1; i++) {
//			Throw throw1 = collection.get(i);
//			for(int j = collection.indexOf(throw1) + 1; j < collection.size(); j++) {
//				Throw throw2 = collection.get(j);
//				if(throw1.getRectangle().intersects(throw2.getRectangle())) {
//					int gameResult = Rules.winDecider(throw1, throw2);
//					collisionMessage = Rules.collisionMessage(throw1, throw2);
//					collisionDetected = true;
//					if(gameResult == 0) {
//						tieCollisionDetected = true;
//					}
//					updateGameParticipants(gameResult, throw1, throw2);
//					if(gameResult == 1) {
//						j--;
//					} else if(gameResult == -1) {
//						i--;
//						break;
//					}
//				}
//			}
//		}
//	}
	
	/**
	 * Gets whether or not there is a collision detected between the Throws within the ThrowCollection
	 * @return Whether or not there is a collision detected between the Throws within the ThrowCollection
	 */
	public boolean getCollisionDetected() {
		return collisionDetected;
	}
	

	
//	/*
//	 * Updates the game's participants by:
//	 * Eliminating loser Throws from the ThrowCollection and increasing the size of the winner Throws.
//	 * In the instance of a collision between two black holes, the winner is whichever has a larger size.
//	 * In the instance of a collision between two black holes of the same size, the winner is determined randomly.
//	 */
//	private void updateGameParticipants(int gameResult, Throw throw1, Throw throw2) {
//		Throw winner = throw1;
//		Throw loser = throw2;
//		if(gameResult == 0) {
//			winningThrow = winner;
//			return;
//		}
//		if(gameResult == -1) {
//			winner = throw2;
//			loser = throw1;
//		} else if(gameResult == 2) {
//			if(throw1.getFont().getSize() < throw2.getFont().getSize()) {//if throw2 bh is bigger
//				winner = throw2;
//				loser = throw1;
//			} else if(throw1.getFont().getSize() == throw2.getFont().getSize()){//same size bh
//				int randomPick = (int) (Math.random() * 2);
//				if(randomPick == 1) {
//					winner = throw2;
//					loser = throw1;
//				}
//			}
//		}
//		winningThrow = winner;
//		winner.getBigger(loser);
//		eliminateLoser(loser);
//	}
	
//	/*
//	 * Eliminates the loser from the ThrowCollection
//	 */
//	private void eliminateLoser(Throw loser) {
//		int indexOfLoser = collection.indexOf(loser);
//		collection.remove(indexOfLoser);
//	}
	
	private ArrayList<Block> column;
	private int columnNumber;
	private final int COLUMNWIDTH = 100;
	
	private boolean collisionDetected = false;
	private boolean tieCollisionDetected = false;
	private String collisionMessage = "";
//	private Throw winningThrow;
}
