package Lunar_Lander;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class Debris extends JPanel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int debrisWidth = 100;
    private int debrisHorizontalSpacing = 210;
    private int debrisVerticalSpacing = 180;
    
    private float xVel = -5.0f;
    
    // The debris that is closest to the lunar
    private int nearestDebris;
    // An array to hold the debris coordinations 
    private float[][] debrisCoords = new float[3][2];
    
    private Random rand = new Random();
    
    public Debris() {}
    
    public void resetDebris() {
    	nearestDebris = 0;
         
        debrisCoords[0][0] = Foundation.WIDTH / 2;
        debrisCoords[1][0] = debrisCoords[0][0] + debrisWidth + debrisHorizontalSpacing;
        debrisCoords[2][0] = debrisCoords[1][0] + debrisWidth + debrisHorizontalSpacing;
        
        debrisCoords[0][1] = getRandomY();
        debrisCoords[1][1] = getRandomY();
        debrisCoords[2][1] = getRandomY();
        
    }
    
    public float[] getNearestDebris() {
        return debrisCoords[nearestDebris];
    }

    public void printCurrentDebris() {
        String coordinates = debrisCoords[nearestDebris][0]+"-"+ debrisCoords[nearestDebris][1];
    	System.out.print(coordinates);
    }
    
    public void printAllDebris() {
    	for(int index=0;index < 3; index++)
    		System.out.println("Debris "+index+": x:"+ debrisCoords[index][0]+" Y:"+ debrisCoords[index][1]);
    }

    
    public int getNearestDebrisID() {
        return nearestDebris;
    }
    
    public int getDebrisWidth() {
        return debrisWidth;
    }
    
    public int getDebrisHorizontalSpacing() {
        return debrisHorizontalSpacing;
    }
    
    public int getDebrisVerticalSpacing() {
        return debrisVerticalSpacing;
    }
    
    private int getRandomY() {
        return rand.nextInt((int)(Foundation.HEIGHT * 0.4f)) + (Foundation.HEIGHT / 10);
    }
    
    public void update() {    	
    	
    	debrisCoords[0][0] += xVel;
    	debrisCoords[1][0] += xVel;
    	debrisCoords[2][0] += xVel;
                
        if(debrisCoords[0][0] + debrisWidth < 0) {
            debrisCoords[0][0] = Foundation.WIDTH;
            debrisCoords[0][1] = getRandomY();
            nearestDebris = 1;
        }
        if(debrisCoords[1][0] + debrisWidth < 0) {
            debrisCoords[1][0] = Foundation.WIDTH;
            debrisCoords[1][1] = getRandomY();
            nearestDebris = 2;
        }
        if(debrisCoords[2][0] + debrisWidth < 0) {
            debrisCoords[2][0] = Foundation.WIDTH;
            debrisCoords[2][1] = getRandomY();
            nearestDebris = 0;
        }
        
        // Update debris coordinates
        switch(nearestDebris) {
            case 0:
                debrisCoords[0][0] = debrisCoords[0][0];
                debrisCoords[0][1] = debrisCoords[0][1];
                break;
            case 1:
                debrisCoords[1][0] = debrisCoords[1][0];
                debrisCoords[1][1] = debrisCoords[1][1];
                break;
            case 2:
                debrisCoords[2][0] = debrisCoords[2][0];
                debrisCoords[2][1] = debrisCoords[2][1];
                break;
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);

        g.drawOval((int) (debrisCoords[0][0] + (xVel)), 0, debrisWidth, (int) debrisCoords[0][1]);
        g.drawOval((int) (debrisCoords[0][0] + (xVel)), (int) (debrisCoords[0][1] + debrisVerticalSpacing), debrisWidth,Foundation.HEIGHT);
        
        
        g.drawOval((int) (debrisCoords[1][0] + (xVel)), 0, debrisWidth, (int) debrisCoords[1][1]);
        g.drawOval((int) (debrisCoords[1][0] + (xVel)), (int) (debrisCoords[1][1] + debrisVerticalSpacing), debrisWidth, Foundation.HEIGHT);
        
        
        g.drawOval((int) (debrisCoords[2][0] + (xVel)), 0, debrisWidth, (int) debrisCoords[2][1]);
        g.drawOval((int) (debrisCoords[2][0] + (xVel)), (int) (debrisCoords[2][1] + debrisVerticalSpacing), debrisWidth, Foundation.HEIGHT);
    }
    
}

