package zhou.xian.bauteile;

import java.util.ArrayList;

public class Decke extends Stahlbetonbauteil{
	private double breite;
	private double laenge;
	private double hoehe;
	private ArrayList <Oeffnung> oeffnungen = new ArrayList<Oeffnung>();
	

	
	public Decke(double breite, double laenge, double hoehe, String festigkeitsklasse, double bewehrungsgrad) {
		this.breite = breite;
		this.laenge = laenge;
		this.hoehe = hoehe;
		this.setFestigkeitsklasse(festigkeitsklasse);
		this.bewehrungsgrad = bewehrungsgrad;
	}
	
	public void addOeffnung(Oeffnung oeffnung){
		if(oeffnungen.contains(oeffnung))
			return;
		oeffnungen.add(oeffnung);
	}
	
	public ArrayList<Oeffnung> getOeffnung(){
		return this.oeffnungen;
	}

	public double getBreite() {
		return breite;
	}

	public double getLaenge() {
		return laenge;
	}

	public double getHoehe() {
		return hoehe;
	}
	
	public double getVolumen(){
		return (breite * laenge * hoehe);
	};
	
	
	
}
