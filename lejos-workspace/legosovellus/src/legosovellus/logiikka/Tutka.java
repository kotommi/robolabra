package legosovellus.logiikka;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.util.Delay;

public class Tutka {


	private UltrasonicSensor sensori;
	private RegulatedMotor moottori;
	
	public Tutka(SensorPort portti, RegulatedMotor moottori) {
		this.sensori = new UltrasonicSensor(portti);
		this.moottori = moottori;
		this.moottori.setSpeed(180);
	}
	
	public void kaanna(int astetta) {
		moottori.rotate(astetta);
	}
	
	public boolean onkoSeinassa (float etaisyys) {
		return etaisyys > sensori.getRange();
	}
	
	public int valitseSuunta() {
		int[] oikea = new int[5];
		kaanna(90);
		Delay.msDelay(100);
		for (int i = 0; i < 5; i++) {
			int etaisyys = (int) sensori.getRange();
			oikea[i] = etaisyys;
		}
		
		//suunnanvaihto
		kaanna(-180);
		Delay.msDelay(100);
		int[] vasen = new int[5];
		for (int i = 0; i < 5; i++) {
			int etaisyys = (int) sensori.getRange();
			vasen[i] = etaisyys;
		}
		//
		
		//
		
		int mediaaniOikea = Taulukot.mediaani(oikea);
		int mediaaniVasen = Taulukot.mediaani(vasen);
		//takaisin alkuasentoon
		kaanna(90);
		//
		
		if (mediaaniOikea > mediaaniVasen) {
			return -90;
		} else {
			return 90;
		}
		//x
		
	}
}
