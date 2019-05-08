package Lunar_Lander;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Debris {
    
    private int debrisWidth = 100;
    private int debrisHorizontalSpacing = 210;
    private int debrisVerticalSpacing = 180;
    
    private float xVel = -5.0f;
    private float x1, x2, x3;
    private float y1, y2, y3;
    
    // The debris that is closest to the lunar
    private int currentDebris;
    // An array to hold the debris
    private float[][] debrisCoords = new float[3][2];
    
    private Random rand;
    
    public Debris() {

    }
    
    public void resetDebris() {
    	currentDebris = 0;
         rand = new Random();
         
        x1 = Foundation.WIDTH * 2;
        x2 = x1 + debrisWidth + debrisHorizontalSpacing;
        x3 = x2 + debrisWidth + debrisHorizontalSpacing;
        
        y1 = getRandomY();
        y2 = getRandomY();
        y3 = getRandomY();
        
    }
    
    public float[] getCurrentDebris() {
        return debrisCoords[currentDebris];
    }
    
    public int getCurrentDebrisID() {
        return currentDebris;
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
    
//    @Override
//    public void update(Input input) {
//        x1 += xVel;
//        x2 += xVel;
//        x3 += xVel;
//        
//        if(x1 + debrisWidth < 0) {
//            x1 = Foundation.WIDTH;
//            y1 = getRandomY();
//            currentDebris = 1;
//        }
//        if(x2 + debrisWidth < 0) {
//            x2 = Foundation.WIDTH;
//            y2 = getRandomY();
//            currentDebris = 2;
//        }
//        if(x3 + debrisWidth < 0) {
//            x3 = Foundation.WIDTH;
//            y3 = getRandomY();
//            currentDebris = 0;
//        }
//        
//        // Update debris coordinates
//        switch(currentDebris) {
//            case 0:
//                debrisCoords[0][0] = x1;
//                debrisCoords[0][1] = y1;
//                break;
//            case 1:
//                debrisCoords[1][0] = x2;
//                debrisCoords[1][1] = y2;
//                break;
//            case 2:
//                debrisCoords[2][0] = x3;
//                debrisCoords[2][1] = y3;
//                break;
//        }
//    }
//    
////    @Override
////    public void render(Graphics2D g, float interpolation) {
////        g.setColor(Color.BLUE);
////        
////        // Pipe 1
////        g.fillRect((int) (x1 + (xVel * interpolation)), 0, debrisWidth, (int) y1);
////        g.fillRect((int) (x1 + (xVel * interpolation)), (int) (y1 + debrisVerticalSpacing), debrisWidth, Game.HEIGHT);
////        
////        // Pipe 2
////        g.fillRect((int) (x2 + (xVel * interpolation)), 0, debrisWidth, (int) y2);
////        g.fillRect((int) (x2 + (xVel * interpolation)), (int) (y2 + debrisVerticalSpacing), debrisWidth, Game.HEIGHT);
////        
////        // Pipe 3
////        g.fillRect((int) (x3 + (xVel * interpolation)), 0, debrisWidth, (int) y3);
////        g.fillRect((int) (x3 + (xVel * interpolation)), (int) (y3 + debrisVerticalSpacing), debrisWidth, Game.HEIGHT);
////    }
//    
}

