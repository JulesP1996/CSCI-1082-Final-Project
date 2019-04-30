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


public class Rocket extends Foundation implements KeyListener, Updatable, Renderable{

	private Random random; // Random X start position
	public int xPos; // X coordinate (2D)
	public int yPos; // Y coordinate (2D)
	public boolean landed; // Check if landed
	public boolean crashed; // Check if crashed
	private int speedAccelerating; // Acceleration
	public int maxLandingSpeed; // Max speed for land
	static double speedX; // Horizontal speed
	public double speedY; // Vertical speed
	public double speedGrav; // Gravity
	private BufferedImage landerRocket; // Lunar Lander
	private BufferedImage landerLanded; // Landed Lander
	private BufferedImage landerCrashed; // Crashed Lander
	private BufferedImage landerFlyingUp; // Lander going up Lander	
	private BufferedImage landerFlyingDown; // Accelerating Lander	
	private BufferedImage landerFlyingRight; // Lander flying left
	private BufferedImage landerFlyingLeft; // Lander flying right
	public int landerRocketWidth; // Read image width
	public int landerRocketHeight; // Read image height

	
	
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

	public boolean isLanded() {
		return landed;
	}

	public void setLanded(boolean landed) {
		this.landed = landed;
	}

	public boolean isCrashed() {
		return crashed;
	}

	public void setCrashed(boolean crashed) {
		this.crashed = crashed;
	}

	public int getMaxLandingSpeed() {
		return maxLandingSpeed;
	}

	public void setMaxLandingSpeed(int maxLandingSpeed) {
		this.maxLandingSpeed = maxLandingSpeed;
	}

	public static double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		Rocket.speedX = speedX;
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

	public Rocket(boolean crashed, int speedAccelerating, int landerRocketWidth, int landerRocketHeight) {
		super();
		this.crashed = crashed;
		this.speedAccelerating = speedAccelerating;
		this.landerRocketWidth = landerRocketWidth;
		this.landerRocketHeight = landerRocketHeight;
		initialize();
		loadcontent();

		xPos = random.nextInt(Foundation.WIDTH - landerRocketWidth); // X random start
		yPos = 0;
	}
	
	private void initialize() {
	random = new Random(); // Initialize random start

		speedAccelerating = 1;
		speedY = 1;
		speedGrav = -0.16;
		maxLandingSpeed = 5;
	
		
	}


	private void loadcontent() // Load resources
	{
		try {
			File landerRocketImg = new File("/Lunar_Lander/Resources/img/landerRocket.png");
			landerRocket = ImageIO.read(landerRocketImg);
			landerRocketWidth = landerRocket.getWidth();
			landerRocketHeight = landerRocket.getHeight();

			File landerLandedImg = new File("/Lunar_Lander/Resources/img/lander_landed.png");
			landerLanded = ImageIO.read(landerLandedImg);

			File landerCrashedImg = new File("/Lunar_Lander/Resources/img/lander_crash.png");
			landerCrashed = ImageIO.read(landerCrashedImg);

			File landerFlyingUpImg = new File("/Lunar_Lander/Resources/img/lander_fire_up.png");
			landerFlyingUp = ImageIO.read(landerFlyingUpImg);
			
			File landerFlyingDownImg = new File("/Lunar_Lander/Resources/img/lander_fire_down.png");
			landerFlyingDown = ImageIO.read(landerFlyingDownImg);
			
			File landerFlyingRightImg = new File("/Lunar_Lander/Resources/img/lander_fire_right.png");
			landerFlyingRight = ImageIO.read(landerFlyingRightImg);
			
			File landerFlyingLeftImg = new File("/Lunar_Lander/Resources/img/lander_fire_left.png");
			landerFlyingLeft = ImageIO.read(landerFlyingLeftImg);
			
		} catch (IOException ex) {
			Logger.getLogger(Rocket.class.getName())
					.log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	public void keyDown(KeyEvent ke, Graphics2D g2d) {
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) // Key DOWN
			speedY -= speedAccelerating;

		else {
			speedY -= speedGrav;
		}

		if (ke.getKeyCode() == KeyEvent.VK_UP){ // Key UP
			speedY += speedAccelerating;
		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){ // Key RIGHT
			speedX -= speedAccelerating;
		}
		if (ke.getKeyCode() == KeyEvent.VK_LEFT){ // Key LEFT
			speedX += speedAccelerating;
	        }
		if (ke.getKeyCode() == KeyEvent.VK_0){ // Cheat
			speedY = 0;
			speedX = 0;
		}
		xPos += speedX;
		yPos += speedY;
		
			if (landed) // Check if landed
			{
				g2d.drawImage(landerLanded, xPos, yPos, null);
			} else if (crashed) // Check if crashed
			{
				g2d.drawImage(landerCrashed, xPos, yPos, null);
			} else {
				if (ke.getKeyCode() == KeyEvent.VK_UP) // Draw fly image
				g2d.drawImage(landerFlyingDown, xPos, yPos, null);
				g2d.drawImage(landerRocket, xPos, yPos, null);

				if (ke.getKeyCode() == KeyEvent.VK_DOWN) // Draw fly image
				g2d.drawImage(landerFlyingUp, xPos, yPos, null);
				g2d.drawImage(landerRocket, xPos, yPos, null);

				if (ke.getKeyCode() == KeyEvent.VK_RIGHT) // Draw fly image
				g2d.drawImage(landerFlyingLeft, xPos, yPos, null);
				g2d.drawImage(landerRocket, xPos, yPos, null);

				if (ke.getKeyCode() == KeyEvent.VK_LEFT) // Draw fly image
				g2d.drawImage(landerFlyingRight, xPos, yPos, null);
				g2d.drawImage(landerRocket, xPos, yPos, null);
			}
	
	}
		

	public void keyUp(KeyEvent ke, Graphics2D g2d) {
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) // Key DOWN
			speedY += speedAccelerating;

		else {
			speedY += speedGrav;
		}

		if (ke.getKeyCode() == KeyEvent.VK_UP){ // Key UP
			speedY -= speedAccelerating;
		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT){ // Key RIGHT
			speedX += speedAccelerating;
		}
		if (ke.getKeyCode() == KeyEvent.VK_LEFT){ // Key LEFT
			speedX -= speedAccelerating;
	        }
		if (ke.getKeyCode() == KeyEvent.VK_0){ // Cheat
			speedY = 0;
			speedX = 0;
		}
		xPos += speedX;
		yPos += speedY;
	}


	
	@Override
	public void update(Input input) {
//		 for(Updatable u : updatables) {
//	            u.update(input);
//	        }
	}
  
	@Override
	public void render(Graphics2D g, float interpolation) {
//		g.fillRect((int) (landerRocketWidth + interpolation), 0, landerRocketWidth, (int) landerRocketHeight);
		g.drawImage(speedY <= 0 ? landerFlyingDown : landerFlyingUp, (int) landerRocketWidth, (int) (landerRocketHeight + (speedY * interpolation)), null);
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	
}