package legosovellus.logiikka;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.*;

/**
 * Wrapperi differentialpilotin initialisointiin
 *
 * @author tomko
 */
public class Ohjain {

    private DifferentialPilot ohjain;

    /**
     *
     * @param leftMotor
     * @param rightMotor
     */
    public Ohjain(RegulatedMotor leftMotor, RegulatedMotor rightMotor) {
        // Renkaan halkaisija senttimetreinä, Takarenkaiden etäisyys toisistaan senttimetreinä
        this.ohjain = new DifferentialPilot(5.25f, 17f, leftMotor, rightMotor, false);
        ohjain.setTravelSpeed(20);
        ohjain.setRotateSpeed(45);
    }

    public DifferentialPilot getOhjain() {
        return ohjain;
    }

}
