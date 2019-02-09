package zhou.xian.raemlicheObjekte;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import zhou.xian.bauteile.Decke;
import zhou.xian.bauteile.Fenster;
import zhou.xian.bauteile.Fundament;
import zhou.xian.bauteile.Mauerwerkswand;
import zhou.xian.bauteile.Oeffnung;
import zhou.xian.bauteile.Rundstuetze;
import zhou.xian.bauteile.Tuer;

public class Gebaeude {
	private String bezeichnung;
	private String bauherr_Vorname;
	private String bauherr_Nachname;
	private String strasse;
	private int hausnummer;
	private String plz;
	private String ort;
	
	private ArrayList <Geschoss> geschosse = new ArrayList <Geschoss>() ;  
	private ArrayList <Fundament> fundamente = new ArrayList <Fundament>(); 
	
	public Gebaeude(String bezeichnung, String bauherr_Vorname, String bauherr_Nachname, 
			String strasse, int hausnummer, String plz, String ort) {
		this.bezeichnung = bezeichnung;
		this.bauherr_Vorname = bauherr_Vorname;
		this.bauherr_Nachname =bauherr_Nachname ;
		this.strasse =strasse ;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}

	public int anzahlFenster() {
		int anzahl = 0;
		
		ArrayList <Geschoss> geschosse = getGeschosse();
		
		for(int i = 0; i < geschosse.size(); i++) {
			Geschoss geschoss = geschosse.get(i);
			
			ArrayList<Mauerwerkswand> mauerwerkswaende = geschoss.getMauerwerkswaende();
			for(int j = 0; j< mauerwerkswaende.size(); j++) {
				Mauerwerkswand mauerwerkswand = mauerwerkswaende.get(j);
				
				ArrayList<Oeffnung> oeffnungen = mauerwerkswand.getOeffnungen();
				for(int k = 0; k < oeffnungen.size(); k ++){
					Oeffnung oeffnung = oeffnungen.get(k);
					
					if(oeffnung instanceof Fenster) {
						anzahl++;
					}
				}
			}
		}
		return anzahl;
	}
		
	public int anzahlTueren() {
		int anzahl = 0;
		
		ArrayList <Geschoss> geschosse = getGeschosse();
		
		for(int i = 0; i < geschosse.size(); i++) {
			Geschoss geschoss = geschosse.get(i);
			
			ArrayList<Mauerwerkswand> mauerwerkswaende = geschoss.getMauerwerkswaende();
			for(int j = 0; j< mauerwerkswaende.size(); j++) {
				Mauerwerkswand mauerwerkswand = mauerwerkswaende.get(j);
				
				ArrayList<Oeffnung> oeffnungen = mauerwerkswand.getOeffnungen();
				for(int k = 0; k < oeffnungen.size(); k ++){
					Oeffnung oeffnung = oeffnungen.get(k);
					
					if(oeffnung instanceof Tuer) {
						anzahl++;
					}
				}
			}
		}
		return anzahl;
	}
	
	public HashMap<String, Double> ermittleVolumenProFestigkeitsklasse() {
		HashMap<String, Double> voluminas = new HashMap<String, Double>();
		
		for(int i = 0; i < this.getFundamente().size(); i++) {
			Fundament fundament = this.getFundamente().get(i);
			String festigkeitsklasse = fundament.getFestigkeitsklasse();
			double volumen = fundament.getVolumen();
			System.out.println(festigkeitsklasse + " " + volumen+ "  " + fundament.getClass().getSimpleName());
			
			if (voluminas.containsKey(festigkeitsklasse)) {
				volumen = volumen + voluminas.get(festigkeitsklasse);
			}
			voluminas.put(festigkeitsklasse, volumen);
			System.out.println(festigkeitsklasse + " " + volumen);
		}
		
		for(int e = 0; e < this.getGeschosse().size(); e++){
			Geschoss geschoss = this.getGeschosse().get(e);
			
			for(int r = 0; r < geschoss.getRundstuetzen().size(); r++){
				Rundstuetze rundstuetze = geschoss.getRundstuetzen().get(r); 
				
				String festigkeitsklasse = rundstuetze.getFestigkeitsklasse();
				double volumen = rundstuetze.getVolumen();
				System.out.println(festigkeitsklasse + " " + volumen+ "  " + rundstuetze.getClass().getSimpleName());
				
				if (voluminas.containsKey(festigkeitsklasse)) {
					volumen = volumen + voluminas.get(festigkeitsklasse);
				}
				voluminas.put(festigkeitsklasse, volumen);
				System.out.println(festigkeitsklasse + " " + volumen );
			}
			
			Decke decke = geschoss.getDecke();
			String festigkeitsklasse = decke.getFestigkeitsklasse();
			double volumen = decke.getVolumen();
			System.out.println(festigkeitsklasse + " " + volumen+ "  " + decke.getClass().getSimpleName());
			
			if (voluminas.containsKey(festigkeitsklasse)) {
				volumen = volumen + voluminas.get(festigkeitsklasse);
			}
			voluminas.put(festigkeitsklasse, volumen);
			System.out.println(festigkeitsklasse + " " + volumen);
		}
		
		return voluminas;
	}
	
