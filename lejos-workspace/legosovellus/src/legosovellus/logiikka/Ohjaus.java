package legosovellus.logiikka;

import lejos.nxt.Motor;
import lejos.util.Delay;

/**
 * @author tommi Apukirjasto erilaisille ohjauskomennoille. Oletus on että
 * Motor.A on oikea takapyörä ja Motor.B on vasen takapyörä.
 */
public class Ohjaus {

    /**
     *
     * @param nopeus
     * @param eteen eteen- vai taaksepäin
     * @param aikaMillisekunteina
     */
    public static void aja(int nopeus, boolean eteen, long aikaMillisekunteina) {
        Motor.A.setSpeed(nopeus);
        Motor.B.setSpeed(nopeus);

        if (eteen) {
            Motor.A.forward();
            Motor.B.forward();
        } else {
            Motor.A.backward();
            Motor.B.backward();
        }

        Delay.msDelay(aikaMillisekunteina);
        Motor.A.stop();
        Motor.B.stop();
    }

    /**
     *
     * @param oikealle true = oikealle, false = vasemmalle
     * @param asteita Robotin kääntymät asteet
     *
     * Kääntää robottia x astetta. Kääntyminen tapahtuu vähän hassusti
     * takapyörien avulla sillä ohjaava etupyörä ei ollut toimiva ratkaisu.
     * Taikanumero 7 on saatu tarkoilla empiirisillä kokeilla ja se on
     * riippuvainen robotin mitoista.
     */
    public static void kaanny(boolean oikealle, int asteita) {
        asteita *= 7;
        if (oikealle) {
            Motor.B.rotate(asteita);
        } else {
            Motor.A.rotate(asteita);
        }
    }

    public static void pysahdy() {
        Motor.A.stop();
        Motor.B.stop();
    }

}
