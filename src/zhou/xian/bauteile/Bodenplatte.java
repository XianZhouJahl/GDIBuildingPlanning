package zhou.xian.bauteile;

public class Bodenplatte extends Fundament {
	
	private double breite;
	private double laenge;

	public Bodenplatte(double breite, double laenge, double tiefe, String festigkeitsklasse, double bewehrungsgrad) {
		this.breite = breite;
    	this.laenge = laenge;
    	this.setTiefe(tiefe);
    	this.setFestigkeitsklasse(festigkeitsklasse);
    	this.bewehrungsgrad = bewehrungsgrad;
	}
	
	public double getVolumen(){
		return(breite * laenge * this.getTiefe());
	};

}
