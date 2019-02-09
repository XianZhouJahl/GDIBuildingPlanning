package zhou.xian.bauteile;

import zhou.xian.raemlicheObjekte.Geschoss;

public class Rundstuetze extends Stahlbetonbauteil {
	private double durchmesser;
	
	private Geschoss geschoss;
	
	public Rundstuetze(double durchmesser, String festigkeitsklasse, double bewehrungsgrad) {
		this.durchmesser= durchmesser;
		this.setFestigkeitsklasse(festigkeitsklasse);
		this.bewehrungsgrad = bewehrungsgrad;
	}
	
	public void setGeschoss(Geschoss geschoss){
		
		if (this.geschoss == geschoss)
			return;
		
		this.geschoss = geschoss;
		this.geschoss.addRundstuetze(this);
	}
	
	public Geschoss getGeschoss(){
		return this.geschoss;
	}

	@Override
	public double getVolumen() {
		return (Math.PI * Math.pow(durchmesser/2, 2)) * (this.geschoss.getHoehe() - this.geschoss.getDecke().getHoehe());
	}

}
