package lunarLander;

import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Landingspace {
  
  private Random random; // Random start position on X coordinate

	public int x; // horizontal

	public int y; // vertical

	private BufferedImage landingSpace;

	public int landingWidth;
	public int landingHeight;

	public Landingspace() {
		initialize();
		loadcontent();

// 		x = random.nextInt(Framework.frameWidth - landingSpaceWidth); // X random start
// 	}

// 	private void initialize() {
// 		random = new Random();
// 		y = (int) (Framework.frameHeight * 0.95); // 95% of frame height
// 	}

// 	private void loadcontent() {
// 		try {
// 			URL landingSpaceUrl = this.getClass().getResource("/lunar_lander/resources/img/landing_area.png");
// 			landingSpace = ImageIO.read(landingSpaceUrl);
// 			landingSpaceWidth = landingSpace.getWidth();
// 		} catch (IOException ex) {
// 			Logger.getLogger(Landingspace.class.getName()).log(Level.SEVERE, null, ex);
// 		}
// 	}

// 	public void draw(Graphics2D g2d) {
// 		g2d.drawImage(landingSpace, x, y, null);
// 	}

// }
  
}
