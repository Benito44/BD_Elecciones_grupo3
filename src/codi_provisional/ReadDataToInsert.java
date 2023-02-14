package codi_provisional;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadDataToInsert {
    public static void readInsertComunitat() {
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
                    String codi_ine = strLinia.substring(9, 11);
                    // Extraiem el nom de la CA
                    String nom = strLinia.substring(14, 64);
                    SQL_Inserts.insertIntoComunitat(nom, codi_ine);
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

    public static void readInsertProvincies() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            String codi_ine_ca, nom_provincia, codi_ine_prov;
            int num_escons;
            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                // Excloent els totals
                if (!(strLinia.substring(9, 11).equals("99") || strLinia.substring(11, 13).equals("99"))) {
                    // Extraiem el codi de la CA
                    codi_ine_ca = strLinia.substring(9, 11);
                    // Extraiem el nom de la província
                    nom_provincia = strLinia.substring(14, 64);
                    // Extraiem el codi INE de la província
                    codi_ine_prov = strLinia.substring(11, 13);
                    // Extraiem el número d'escons
                    num_escons = Integer.parseInt(strLinia.substring(149, 155));

                    SQL_Inserts.insertIntoProvincies(codi_ine_ca, nom_provincia, codi_ine_prov, num_escons);
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

    public static void readInsertMunicipi() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "05021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            String nom, codi_ine, ine_provincia;
            int districte;
            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(16, 18).equals("99")) {   // Si Nº districte és 99
                    // Extrayem nom del MUNICIPI
                    nom = strLinia.substring(18, 118);
                } else {    // Si Nº districte NO és 99
                    // Extrayem nom del DISTRICTE
                    nom = strLinia.substring(18, 118);
                }
                // Extraiem codi INE del municipi
                codi_ine = strLinia.substring(13, 16);
                // Extraiem el codi INE de la província
                ine_provincia = strLinia.substring(11, 13);
                // Extraiem el número de districte
                districte = Integer.parseInt(strLinia.substring(16, 18)); // Si és 99 és municipi

                //Insertem dades
                SQL_Inserts.insertIntoMunicipis(nom,codi_ine, ine_provincia,districte);
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
