package Lunar_Lander;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.imageio.ImageIO;

public class Fuel{

	private int xPos;
	private int yPos;
	private static double fuelAmount = 100;
	private double fuelLoss = 0.5;
	private Rocket r = new Rocket();
	private BufferedImage landerCrashed; // Crashed Lander
	private BufferedImage fuelBar;

	public void fuelUsed() {
		while (Rocket.speedX != 0 && Rocket.speedY != 0 && fuelAmount > 0) {
			fuelLoss = Math.abs(Rocket.speedX + Rocket.speedY) / 10;
			fuelAmount -= fuelLoss;
			
			if (r.isCrashed() == false) {
				try {
		           Thread.sleep(1000);
		           if (r.isCrashed() == true) {
				   break;
		           }
				} catch (Exception e) {
		            e.printStackTrace();
		        }
			}
			
			System.out.println(fuelAmount);
		}
		if (fuelAmount <= 0) {
			System.out.println("Crashed");
			// File landerCrashedImg = new
			// File("/LunarLander(newest)/Resources/explosion1.png");
			// try {
			// landerCrashed = ImageIO.read(landerCrashedImg);
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
	}

	
}
