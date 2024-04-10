package Ex3;

import java.nio.file.Files;
import java.nio.file.Path;

public class Ex3 {
    public static void main(String[] args) {
        boolean exists = false;

        Path origin = Path.of("resultats");
        Path fitxer = Path.of("\\EX3\\fitxer.txt");

        exists = Files.exists(fitxer);

        if (exists) {

        } else {
            System.out.println("ERROR 001: File 'resultats/EX3/fitxer.txt' does not exist");
        }

    }

}
