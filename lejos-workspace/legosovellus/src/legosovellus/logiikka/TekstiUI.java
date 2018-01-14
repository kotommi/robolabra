package legosovellus.logiikka;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;

public class TekstiUI {
	
	private int mutkat;
	
	public TekstiUI() {
		this.mutkat = 1;
		Button.RIGHT.addButtonListener(new ButtonListener() {
			
			@Override
			public void buttonReleased(Button arg0) {
				//
			}
			
			@Override
			public void buttonPressed(Button arg0) {
				mutkat++;
				piirra();
			}
		});
		Button.LEFT.addButtonListener(new ButtonListener() {
			
			@Override
			public void buttonReleased(Button arg0) {
				//
			}
			
			@Override
			public void buttonPressed(Button arg0) {
				vahenna();
				piirra();
			}
		});
	}
	
	public void vahenna() {
		this.mutkat--;
		if (this.mutkat < 1) {
			this.mutkat = 1;
		}
	}
	
	public void piirra() {
		LCD.clear();
		LCD.drawString("Mutkia: " + this.mutkat + "\nEnter to start", 0, 0);
	}
	
	public void kaynnista() {
		this.piirra();
		while (!Button.ENTER.isPressed()) {
			
		}
		Tekoaly tekoaly = new Tekoaly();
		tekoaly.aja(mutkat);
		LCD.clear();
		LCD.drawString("Press any button\nto exit", 0, 0);
		Button.waitForPress();
	}
}
