package Lunar_Lander;

public class Main {
	
	public static void main(String[] args) {
		Foundation g = new Foundation();
		
		Landingspace l = new Landingspace();
	    g.addRenderable(l);
	    g.addUpdatable(l);
	    
//	    Debris d = new Debris();
//	    g.addRenderable(d);
//	    g.addUpdatable(d);
	    
	    
	    Rocket r = new Rocket();
	    g.addRenderable(r);
	    g.addUpdatable(r);
	    
	    Fuel f = new Fuel();
	    g.addRenderable(f);
	    g.addUpdatable(f);
			
		g.start();
			
	}
	
}
