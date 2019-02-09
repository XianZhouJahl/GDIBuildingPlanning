package zhou.xian.bauteile;

public abstract class Stahlbetonbauteil implements Volumen {
	
	public static double STAHLDICHTE = 7860;
	protected double bewehrungsgrad;
	private String festigkeitsklasse;
	
	public double berechneBewehrungsmengeInTonnen() {
		// STAHLDICHTE * Volumen * Bewehrungsgrad / 1000  
		return (STAHLDICHTE * this.getVolumen() *this.bewehrungsgrad / 1000);
	}
	
	public String getFestigkeitsklasse() {
		return festigkeitsklasse;
	}
	
	public void setFestigkeitsklasse(String festigkeitsklasse) {
		this.festigkeitsklasse = festigkeitsklasse;
	}
}
