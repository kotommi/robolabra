package legosovellus.logiikka;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;

/**
 * Pieni tekstikäyttöliittymä robotin käynnistämistä varten
 * @author tomko
 */
public class TekstiUI {

    private int kaannokset;

    /**
     * Alustaa kuuntelijat napeille
     */
    public TekstiUI() {
        this.kaannokset = 1;
        Button.RIGHT.addButtonListener(new ButtonListener() {

            @Override
            public void buttonReleased(Button arg0) {
                //
            }

            @Override
            public void buttonPressed(Button arg0) {
                kaannokset++;
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
        this.kaannokset--;
        if (this.kaannokset < 1) {
            this.kaannokset = 1;
        }
    }

    public void piirra() {
        LCD.clear();
        LCD.drawString("Mutkia: " + this.kaannokset + "\nEnter to start", 0, 0);
    }

    /**
     * "main"-metodi
     */
    public void kaynnista() {
        this.piirra();
        while (!Button.ENTER.isPressed()) {

        }
        Tekoaly tekoaly = new Tekoaly();
        tekoaly.aja(kaannokset);
        LCD.clear();
        LCD.drawString("Press any button\nto exit", 0, 0);
        Button.waitForPress();
    }
}
