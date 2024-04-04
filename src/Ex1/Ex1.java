package Ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String entrada;
        boolean exists = false;

        entrada = sc.next();

        Path origin = Path.of("C:\\Users\\Zroig\\Estudis\\CFGSDAW1\\MP03\\UF3\\PT1");
        Path comp = Path.of(origin+"\\EX1\\secret.txt");
        exists = Files.exists(comp);

        if (!exists) {
            
            try {
                Path carpeta = Files.createDirectories(origin.resolve("EX1"));
                Path fitxer = Files.createFile(carpeta.resolve("secret.txt"));
                Files.writeString(fitxer, entrada+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            try {
                Files.writeString(origin, entrada+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }    
        }

        System.out.println("Booooomba");
        sc.close();

        


        
    }

}
