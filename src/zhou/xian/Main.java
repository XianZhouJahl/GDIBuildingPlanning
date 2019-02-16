package zhou.xian;

import java.awt.EventQueue;

import zhou.xian.bauteile.Bodenplatte;
import zhou.xian.bauteile.Decke;
import zhou.xian.bauteile.Einzelfundament;
import zhou.xian.bauteile.Fenster;
import zhou.xian.bauteile.Mauerwerkswand;
import zhou.xian.bauteile.Rundstuetze;
import zhou.xian.bauteile.Tuer;
import zhou.xian.gUI.GebaeudeplanerGUI;
import zhou.xian.raemlicheObjekte.Gebaeude;
import zhou.xian.raemlicheObjekte.Geschoss;

public class Main {

	public static void main(String[] args) {
		Gebaeude neuesGebaeude = Main.baueGebaeudeZusammen();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GebaeudeplanerGUI window = new GebaeudeplanerGUI(neuesGebaeude);
					window.frmGebaeudeplaner.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static Gebaeude baueGebaeudeZusammen() {
		Gebaeude gebaeude = new Gebaeude("Haus", "Xian", "Zhou", "Unistraße", 351, "84737", "Kassel");
		Decke decke = new Decke(9.52,12.42,0.2,"C25/30",0.05);
		Geschoss geschoss = new Geschoss("Erdgeschoss",2.9,decke);
		gebaeude.addGeschoss(geschoss);
		Bodenplatte bodenplatte = new Bodenplatte(9.52, 8.02,0.14,"C25/30",0.03);
		gebaeude.addFundament(bodenplatte);
		Einzelfundament fundamentStütze1 = new Einzelfundament(0.6, 0.6, "C25/30", 0.03);
		Einzelfundament fundamentStütze2 = new Einzelfundament(0.6, 0.6, "C25/30", 0.03);
		Einzelfundament fundamentStütze3 = new Einzelfundament(0.6, 0.6, "C25/30", 0.03);
		gebaeude.addFundament(fundamentStütze1);
		gebaeude.addFundament(fundamentStütze2);
		gebaeude.addFundament(fundamentStütze3);
		Fenster fenster1 = new Fenster(1.00,2.01,1.26);
		Fenster fenster2 = new Fenster(1.00,2.01,1.26);
		Fenster fenster3 = new Fenster(1.00,1.01,1.26);
		Fenster fenster4 = new Fenster(1.00,1.26,1.26);
		Fenster fenster5 = new Fenster(1.00,1.26,1.26);
		Fenster fenster6 = new Fenster(1.00,1.26,1.26);
		Fenster fenster7 = new Fenster(1.00,0.8,1.26);
		Tuer tuer1 = new Tuer("T1",2.26,2.26);
		Tuer tuer2 = new Tuer("T2",0.76,2.26);
		Tuer tuer3 = new Tuer("T3",1.13,2.26);
		Tuer tuer4 = new Tuer("T4",1.13,2.26);
		Tuer tuer5 = new Tuer("T5",1.03,2.26);
		Tuer tuer6 = new Tuer("T6",1.76,2.26);
		Rundstuetze rundstuetze1 = new Rundstuetze(0.2,"C20/25", 0.06);
		Rundstuetze rundstuetze2 = new Rundstuetze(0.2,"C20/25", 0.06);
		Rundstuetze rundstuetze3 = new Rundstuetze(0.2,"C20/25", 0.06);
		geschoss.addRundstuetze(rundstuetze1);
		geschoss.addRundstuetze(rundstuetze2);
		geschoss.addRundstuetze(rundstuetze3);
		Mauerwerkswand mauerwerkswand1 = new Mauerwerkswand(0.4,9.52 - 0.8,geschoss);
		mauerwerkswand1.addOeffnung(fenster1);
		mauerwerkswand1.addOeffnung(fenster2);
		Mauerwerkswand mauerwerkswand2 = new Mauerwerkswand(0.4,8.02,geschoss);
		mauerwerkswand2.addOeffnung(fenster3);
		mauerwerkswand2.addOeffnung(tuer6);
		Mauerwerkswand mauerwerkswand3 = new Mauerwerkswand(0.4,9.52 - 0.8,geschoss);
		mauerwerkswand3.addOeffnung(fenster4);
		mauerwerkswand3.addOeffnung(fenster5);
		mauerwerkswand3.addOeffnung(fenster6);
		Mauerwerkswand mauerwerkswand4 = new Mauerwerkswand(0.4,8.02,geschoss);
		mauerwerkswand4.addOeffnung(fenster7);
		mauerwerkswand4.addOeffnung(tuer1);
		Mauerwerkswand mauerwerkswand5 = new Mauerwerkswand(0.24,4.33,geschoss);
		mauerwerkswand5.addOeffnung(tuer3);
		Mauerwerkswand mauerwerkswand6 = new Mauerwerkswand(0.24,8.72,geschoss);
		mauerwerkswand6.addOeffnung(tuer2);
		mauerwerkswand6.addOeffnung(tuer4);
		Mauerwerkswand mauerwerkswand7 = new Mauerwerkswand(0.24,2.65,geschoss);
		Mauerwerkswand mauerwerkswand8 = new Mauerwerkswand(0.24,2.65,geschoss);
		mauerwerkswand8.addOeffnung(tuer5);
		geschoss.addMauerwerkswand(mauerwerkswand1);
		geschoss.addMauerwerkswand(mauerwerkswand2);
		geschoss.addMauerwerkswand(mauerwerkswand3);
		geschoss.addMauerwerkswand(mauerwerkswand4);
		geschoss.addMauerwerkswand(mauerwerkswand5);
		geschoss.addMauerwerkswand(mauerwerkswand6);
		geschoss.addMauerwerkswand(mauerwerkswand7);
		geschoss.addMauerwerkswand(mauerwerkswand8);
		return gebaeude;
	}
}
