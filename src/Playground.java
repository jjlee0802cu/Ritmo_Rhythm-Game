import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Playground extends Applet {

	public void init() {
		
		htmlBackgroundImage = getParameter("background");
		try {
			backgroundImage = ImageIO.read(new File(htmlBackgroundImage));
		} catch (IOException e) {
			System.out.println("Couldn't find background image");
		}
		backgroundImage = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);

		for(int i = 0; i < 4; i++) {
			Column column = new Column(i);
			for(int j = 0; j < 3; j++) {
				column.add(new Block((int) (Math.random() * 200)));
			}
			columnCollection.add(column);
		}

		
		
		Beatmap currentLevel;
		try {
			currentLevel = new Beatmap("beatmap.osu");
	        Coordinates coord1 = currentLevel.getMap().get(0);
	        Coordinates coord2 = currentLevel.getMap().get(1);
	        Coordinates coord3 = currentLevel.getMap().get(2);
	        Coordinates coord4 = currentLevel.getMap().get(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		createTimer();
	}


	public void paint(Graphics g) {
		Image overlayImage = createImage(getWidth(), getHeight());
		Graphics bufferedGraphics = overlayImage.getGraphics();
		bufferedGraphics.clearRect(0, 0, getWidth(), getHeight());

		bufferedGraphics.drawImage(backgroundImage, 0, 0, null);
		bufferedGraphics.setColor(new Color(100, 100, 100, 50));
		bufferedGraphics.fillRect(50, 50, 500, getHeight() - 100);
		
		columnCollection.paint(bufferedGraphics);
				
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
	
	public void update(Graphics g) {
		paint(g);
	}

	public void start() {
		appletTimer.start();
	}
	
	public void stop() {
		appletTimer.stop();
	}

	public void destroy() {
	}

	private void createTimer() {
		appletTimer = new Timer(0, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(start) {
					currentTime = System.currentTimeMillis();
					start = false;
				}
				
				long elapsedTime = System.currentTimeMillis() - currentTime;
				double translation = elapsedTime / 5.0;
				
				
				columnCollection.translate(translation);
				
//				if(collection.getCollisionDetected()) {
//					noEventStartTime = System.currentTimeMillis();
//				}

//				long noEventTimeElapsed = System.currentTimeMillis() - noEventStartTime;
//				if(noEventTimeElapsed > htmlWaitTime) {
//					gameOver = true;
//					stop();
//				}	
				repaint();
				currentTime = System.currentTimeMillis();
			}
		});
	}
	
	//html variables
	private String htmlBackgroundImage;
	private int htmlWaitTime;
	
	private ColumnCollection columnCollection= new ColumnCollection();
	
	private Timer appletTimer;
	private long noEventStartTime = System.currentTimeMillis();//make boolean when song ends. not when no collision happens
	private boolean gameOver = false;
	
	private boolean start = true;
	private long currentTime;
	
    private Image backgroundImage;
}
