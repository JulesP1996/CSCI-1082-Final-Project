package Lunar_Lander;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.Control;

public class Rocket implements KeyListener{

	private Random random; // Random X start position
	public int xPos; // X coordinate (2D)
	public int yPos; // Y coordinate (2D)
	public boolean landed; // Check if landed
	public boolean crashed; // Check if crashed
	private int speedAccelerating; // Acceleration
	public int maxLandingSpeed; // Max speed for land
	public double speedX; // Horizontal speed
	public double speedY; // Vertical speed
	public double speedGrav; // Gravity
	private BufferedImage landerRocket; // Lunar Lander
	private BufferedImage landerLanded; // Landed Lander
	private BufferedImage landerCrashed; // Crashed Lander
	private BufferedImage landerFlyingUp; // Lander going up Lander
	private BufferedImage landerFlyingDown; // Accelerating Lander
	private BufferedImage landerFlyingRight; // Lander flying left
	private BufferedImage landerFlyingLeft; // Lander flying right
	private Foundation f = new Foundation();
	private Landingspace l = new Landingspace();
	private Debris d = new Debris();
	public int landerRocketWidth; // Read image width
	public int landerRocketHeight; // Read image height

	public Rocket(boolean crashed, int speedAccelerating, int landerRocketWidth, int landerRocketHeight, Foundation f) {
		this.crashed = crashed;
		this.speedAccelerating = speedAccelerating;
		this.landerRocketWidth = landerRocketWidth;
		this.landerRocketHeight = landerRocketHeight;
		this.f = f;
		initialize();
		loadcontent();


		xPos =random.nextInt(Foundation.WIDTH - landerRocketWidth); // X random start
		System.out.println("Rocket: " + xPos + " " + yPos);
		yPos = 0;
	}


	public Rocket() {
		
	}


	private void initialize() {
		random = new Random(); // Initialize random start

		speedAccelerating = 2;
		speedY = 0;
		speedX = 0;
		speedGrav = -0.16;
		maxLandingSpeed = 5;

	}

	private void loadcontent() // Load resources
	{
//		try {
//			File landerRocketImg = new File("/LunarLander(newest)/Resources/shipResize.png");
//			landerRocket = ImageIO.read(landerRocketImg);
//			landerRocketWidth = landerRocket.getWidth();
//			landerRocketHeight = landerRocket.getHeight();
//
//			File landerLandedImg = new File("/LunarLander(newest)/Resources/Word Art.png");
//			landerLanded = ImageIO.read(landerLandedImg);
//
//			File landerCrashedImg = new File("/LunarLander(newest)/Resources/Word Art (1).png ");
//			landerCrashed = ImageIO.read(landerCrashedImg);
//
//			File landerFlyingUpImg = new File("/LunarLander(newest)/Resources/fireUp.png");
//			landerFlyingUp = ImageIO.read(landerFlyingUpImg);
//
//			File landerFlyingDownImg = new File("/LunarLander(newest)/Resources/down.png");
//			landerFlyingDown = ImageIO.read(landerFlyingDownImg);
//
//			File landerFlyingRightImg = new File("/LunarLander(newest)/Resources/fire.png");
//			landerFlyingRight = ImageIO.read(landerFlyingRightImg);
//
//			File landerFlyingLeftImg = new File("/LunarLander(newest)/Resources/fireLeft.png");
//			landerFlyingLeft = ImageIO.read(landerFlyingLeftImg);
//
//		} catch (IOException ex) {
//			Logger.getLogger(Rocket.class.getName()).log(Level.SEVERE, null, ex);
//		}
	}
	
	public boolean isLanded() {
		if(xPos == 500 && yPos >= 698 && speedY <= maxLandingSpeed) {
			return true;
		}
		if(xPos == 500 && yPos >= 698 && speedY >= maxLandingSpeed) {
			return false;
		}
		return false;
	}

	public void setLanded(boolean landed) {
		this.landed = landed;
	}

	public boolean isCrashed() {
		if(xPos > f.WIDTH || xPos < 0 || yPos > f.HEIGHT || yPos < 0 || xPos == d.getNearestDebrisID()) {
			return true;
		}
		
		return false;
	}

	public void setCrashed(boolean crashed) {
		this.crashed = crashed;
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) // Key DOWN
		{	speedY += speedAccelerating;
			System.out.println("speedY: "+speedY);
			System.out.println(yPos);
			if(speedY > 20) {
				speedY = 19;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) { // Key UP
			speedY -= speedAccelerating;
			System.out.println("speedY: "+speedY);
			System.out.println(yPos);
			if(speedY < -20) {
				speedY = -19;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) { // Key RIGHT
			speedX += speedAccelerating;
			System.out.println("speedx: "+speedX);
			System.out.println(xPos);
			if(speedX > 20) {
				speedX = 19;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) { // Key LEFT
			speedX -= speedAccelerating;
			System.out.println("speedX: "+speedX);
			System.out.println(xPos);
			if(speedX < -20) {
				speedX = -19;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_0) { // Cheat
			speedY = 0;
			speedX = 0;
			System.out.println("speedX: "+speedX);
			System.out.println(xPos);
			System.out.println("speedY: "+speedY);
			System.out.println(yPos);
		}
		xPos += speedX;
		yPos += speedY;
		}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}
//		if (landed) // Check if landed
//		{
//			g2d.drawImage(landerLanded, xPos, yPos, null);
//		} else if (crashed) // Check if crashed
//		{
//			g2d.drawImage(landerCrashed, xPos, yPos, null);
//		} else {
//			if (ke.getKeyCode() == KeyEvent.VK_UP) // Draw fly image
//				g2d.drawImage(landerFlyingDown, xPos, yPos, null);
//			g2d.drawImage(landerRocket, xPos, yPos, null);
//
//			if (ke.getKeyCode() == KeyEvent.VK_DOWN) // Draw fly image
//				g2d.drawImage(landerFlyingUp, xPos, yPos, null);
//			g2d.drawImage(landerRocket, xPos, yPos, null);
//
//			if (ke.getKeyCode() == KeyEvent.VK_RIGHT) // Draw fly image
//				g2d.drawImage(landerFlyingLeft, xPos, yPos, null);
//			g2d.drawImage(landerRocket, xPos, yPos, null);
//
//			if (ke.getKeyCode() == KeyEvent.VK_LEFT) // Draw fly image
//				g2d.drawImage(landerFlyingRight, xPos, yPos, null);
//			g2d.drawImage(landerRocket, xPos, yPos, null);
//		}


	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getMaxLandingSpeed() {
		return maxLandingSpeed;
	}

	public void setMaxLandingSpeed(int maxLandingSpeed) {
		this.maxLandingSpeed = maxLandingSpeed;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public double getSpeedGrav() {
		return speedGrav;
	}

	public void setSpeedGrav(double speedGrav) {
		this.speedGrav = speedGrav;
	}
}
