package proves;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaDades {
    public static void main(String[] args) {

        printComunitat();
        System.out.println("=======================");

        BufferedReader bfLector1 = null;
        BufferedReader bfLector2 = null;

        try {
            //Concatenem el directori actual amb un subdirectori "dades" i afegim el fitxer "03021911.DAT"
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");
            Path pathFitxer2 = Paths.get("C:", "M02", "02201606_MESA", "05021606.DAT");

            //objReader = new BufferedReader(new FileReader(pathFitxer.toString()));

            bfLector1 = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            bfLector2 = Files.newBufferedReader(pathFitxer2, StandardCharsets.ISO_8859_1);

            String strLinia;

            // Document supramunicipal
            while ((strLinia = bfLector1.readLine()) != null) {
                // Cal restar una xifra a la posició del document (recordar que el end del subatring no s'inclou)
                if (!(strLinia.substring(9,11).equals("99") || strLinia.substring(11,13).equals("99"))) { // Treiem els totals
                    System.out.println("Codi comunitat:  " + strLinia.substring(9, 11));   // Codigo de comunidad autonoma
                    System.out.println("INE Provincia:  " + strLinia.substring(11, 13));  // Codigo INE de la provincia
                    System.out.println("Codi districte:  " + strLinia.substring(13, 14));  // Codigo de districte
                    System.out.println("Nom provincia:  " + strLinia.substring(14, 64));  // Nombre Provincia
                }
/*
        List<String[]> data = new ArrayList<>();
        String value1 = strLinia.substring(9, 11);
        String value2 = strLinia.substring(9, 11);
        String value3 = strLinia.substring(9, 11);
        data.add(new String[] {value1, value2, value3});
 */
                System.out.println(strLinia);
            }
            System.out.println("==============================================================");
/*
            // Document de municipis
            while ((strLinia = bfLector2.readLine()) != null) {
                // Cal restar una xifra a la posició del document (recordar que el end del substring no s'inclou)

                System.out.println(strLinia.substring(9,11));   // Codigo de comunidad autonoma
                System.out.println(strLinia.substring(11,13));  // Codigo INE de la provincia
                System.out.println(strLinia.substring(13,16));  // Codi municipi
                System.out.println(strLinia);
            }

 */

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfLector1 != null)
                    bfLector1.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void printComunitat() {
        BufferedReader bfLector1 = null;
        try {
            //Concatenem el directori actual amb un subdirectori "dades" i afegim el fitxer "03021911.DAT"
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");

            bfLector1 = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);

            String strLinia;

            // Document supramunicipal
            while ((strLinia = bfLector1.readLine()) != null) {
                // Cal restar una xifra a la posició del document (recordar que el end del subatring no s'inclou)
                if (strLinia.substring(11, 13).equals("99")) { // Treiem els totals
                    System.out.println(strLinia);
                    System.out.println("Codi comunitat:  " + strLinia.substring(9, 11));   // Codigo de comunidad autonoma
                    System.out.println("Nom comunitat:  " + strLinia.substring(14, 64));  // Nombre Provincia
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfLector1 != null)
                    bfLector1.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
