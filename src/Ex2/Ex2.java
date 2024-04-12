package Ex2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ex2 {
    public static void main(String[] args) {
        boolean exists = false;

        SimpleDateFormat dtform = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        Path origin = Path.of("resultats");
        Path comp = Path.of(origin+"\\EX2\\unimes.txt");
        exists = Files.exists(comp);

        if (!exists) {
            
            try {
                Path carpeta = Files.createDirectories(origin.resolve("EX2"));
                Files.createFile(carpeta.resolve("unimes.txt"));
                BufferedWriter escriptor = new BufferedWriter(new FileWriter("resultats\\EX2\\unimes.txt", true));
                escriptor.write(dtform.format(data)+"T"+java.time.LocalTime.now());
                escriptor.close();
                //Files.writeString(fitxer, entrada+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {

            try {
                BufferedWriter escriptor = new BufferedWriter(new FileWriter("resultats\\EX2\\unimes.txt", true));
                escriptor.newLine();
                escriptor.write(dtform.format(data)+"T"+java.time.LocalTime.now());
                escriptor.close();
                //Files.writeString(origin, entrada+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }    
        }
    }
}