	public HashMap<Double, Double> ermittleFlaecheproWanddicke(){
		HashMap <Double, Double> flaecheProDicke = new HashMap<Double, Double>();
		
		for(int i = 0; i < this.geschosse.size(); i++){
			Geschoss geschoss = this.geschosse.get(i);
			
			for(int z = 0; z < geschoss.getMauerwerkswaende().size(); z++){
				Mauerwerkswand mauerwerkswand = geschoss.getMauerwerkswaende().get(z);
				double dicke = mauerwerkswand.getDicke();
				double flaeche = this.ermittleFlaeche(mauerwerkswand);
				
				if (flaecheProDicke.containsKey(dicke)) {
					flaeche = flaeche + flaecheProDicke.get(dicke);
				}
				flaecheProDicke.put(dicke, flaeche);
			}
		}	
		return flaecheProDicke;
	};
	
	public double berechneBewehrungsmengen(){
		double bewehrungsmenge = 0;
		
		for(int i = 0 ; i < this.fundamente.size(); i++){
			Fundament fundament = this.getFundamente().get(i);
			bewehrungsmenge = bewehrungsmenge + fundament.berechneBewehrungsmengeInTonnen();	
			System.out.println("Die Bewehrungsmenge von "+fundament.getClass().getSimpleName() +" in Tonnen : " + fundament.berechneBewehrungsmengeInTonnen());
		}
				
		for(int b = 0; b < this.geschosse.size(); b++){
			Geschoss geschoss = this.geschosse.get(b);
			bewehrungsmenge = bewehrungsmenge + geschoss.getDecke().berechneBewehrungsmengeInTonnen();
			System.out.println("Die Bewehrungsmenge von " +geschoss.getDecke().getClass().getSimpleName() + " in Tonnen : " + geschoss.getDecke().berechneBewehrungsmengeInTonnen());			
			
			for(int a = 0 ; a < geschoss.getRundstuetzen().size(); a++){
				Rundstuetze rundstuetze = geschoss.getRundstuetzen().get(a);
				bewehrungsmenge = bewehrungsmenge + rundstuetze.berechneBewehrungsmengeInTonnen();
				System.out.println("Die Bewehrungsmenge von " +rundstuetze.getClass().getSimpleName() + " in Tonnen : " + rundstuetze.berechneBewehrungsmengeInTonnen());
				
			}
		}
		return bewehrungsmenge;
	};
	
	public double seitlicheFlächeallerWände() {
		double gesamtFlaeche = 0;
		
		for (int i = 0; i < this.getGeschosse().size(); i++) {
			Geschoss geschoss = this.getGeschosse().get(i);
			
			for (int j = 0; j < geschoss.getMauerwerkswaende().size(); j++) {
				Mauerwerkswand mauerwerkswand = geschoss.getMauerwerkswaende().get(j);
				double flaechederWand = ermittleFlaeche(mauerwerkswand);
				
				System.out.println("Die Fläche der Wand ohne relevante Oefnungen von " + geschoss.getClass().getSimpleName() + " ist " + flaechederWand);
				gesamtFlaeche = gesamtFlaeche + flaechederWand;
			}
		}
		return gesamtFlaeche;
	}

	private double ermittleFlaeche(Mauerwerkswand mauerwerkswand) {
		double flaechederWand = mauerwerkswand.getLaenge() * (mauerwerkswand.getGeschoss().getHoehe() - mauerwerkswand.getGeschoss().getDecke().getHoehe()); 
		
		//System.out.println("Die Fläche der Wand von " + mauerwerkswand.getGeschoss().getClass().getSimpleName() + " ist " + flaechederWand);
		
		for(int k = 0; k < mauerwerkswand.getOeffnungen().size(); k++){
			Oeffnung oeffnung = mauerwerkswand.getOeffnungen().get(k);
			double flaechederOeffnung = oeffnung.getBreite() * oeffnung.getHoehe();
			
			if(flaechederOeffnung > 2.5){
			//	System.out.println("Relevante Oeffnung mit " + flaechederOeffnung);
				flaechederWand = flaechederWand - flaechederOeffnung;
			}
		}
		return flaechederWand;
	}
	
