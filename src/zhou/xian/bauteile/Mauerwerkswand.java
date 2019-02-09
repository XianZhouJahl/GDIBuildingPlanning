package zhou.xian.bauteile;

import java.util.ArrayList;

import zhou.xian.raemlicheObjekte.Geschoss;

public class Mauerwerkswand {
	
	private double dicke;
	private double laenge;
	private Geschoss geschoss;
	
	private ArrayList<Oeffnung> oeffnungen = new ArrayList <Oeffnung>();

	public Mauerwerkswand(double dicke, double laenge, Geschoss geschoss) {
		this.dicke = dicke;
		this.laenge = laenge;
		this.geschoss = geschoss;
	}

	public void setGeschoss(Geschoss geschoss){
		
		if (this.geschoss == geschoss)
			return;
		
		this.geschoss = geschoss;
		this.geschoss.addMauerwerkswand(this);
	}
	
	public Geschoss getGeschoss(){
		return this.geschoss;
	}
	
	public void addOeffnung(Oeffnung oeffnung){
		if(oeffnungen.contains(oeffnung))
			return;
		oeffnungen.add(oeffnung);		
	}
	
	public ArrayList<Oeffnung> getOeffnungen(){
		return this.oeffnungen;
	}

	public double getDicke() {
		return dicke;
	}

	public double getLaenge() {
		return laenge;
	}
	
	

}
