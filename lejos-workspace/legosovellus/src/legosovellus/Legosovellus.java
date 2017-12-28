package legosovellus;

import lejos.nxt.*;
import lejos.io.*;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Legosovellus {

	public static void main(String[] args) {
		

		LCD.drawString("Hello world", 1, 1);
		Button.waitForPress();
	}
}
