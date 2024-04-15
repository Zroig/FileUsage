package EX4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.Files;

public class EX4 {
    public static void main(String[] args) {
        //Llegir Ruta
        Scanner sc = new Scanner(System.in);
        String entrada = sc.next();
        sc.close();

        //Comprovar existencia de fitxers
        Path fitxer = Path.of(entrada);
        boolean exists = Files.exists(fitxer) && entrada.endsWith(".txt");

        //Si no existeix o no es txt donara error
        if (!exists) {

            System.out.println("Error 001: Fitxer no existeix o no és de format valid");

        } else {
            
            try {

                FileReader fitxerlectura = new FileReader(entrada);
                BufferedReader lector = new BufferedReader(fitxerlectura);
                String linia;
                int max = 0;
                int min = Integer.MAX_VALUE;
                int res = 0;
                int cont = 0;

                while ((linia = lector.readLine()) != null) {

                    String[] paraules = linia.split(" ");
                    boolean primeraParaula = true;
                    for (int i = 0; i < paraules.length; i++){
                        if (!isInt(paraules[i])) {
                            if (!primeraParaula) {
                                System.out.println("Velocitat maxima: "+max+"\nVelocitat minima: "+min+"\nVelocitat Mitjana: "+res/cont);
                            }
                            System.out.println(paraules[i]+":");
                            max = Integer.MIN_VALUE;
                            min = Integer.MAX_VALUE;
                            res = 0;
                            cont = 0;
                            primeraParaula = false;
                        } else {
                            max = Math.max(max, Integer.parseInt(paraules[i]));
                            min = Math.min(min, Integer.parseInt(paraules[i]));
                            cont++;
                            res = res+Integer.parseInt(paraules[i]);
                        }
                    }
                }
                System.out.println("Velocitat maxima: "+max+"\nVelocitat minima: "+min+"\nVelocitat Mitjana: "+res/cont);
                lector.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            

        }

        
        
    }
    
    public static boolean isInt(String valor){
        boolean isInt = true;
        try {
            Integer.parseInt(valor);
        } catch (NumberFormatException er) {
            isInt = false;
        }
        return isInt;
    }
}
