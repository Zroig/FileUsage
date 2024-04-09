package Ex1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
                BufferedWriter escriptor = new BufferedWriter(new FileWriter("C:\\Users\\Zroig\\Estudis\\CFGSDAW1\\MP03\\UF3\\PT1\\EX1\\secret.txt"));
                escriptor.write(entrada);
                escriptor.close();
                //Files.writeString(fitxer, entrada+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            try {
                BufferedWriter escriptor = new BufferedWriter(new FileWriter("C:\\Users\\Zroig\\Estudis\\CFGSDAW1\\MP03\\UF3\\PT1\\EX1\\secret.txt"));
                escriptor.newLine();
                escriptor.write(entrada);
                escriptor.close();
                //Files.writeString(origin, entrada+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }    
        }

        System.out.println("Booooomba");
        sc.close();

        


        
    }

}
