package legosovellus.logiikka;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Testausta helpottava tiilen muistille kirjoittava luokka.
 * Muista kirjoittaja.close()
 * @author tomko
 */
public class LogWriter {

    private OutputStreamWriter kirjoittaja;

    /**
     *
     * @param tiedostonNimi
     * @throws IOException
     */
    public LogWriter(String tiedostonNimi) throws IOException {
        File loki = new File(tiedostonNimi);
        loki.createNewFile();
        FileOutputStream fos = new FileOutputStream(loki);
        this.kirjoittaja = new OutputStreamWriter(fos);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @return
     */
    public OutputStreamWriter getKirjoittaja() {
        return kirjoittaja;
    }
}
