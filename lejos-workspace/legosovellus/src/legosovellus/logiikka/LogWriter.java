package legosovellus.logiikka;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LogWriter {
	
	private OutputStreamWriter kirjoittaja;

	 public LogWriter(String tiedostonNimi) throws IOException {
		 	File loki = new File(tiedostonNimi);
			loki.createNewFile();
			FileOutputStream fos = new FileOutputStream(loki);
			this.kirjoittaja = new OutputStreamWriter(fos);
		 // TODO Auto-generated constructor stub
	}
	 
	public OutputStreamWriter getKirjoittaja() {
		return kirjoittaja;
	}
}
