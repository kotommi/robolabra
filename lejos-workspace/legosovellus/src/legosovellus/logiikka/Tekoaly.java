package legosovellus.logiikka;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Pääluokka robotin toiminnalle. Sisältää tällä hetkellä lähinnä testimetodeja.
 * @author tomko
 */
public class Tekoaly {

    private DifferentialPilot ohjain;
    private Tutka tutka;

    /**
     * @param ohjain
     * Vasenmoottori, oikeamoottori
     * @param tutka
     * Sensorin portti, sensoria kääntävä moottori, minimietäisyys seinästä
     */
    public Tekoaly() {
        this.ohjain = new Ohjain(Motor.B, Motor.A).getOhjain();
        this.tutka = new Tutka(SensorPort.S1, Motor.C, 25);
    }

    /**
     * testimetodi sensorin testailuun
     */
    public void aja(int kaannoksia) {
    	for (int i = 0; i < kaannoksia; i++) {
    		this.ajaSeinaan();
    		int asteet = tutka.valitseSuunta();
    		this.kaanny(asteet);
    	}
    }
    
    public void ajaSeinaan() {
    	ohjain.forward();
    	while (true) {
    		if (tutka.onkoSeinassa()) {
    			break;
    		}
    	}
    	ohjain.stop();
    }
    
    public void kaanny(int asteita) {
    	ohjain.rotate(asteita);
    }
    
    public void temppu() {
    	ohjain.rotate(90);
    }

}
