package codi_provisional;

import proves.Inserts_provisionales;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Import {
    public static void importarComunitatsAutonomes() {
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
                    InsertQuery.insertIntoComunitat(nom, codi_ine);
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

    public static void importarProvincies() {
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

                    InsertQuery.insertIntoProvincies(codi_ine_ca, nom_provincia, codi_ine_prov, num_escons);
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

    public static void importarMunicipis() {
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
                InsertQuery.insertIntoMunicipis(nom, codi_ine, ine_provincia, districte);
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


    public static void importarPersones() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "04021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                //Nom del candidat
                System.out.println("Nom candidat: " + strLinia.substring(25, 50));
                String nom = strLinia.substring(25, 50);
                //Primer cognom del candidat
                System.out.println("Cognom1: " + strLinia.substring(50, 75));
                String cognom1 = strLinia.substring(50, 75);
                //Segon cognom del candidat
                System.out.println("Cognom2: " + strLinia.substring(75, 100));
                String cognom2 = strLinia.substring(75, 100);
                System.out.println("DNI: " + Integer.parseInt(strLinia.substring(15, 24)));
                int dni = Integer.parseInt(strLinia.substring(15, 24));


                    /*
                    //TODO: Les següents dades no surten al fitxer pero si estàn solicitades a la BD, en l'insert haurem de posarles en null.
                    //Sexo del candidato
                    System.out.println("Sexo: " + strLinia.substring(100, 101));
                    //data de naixament
                    System.out.println("Data de naixement: " + strLinia.substring(101, 103) + "/" + strLinia.substring(104, 105) + "/" + strLinia.substring(106, 109));
                    //DNI del candidat
                    //System.out.println("DNI: " + strLinia.substring(101, 101));
                     */
                System.out.println();
                InsertQuery.insertIntoPersones(nom, cognom1, cognom2, dni);
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

    public static void importarCandidats() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "04021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                // Excloent els totals

                // Extraiem el num de ordre
                int num_ordre = Integer.parseInt(strLinia.substring(21, 24));
                // Extraiem el nom de la província
                String tipo_candidato = strLinia.substring(24, 25);

                InsertQuery.insertIntoCandidats(num_ordre, tipo_candidato);
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

    public static void importarCandidatures() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "03021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            String codi_candidatura, nom_curt, nom_llarg, codi_acu_provincia, codi_acu_ca, codi_acu_nacional;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                codi_candidatura = strLinia.substring(8, 14);
                nom_curt = strLinia.substring(14, 64);
                nom_llarg = strLinia.substring(63, 214);
                codi_acu_provincia = strLinia.substring(214, 220);
                codi_acu_ca = strLinia.substring(220, 226);
                codi_acu_nacional = strLinia.substring(226, 232);

                //Inserim dades
                InsertQuery.insertIntoCandidatures(codi_candidatura, nom_curt, nom_llarg, codi_acu_provincia, codi_acu_ca, codi_acu_nacional);
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

    public static void importVotsProvincials() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "08021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (!(strLinia.substring(11, 13).equals("99"))) {
                    int codi_ine = Integer.parseInt(strLinia.substring(11, 13));
                    System.out.println("Codi I.N.E provincial: " + codi_ine);
                    int candidatura_id = Integer.parseInt(strLinia.substring(14, 20));
                    System.out.println("Codi de la candidatura:  " + candidatura_id);
                    int vots = Integer.parseInt(strLinia.substring(20, 28));
                    System.out.println("Vots obtinguts:  " + vots);
                    int candidats_obtinguts = Integer.parseInt(strLinia.substring(28, 33));
                    System.out.println("Candidats obtinguts:  " + candidats_obtinguts);
                    System.out.println();
                    InsertQuery.insertIntoVotsProvincials(codi_ine, candidatura_id, vots, candidats_obtinguts);
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

    public static void importVotsAutonomics() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "08021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                int comunitat_autonoma_id = Integer.parseInt(strLinia.substring(9, 11));
                System.out.println("Codi I.N.E provincial: " + comunitat_autonoma_id);
                int candidatura_id = Integer.parseInt(strLinia.substring(14, 20));
                System.out.println("Codi de la candidatura:  " + candidatura_id);
                int vots = Integer.parseInt(strLinia.substring(20, 28));
                System.out.println("Vots obtinguts:  " + vots);
                InsertQuery.insertVotsComunitatAutonoma(comunitat_autonoma_id,candidatura_id,vots);
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
