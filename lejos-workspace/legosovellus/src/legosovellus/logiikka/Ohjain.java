package legosovellus.logiikka;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.*;

/**
 * Wrapperi differentialpilotin initialisointiin
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
        // Renkaan halkaisija senttimetreinä (5f), Takarenkaiden etäisyys toisistaan senttimetreinä (18.0f)
        this.ohjain = new DifferentialPilot(5f, 18.0f, leftMotor, rightMotor, false);
        ohjain.setTravelSpeed(30);
        ohjain.setRotateSpeed(90);
    }

    public DifferentialPilot getOhjain() {
        return ohjain;
    }

}
