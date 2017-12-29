package legosovellus;

import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.util.Delay;
import lejos.io.*;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Legosovellus {

	public static void main(String[] args) {
		LCD.drawString("Testing", 0, 0);
		aja(1080, true, 10000);
		Delay.msDelay(1000);
		aja(1080, false, 10000);
		LCD.clearDisplay();
		LCD.drawString("Press any button\nto exit", 0, 0);
		Button.waitForPress();						
	}
	
	
	
	public static void aja(int nopeus, boolean eteen, long aikaMillisekunteina) {
		Motor.A.setSpeed(nopeus);
		Motor.B.setSpeed(nopeus);
		
		if (eteen) {
			Motor.A.forward();
			Motor.B.backward();
		} else {
			Motor.A.backward();
			Motor.B.forward();
		}
		
		Delay.msDelay(aikaMillisekunteina);
		Motor.A.stop();
		Motor.B.stop();
	}
}