	public void addGeschoss(Geschoss geschoss) {
		if(geschosse.contains(geschosse))
			return;
		geschosse.add(geschoss);
	}
	
	public ArrayList<Geschoss> getGeschosse(){
		return this.geschosse;
	}
	
	public void addFundament(Fundament fundament){
		if(fundamente.contains(fundament))
			return;
		fundamente.add(fundament);
	}
	
	public ArrayList<Fundament> getFundamente(){
		return this.fundamente;
	}
	
	public String erstelleBericht(boolean seitlicheWandfläche, 
								 boolean betonundBewehrungsmenge, boolean fensterundTüranzahl){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.bauherr_Nachname + ", " +this.bauherr_Vorname +"\n");
		stringBuilder.append("Umweltingenieurwesen                            " + this.hausnummer + "" +this.plz +"\n");
		stringBuilder.append("-----------------------------------------------------------------" +"\n");
		stringBuilder.append("Gebäudemodell                            : " + this.bezeichnung +"\n");
		stringBuilder.append("Bauherr                                  : " + this.bauherr_Vorname + " " + this.bauherr_Nachname +"\n");
		stringBuilder.append("Anschrift                                : " + this.strasse + " " + this.hausnummer+"\n");
		stringBuilder.append("                                         : " + this.plz + " " + this.ort +"\n");
		stringBuilder.append("Geschosse                                : " + this.geschosse.size() +"\n");
		stringBuilder.append("\n");
		stringBuilder.append("MENGENERMITTLUNG\n");
		HashMap<Double, Double> flaecheProDicke = this.ermittleFlaecheproWanddicke();
		stringBuilder.append("vorhandene Mauerwerksdicke               : ");
		Iterator<Double> dickeItr = flaecheProDicke.keySet().iterator();
		
		while(dickeItr.hasNext()){
			stringBuilder.append(dickeItr.next() * 100);
			
			if(dickeItr.hasNext()){
				 stringBuilder.append(", ");
			}
		}	
		stringBuilder.append(" cm"+"\n");
		
		if (seitlicheWandfläche) {
			for (Double dicke : flaecheProDicke.keySet()) {
				stringBuilder.append("Wandfläche " + dicke + "er" + " Mauerwerk          \t : "
						+ String.format("%1.4f", flaecheProDicke.get(dicke)) + " m²\n");
			}
		}
		HashMap<String, Double> volumenProFestigkeitsklasse = this.ermittleVolumenProFestigkeitsklasse();	
		stringBuilder.append("vorhandene Betonfestigkeitsklassen       : ");
		Iterator<String> klassenItr = volumenProFestigkeitsklasse.keySet().iterator();
		
		while(klassenItr.hasNext()){
			stringBuilder.append(klassenItr.next());
			
			if(klassenItr.hasNext()){
				 stringBuilder.append(", ");
			}
		}	
		stringBuilder.append("\n");
		if (betonundBewehrungsmenge) {
			for (String klasse : volumenProFestigkeitsklasse.keySet()) {
				stringBuilder.append("Betongmenge " + klasse + "                       : "
						+ String.format("%1.4f", volumenProFestigkeitsklasse.get(klasse)) + " m³\n");
			}
			stringBuilder.append(
					"Bewehrungsmenge                          : " + String.format("%1.4f", this.berechneBewehrungsmengen()) + " to" + "\n");
		}
		if(fensterundTüranzahl) {
			stringBuilder.append("Fenster                                  : " + this.anzahlFenster()+"\n");
			stringBuilder.append("Türen                                    : " + this.anzahlTueren() +"\n");
		}
		stringBuilder.append("-----------------------------------------------------------------" +"\n");
		Date date = java.util.Calendar.getInstance().getTime();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
		stringBuilder.append("Ende des Berichts                          " + dateFormatter.format(date) +"\n");
		return stringBuilder.toString();  
	}

	public void schreibeInDatei(String dateiName, String inhalt) {
		FileWriter fw;
		try {
			fw = new FileWriter(dateiName);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(inhalt);
		    bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
