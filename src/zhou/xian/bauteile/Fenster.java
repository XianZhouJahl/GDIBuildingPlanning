package zhou.xian.bauteile;

public class Fenster extends Oeffnung {
	
	private double bruestungshoehe;
	
	public Fenster(double bruestungshoehe, double breite, double hoehe){
		this.bruestungshoehe = bruestungshoehe;
		this.setBreite(breite);
		this.setHoehe(hoehe);
	}
	
	
}
