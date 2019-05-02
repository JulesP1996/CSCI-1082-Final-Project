package Lunar_Lander;

import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Landingspace {
  
    private Random random; // Random start position on X coordinate
    private Foundation f = new Foundation();
	public int x; // horizontal
	public int y; // vertical
	private BufferedImage landingSpace;
	public int landingWidth;
	public int landingHeight;

	public Landingspace() {

	}
	
 	public void initialize() {
 		random = new Random();
 		y = (int) (Foundation.HEIGHT * 0.91); // 91% of frame height
 		System.out.println("LandingPad: " + y);
 		x = random.nextInt(Foundation.WIDTH - landingWidth); // X random start
		System.out.println("LandingPad: " + x);
 	}

 	public void loadcontent() {
// 		try {
// 			File sourceimage = new File("H:/Java/LunarLander(newest)/Resources/platform.png");
// 			landingSpace = ImageIO. read(sourceimage);
// 			landingWidth = landingSpace.getWidth();
//		} catch (IOException ex) {
// 			Logger.getLogger(Landingspace.class.getName()).log(Level.SEVERE, null, ex);
// 		}
	}
}
  