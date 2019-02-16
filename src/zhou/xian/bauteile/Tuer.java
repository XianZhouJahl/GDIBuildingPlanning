package zhou.xian.bauteile;

public class Tuer extends Oeffnung {
	
	private String bezeichnung;
	
	public Tuer(String bezeichnung, double breite, double hoehe) {
		this.setBreite(breite);
		this.setHoehe(hoehe);
		this.bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}
}
