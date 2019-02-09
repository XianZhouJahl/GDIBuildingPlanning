package zhou.xian.raemlicheObjekte;

import java.util.ArrayList;
import zhou.xian.bauteile.Decke;
import zhou.xian.bauteile.Mauerwerkswand;
import zhou.xian.bauteile.Rundstuetze;

public class Geschoss {
	
	private String bezeichnung;
	private double hoehe;
	
	private Decke decke;
	
	private ArrayList<Rundstuetze> rundstuetzen = new ArrayList<Rundstuetze>();
	private ArrayList<Mauerwerkswand> mauerwerkswaende = new ArrayList<Mauerwerkswand>();
	
	public Geschoss(String bezeichnung, double hoehe, Decke decke) {
		this.bezeichnung = bezeichnung;
		this.hoehe = hoehe;
		this.decke = decke;
		
	}

	public void addRundstuetze(Rundstuetze rundstuetze) {
		
		if (rundstuetzen.contains(rundstuetze))
			return;
		
		rundstuetzen.add(rundstuetze);
		rundstuetze.setGeschoss(this);
	}
	
	public ArrayList<Rundstuetze> getRundstuetzen() {
		return this.rundstuetzen;
	}
	
	public void addMauerwerkswand(Mauerwerkswand mauerwerkswand){

		if(mauerwerkswaende.contains(mauerwerkswand))
			return;
		
		mauerwerkswaende.add(mauerwerkswand);
		mauerwerkswand.setGeschoss(this);
	}
	
	public ArrayList<Mauerwerkswand> getMauerwerkswaende(){
		return this.mauerwerkswaende;
	}
	
	public Decke getDecke(){
		return this.decke;
	}
	
	public void setDecke(Decke decke){
		this.decke = decke;
	}

	public double getHoehe() {
		return hoehe;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}
}
