package Lunar_Lander;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Fuel implements Updatable, Renderable{

	private int xPos;
	private int yPos;
	private static int fuelAmount = 100;
	private int fuelLoss = 5;
	private BufferedImage landerCrashed; // Crashed Lander
	private BufferedImage fuelBar;


	public Fuel() {
		initialize();
		
	}

	private void initialize() {
		fuelUsed();
	}

	public void fuelUsed(){
		while (Rocket.speedX > 0 && fuelAmount > 0) {
			fuelAmount -= fuelLoss;
		}
		if(fuelAmount == 0) {
			File landerCrashedImg = new File("/Lunar_Lander/Resources/img/lander_crash.png");
			try {
				landerCrashed = ImageIO.read(landerCrashedImg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void render(Graphics2D g, float interpolation) {
		
		
	}

	@Override
	public void update(Input input) {
//		 for(Updatable u : updatables) {
//	            u.update(input);
//	        }
	}
}