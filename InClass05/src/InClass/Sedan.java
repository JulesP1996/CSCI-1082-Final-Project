package InClass;

public class Sedan extends Car{
	
	private String engine;
	private String drivetype;
	private String transmission;
	
	public Sedan(String make, String model, int year, String engine, String drivetype, String transmission) {
		super(make, model, year);
		this.engine = engine;
		this.drivetype = drivetype;
		this.transmission = transmission;
	}
	
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getDrivetype() {
		return drivetype;
	}
	public void setDrivetype(String drivetype) {
		this.drivetype = drivetype;
	}
	
	@Override
	public String toString() {
		return "Sedan [" + super.toString() + "engine=" + engine + ", drivetype=" + drivetype + ", transmission=" + transmission + "]";
	}
	
	
	

}
