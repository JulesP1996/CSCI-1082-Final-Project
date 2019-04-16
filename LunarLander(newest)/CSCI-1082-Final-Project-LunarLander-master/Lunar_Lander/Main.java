package Lunar_Lander;

public class Main {
	
	public static void main(String[] args) {
		Foundation g = new Foundation();
		
		  Landingspace l = new Landingspace();
	        
	        g.addRenderable(l);
//	        g.addUpdatable(l);
	        
//	        g.addRenderable(b);
//	        g.addUpdatable(b);
			
		g.start();
			
	}
	
}
