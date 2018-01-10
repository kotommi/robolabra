package legosovellus;

import java.io.IOException;

import lejos.nxt.*;
import lejos.util.Delay;
import legosovellus.logiikka.*;

/**
 * Main-luokka sovelluksen käynnistämiseen. Saattaa sisältää jäännöksiä testailusta ja pähkinöistä
 *
 */
public class Legosovellus {

	public static void main(String[] args) throws IOException {
		LCD.drawString("Testing\nPress to start", 0, 0);
		Tekoaly tekoaly = new Tekoaly();
		tekoaly.testailua();
		tekoaly.testailua();
		LCD.drawString("Press any button\nto exit", 0, 0);
		
		Button.waitForPress();						
	}
	
	
	

}
