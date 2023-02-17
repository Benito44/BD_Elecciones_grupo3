package proves;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class LecturaVotsProvincialsAutonomics {
    public static void main(String[] args) {
        printVotsProvincials();
        printVotsAutonomics();

    }

    public static void printVotsProvincials() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "08021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (!(strLinia.substring(11, 13).equals("99"))) {
                    int provincia_id = Integer.parseInt(strLinia.substring(11,13));
                    System.out.println("Codi I.N.E provincial: " + provincia_id);
                    int candidatura_id = Integer.parseInt(strLinia.substring(14,20));
                    System.out.println("Codi de la candidatura:  " + candidatura_id);
                    int vots = Integer.parseInt(strLinia.substring(20,28));
                    System.out.println("Vots obtinguts:  " + vots);
                    int candidats_obtinguts = Integer.parseInt(strLinia.substring(28,33));
                    System.out.println("Candidats obtinguts:  " + candidats_obtinguts);
                    System.out.println();
                    Inserts_provisionales.insertVotsProvincials(provincia_id,candidatura_id,vots,candidats_obtinguts);

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

    public static void printVotsAutonomics() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "08021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(11, 13).equals("99")) {
                    int ine = Integer.parseInt(strLinia.substring(11,13));
                    System.out.println("Codi I.N.E provincial: " + ine);
                    int codiCandidatura = Integer.parseInt(strLinia.substring(14,20));
                    System.out.println("Codi de la candidatura:  " + codiCandidatura);
                    int votsObtinguts = Integer.parseInt(strLinia.substring(20,28));
                    System.out.println("Vots obtinguts:  " + votsObtinguts);
                    int candidatsObt = Integer.parseInt(strLinia.substring(28,33));
                    System.out.println("Candidats obtinguts:  " + candidatsObt);
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
}