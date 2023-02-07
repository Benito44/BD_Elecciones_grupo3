package proves;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaDades {
    public static void main(String[] args) {

        // printComunitat();
        // printProvincia();
        printMunicipi();

    }

    public static void printComunitat() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(11, 13).equals("99")) { // dels totals
                    // Extraiem el codi de la CA
                    System.out.println("Codi comunitat:  " + strLinia.substring(9, 11));
                    // Extraiem el nom de la CA
                    System.out.println("Nom comunitat:  " + strLinia.substring(14, 64));

                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfLector != null)
                    bfLector.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void printProvincia() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                // Excloent els totals
                if (!(strLinia.substring(9,11).equals("99") || strLinia.substring(11,13).equals("99"))) {
                    // Extraiem el codi de la CA
                    System.out.println("Codi comunitat de la província:  " + strLinia.substring(9, 11));
                    // Extraiem el nom de la província
                    System.out.println("Nom província:  " + strLinia.substring(14, 64));
                    // Extraiem el codi INE de la província
                    System.out.println("INE Província:  " + strLinia.substring(11, 13));
                    // Extraiem el número d'escons
                    System.out.println("Escons província:  " + strLinia.substring(149, 155));

                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfLector != null)
                    bfLector.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void printMunicipi() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "05021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(16,18).equals("99")) {   // Si Nº districte és 99
                    // Extrayem nom del MUNICIPI
                    System.out.println("Nom del municipi: " + strLinia.substring(18, 118));
                } else {    // Si Nº districte NO és 99
                    // Extrayem nom del DISTRICTE
                    System.out.println("Nom del districte: " + strLinia.substring(18, 118));
                }
                // Extraiem codi INE del municipi
                System.out.println("INE municipi: " + strLinia.substring(13, 16));
                // Extraiem el codi INE de la província
                System.out.println("INE província del municipi: " + strLinia.substring(11, 13));
                // Extraiem el número de districte
                System.out.println("Número districte: " + strLinia.substring(16, 18));  // Si és 99 és municipi
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfLector != null)
                    bfLector.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
