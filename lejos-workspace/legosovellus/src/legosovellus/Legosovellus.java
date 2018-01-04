package legosovellus;

import java.io.IOException;

import lejos.nxt.*;
import lejos.util.Delay;
import legosovellus.logiikka.*;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Legosovellus {

	public static void main(String[] args) throws IOException {
		LCD.drawString("Testing", 0, 0);
		Tekoaly tekoaly = new Tekoaly();
		tekoaly.testailua();
		LCD.drawString("Press any button\nto exit", 0, 0);
		Button.waitForPress();						
	}
	
	
	

}
