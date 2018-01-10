package legosovellus.logiikka;

public class Taulukot {

	public static int pienin(int[] taulukko) {
        int pienin = taulukko[0];
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] < pienin) {
                pienin = taulukko[i];
            }
        }
        return pienin;
    }

    public static int pienimmanIndeksi(int[] taulukko) {
        int pienin = taulukko[0];
        int indeksi = 0;
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] < pienin) {
                pienin = taulukko[i];
                indeksi = i;
            }
        }
        return indeksi;
    }

    public static int pienimmanIndeksiAlkaen(int[] taulukko, int aloitusIndeksi) {
        int pienin = taulukko[aloitusIndeksi];
        int indeksi = aloitusIndeksi;
        for (int i = aloitusIndeksi; i < taulukko.length; i++) {
            if (taulukko[i] < pienin) {
                pienin = taulukko[i];
                indeksi = i;
            }
        }
        return indeksi;
    }

    public static void vaihda(int[] taulukko, int indeksi1, int indeksi2) {
        int temp = taulukko[indeksi1];
        taulukko[indeksi1] = taulukko[indeksi2];
        taulukko[indeksi2] = temp;
    }

    public static void jarjesta(int[] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            int indeksi = pienimmanIndeksiAlkaen(taulukko, i);
            vaihda(taulukko, indeksi, i);
        }
    }
    
    public static int mediaani(int[] taulukko) {
    	jarjesta(taulukko);
    	return taulukko[taulukko.length / 2];
    }
    
    public static String toString(int[] taulukko) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < taulukko.length; i++) {
    		sb.append("{" + taulukko[i] + "} ");
    	}
    	return sb.toString();
    }
}
