package zhou.xian.bauteile;

import zhou.xian.raemlicheObjekte.Geschoss;

public class Einzelfundament extends Fundament {
	private double breite;
	
	
	public Einzelfundament(double breite, double tiefe, String festigkeitsklasse, double bewehrungsgrad) {
		this.breite = breite;
		this.setTiefe(tiefe);
		this.setFestigkeitsklasse(festigkeitsklasse);
		this.bewehrungsgrad = bewehrungsgrad;
	}
	
	public double getVolumen(){
		return (Math.pow(breite, 2) * this.getTiefe());
	};
}
