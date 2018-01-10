package legosovellus.logiikka;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.*;

/**
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
        this.ohjain = new DifferentialPilot(5f, 18.0f, leftMotor, rightMotor, false);
        ohjain.setTravelSpeed(30);
        ohjain.setRotateSpeed(90);
    }

    public DifferentialPilot getOhjain() {
        return ohjain;
    }

}
