package Lunar_Lander;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Fuel {

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
			URL landerCrashedURL = this.getClass().getResource("/lunar_lander/resources/img/lander_crash.png");
			try {
				landerCrashed = ImageIO.read(landerCrashedURL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
