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

public class Landingspace extends Foundation implements Renderable, Updatable {
  
  private Random random; // Random start position on X coordinate

	public int x; // horizontal

	public int y; // vertical

	private BufferedImage landingSpace;

	public int landingWidth;
	public int landingHeight;

	public Landingspace() {
		initialize();
		loadcontent();
		
		x = random.nextInt(Foundation.WIDTH - landingWidth); // X random start
		System.out.println(x);
	}
 	public void initialize() {
 		random = new Random();
 		y = (int) (Foundation.HEIGHT * 0.91); // 91% of frame height
 		System.out.println(y);
 	}

 	public void loadcontent() {
 		try {
 			File sourceimage = new File("H:/Java/LunarLander(newest)/Resources/platform.png");
 			landingSpace = ImageIO. read(sourceimage);
 			landingWidth = landingSpace.getWidth();
		} catch (IOException ex) {
 			Logger.getLogger(Landingspace.class.getName()).log(Level.SEVERE, null, ex);
 		}
	}

 	public void draw(Graphics2D g2d) {
 		g2d.drawImage(landingSpace, x, y, null); 	
 	}
 	
	@Override
	public void render(Graphics2D g, float interpolation) {
		g.fillRect((int) (landingWidth + interpolation), 0, landingWidth, (int) y);
       
	}
	@Override
	public void update(Input input) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void update(Input input) {
//		 for(Updatable u : updatables) {
//	            u.update(input);
//	        }
//	}

}
  