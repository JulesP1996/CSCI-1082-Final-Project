package Lunar_Lander;

public class Main extends Foundation{
	
	public static void main(String[] args) {
		//Foundation g = new Foundation();
		
	    Landingspace l = new Landingspace();
	    l.loadcontent();
		
		Rocket r = new Rocket(false, 1, 25, 30);
	    r.setSpeedX(6);
		
//		Fuel f = new Fuel();
//	    f.fuelUsed();

		//g.start();
	
	}
	
}
