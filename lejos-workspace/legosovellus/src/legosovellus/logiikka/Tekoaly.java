package legosovellus.logiikka;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;

public class Tekoaly {

	private UltrasonicSensor sensori;
	
	public Tekoaly() {
		this.sensori = new UltrasonicSensor(SensorPort.S1);
		
	}
	
	/**
	 * testimetodi sensorin testailuun
	 * @throws IOException 
	 */
	public void testailua() throws IOException {
		File loki = new File("loki.log");
		loki.createNewFile();
		FileOutputStream fos = new FileOutputStream(loki);
		OutputStreamWriter kirjoittaja = new OutputStreamWriter(fos);
		
		for (int i = 0; i < 10; i++) {
			Ohjaus.kaanny(true, 90);
			float etaisyys = sensori.getRange();
			kirjoittaja.write(etaisyys + " , ");
			Delay.msDelay(1000);
		}
		
		kirjoittaja.close();
		
	}
	
	
}
