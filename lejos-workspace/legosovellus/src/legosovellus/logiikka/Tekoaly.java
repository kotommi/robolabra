package legosovellus.logiikka;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

/**
 * Pääluokka robotin toiminnalle. Sisältää tällä hetkellä lähinnä testimetodeja.
 * @author tomko
 */
public class Tekoaly {

    private Ohjain ohjain;
    private Tutka tutka;

    /**
     * 
     */
    public Tekoaly() {
        this.ohjain = new Ohjain(Motor.B, Motor.A);
        this.tutka = new Tutka(SensorPort.S1, Motor.C);
    }

    /**
     * testimetodi sensorin testailuun
     */
    public void testailua() {

        ohjain.getOhjain().forward();
        while (true) {
            if (tutka.onkoSeinassa(30f)) {
                break;
            }
        }
        ohjain.getOhjain().stop();
        int asteet = tutka.valitseSuunta();
        ohjain.getOhjain().rotate(asteet);
    }

}
