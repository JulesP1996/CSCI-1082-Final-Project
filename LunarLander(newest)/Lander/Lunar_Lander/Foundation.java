package Lunar_Lander;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Foundation {
    
    private Canvas game = new Canvas();
    public final static int WIDTH = 1366, HEIGHT = 768;
    
    private String gameName = "Lunar Lander";
    
    
    ///create helper thread for fuel
    private class FuelThread extends Thread {
    	Fuel f;
    	public FuelThread() {
    		f = new Fuel();
    	}
    	public FuelThread(Rocket R) {
    		f = new Fuel(R);
    	}
    	
    	@Override
    	public void run() {
    	 	
    	 	f.fuelUsed();  
    	}
    }
    
    
    public void start(){
        Dimension gameSize = new Dimension(WIDTH, HEIGHT);
        JFrame gameWindow = new JFrame(gameName);
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("H:/Java/LunarLander(newest)/Resources/background.jpg"));
        gameWindow.add(background);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(gameSize);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        game.setSize(gameSize);
        game.setMaximumSize(gameSize);
        game.setMinimumSize(gameSize);
        game.setPreferredSize(gameSize);
        gameWindow.add(game);
        gameWindow.setLocationRelativeTo(null);
        
        Rocket r = new Rocket(false, 0 , 30,50, this);
        Landingspace l = new Landingspace();
        Debris d = new Debris();
        gameWindow.addKeyListener(r);
        l.initialize();
        d.resetDebris();
        System.out.println("Debris: " + d.getCurrentDebris());
           
        final int TICKS_PER_SECOND = 60;
        final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
        final int MAX_FRAMESKIP = 5;

        long nextGameTick = System.currentTimeMillis();
        int loops;
        
        long timeAtLastFPSCheck = 0;
        int ticks = 0;
        
        boolean running = true;
        
		FuelThread th = new FuelThread(r);
		th.start();         
        
		while(running) {
			loops = 0;

			while (System.currentTimeMillis() > nextGameTick && loops < MAX_FRAMESKIP) {
				ticks++;
				nextGameTick += SKIP_TICKS;
				loops++;

			}
			if (r.isCrashed() == true) {
				System.out.println("Crashed");
				running = false;
				gameWindow.setEnabled(false);
			}
			if (r.isLanded() == true) {
				System.out.println("Landed");
				running = false;
				gameWindow.setEnabled(false);
			}
            
            if(System.currentTimeMillis() - timeAtLastFPSCheck >= 1000) {
                //System.out.println("FPS: " + ticks);
                gameWindow.setTitle(gameName + " - FPS: " + ticks);
                ticks = 0;
                timeAtLastFPSCheck = System.currentTimeMillis();
                
            }
        }
    }
}
