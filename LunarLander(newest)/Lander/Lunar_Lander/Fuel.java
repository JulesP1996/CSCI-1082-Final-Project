package Lunar_Lander;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.imageio.ImageIO;

public class Fuel{

	private static double fuelAmount = 100;
	private double fuelLoss = 1;
	private Rocket r ;
	private BufferedImage landerCrashed; // Crashed Lander
	private BufferedImage fuelBar;

	public Fuel() {

	}

	public Fuel(Rocket R) {
		r=R;
	}

	public void fuelUsed() {
		//(Rocket.speedX != 0 || Rocket.speedY != 0) &&

		while (fuelAmount > 0 && r.isCrashed() == false && r.isLanded() == false)  {

			fuelLoss = Math.abs(r.speedX + r.speedY) / 2;
			fuelAmount -= fuelLoss;
			
				try {
		           Thread.sleep(1000);
				} catch (Exception e) {
		            e.printStackTrace();
		        }

			System.out.println("Fuel :"+fuelAmount);
		}
		if (fuelAmount <= 0) {
			System.out.println("Empty Fuel");
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
