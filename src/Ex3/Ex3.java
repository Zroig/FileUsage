package Ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex3 {
    public static void main(String[] args) {
        boolean exists = false;
        String linia = "";
        int contl = 0, contp = 0;

        Path origin = Path.of("resultats");
        Path fitxer = Path.of(origin+"\\EX3\\fitxer.txt");
        
        exists = Files.exists(fitxer);

        if (exists) {
            try {
                FileReader fitxerlectura = new FileReader("resultats\\EX3\\fitxer.txt");
                BufferedReader lector = new BufferedReader(fitxerlectura);

                while ((linia = lector.readLine()) != null) {
                    contl++;
                    String[] paraules = linia.split(" ");
                    contp += paraules.length;
                }
                lector.close();
                System.out.println("Numero de linies: "+contl+"\nNumero de paraules: "+contp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("ERROR 001: File 'resultats/EX3/fitxer.txt' does not exist");
        }

    }

}
