package EX4;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.Files;
import java.io.FileReader;

public class EX4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String entrada = sc.next();

        //Comprovar existencia de fitxers
        Path fitxer = Path.of(entrada);
        boolean exists = Files.exists(fitxer) && entrada.endsWith(".txt");

        if (!exists) {

            System.out.println("Error 001: Fitxer no existeix o no és de format valid");

        } else {

            HashMap<String, HashMap<Integer, Integer>> ubicacions = new HashMap<>();
            
            try {

                FileReader fitxerlectura = new FileReader(entrada);
                BufferedReader lector = new BufferedReader(fitxerlectura);
                String linia;

                while ((linia = lector.readLine()) != null) {

                    String[] paraules = linia.split(" ");

                    for (int i = 0; i < paraules.length; i++){
                        if (!isInt(paraules[i])) {
                            ubicacions.put(paraules[i], trobarVelocitats(paraules[i], lector));
                        }
                    }
                    //Calcular velocitats
                    System.out.println(ubicacions.get("Roma"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            

        }

        
        
    }

    public static HashMap<Integer, Integer> trobarVelocitats (String clau, BufferedReader lector) {

        HashMap<Integer, Integer> velocitats = new HashMap<>();
        String lastString = "";
        String linia;
        boolean foundClau = false;
        int j = 0;

        try {

            while ((linia = lector.readLine()) != null) {
                String[] paraules = linia.split(" ");
    
                for (int i = 0; i < paraules.length; i++){
    
                    if (!isInt(paraules[i]) && foundClau == false) {
    
                        lastString = paraules[i];
                        foundClau = lastString == clau ? true : false;
                    
                    } else {
    
                        if (lastString == clau) {
    
                            velocitats.put(j, Integer.parseInt(paraules[i]));
                            j++;
                        }
    
                        if (foundClau == true && lastString != clau) {
                            break;
                        }
                    }
                }
                
            }

        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
        

        return velocitats;
    }
    
    public static boolean isInt(String valor){
        boolean isInt = true;
        try {
            int num = Integer.parseInt(valor);
        } catch (NumberFormatException er) {
            isInt = false;
        }
        return isInt;
    }
}
