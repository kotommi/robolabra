package legosovellus.logiikka;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.util.Delay;

/**
 *
 * @author tomko
 */
public class Tutka {

    private UltrasonicSensor sensori;
    private RegulatedMotor moottori;
    private float minEtaisyys;
    private int edellinen;

    /**
     *
     * @param portti
     * Portti johon ultraäänisensori on kytketty
     * @param moottori
     * Sensoria kääntävä moottori
     */
    public Tutka(SensorPort portti, RegulatedMotor moottori, float minEtaisyys) {
        this.sensori = new UltrasonicSensor(portti);
        this.moottori = moottori;
        this.moottori.setSpeed(180);
        this.minEtaisyys = minEtaisyys;
        this.edellinen = -90;
    }
    
    public UltrasonicSensor getSensori() {
		return sensori;
	}

    public void kaanna(int astetta) {
        moottori.rotate(astetta);
    }

    /**
     *
     * @param etaisyys
     * Palauttaa true jos robotti on etäisyyden x päässä tai lähempänä seinästä
     * @return
     */
    public boolean onkoSeinassa() {
        return this.minEtaisyys > sensori.getRange();
    }

    /**
     * Metodi kääntymistä varten. Pyörittää sensoria ja katsoo kummassa suunnassa on enemmän tilaa.
     * Etäisyys mitataan 5 kertaa per suunta koska joskus sensori temppuilee eikä anna oikeaa lukemaa.
     * @return
     * Palauttaa kääntymissuunnan asteina. 
     */
    public int valitseSuunta() {
        int[] oikea = new int[5];
        kaanna(90);
        Delay.msDelay(100);
        for (int i = 0; i < 5; i++) {
            int etaisyys = (int) sensori.getRange();
            oikea[i] = etaisyys;
            Delay.msDelay(20);
        }

        //suunnanvaihto
        kaanna(-180);
        Delay.msDelay(100);
        int[] vasen = new int[5];
        for (int i = 0; i < 5; i++) {
            int etaisyys = (int) sensori.getRange();
            vasen[i] = etaisyys;
            Delay.msDelay(20);
        }

        int mediaaniOikea = Taulukot.mediaani(oikea);
        int mediaaniVasen = Taulukot.mediaani(vasen);
        //takaisin alkuasentoon
        kaanna(90);
        
        //umpikuja
        if (mediaaniOikea <= this.minEtaisyys && mediaaniVasen <= this.minEtaisyys) {
        	return 180;
        }
        //kummassakin suunnassa tilaa
        if (mediaaniOikea > 100 && mediaaniVasen > 100) {
        	this.edellinen = - this.edellinen;
        	return this.edellinen;
        }

        if (mediaaniOikea > mediaaniVasen) {
            return -90;
        } else {
            return 90;
        }
    }
}
