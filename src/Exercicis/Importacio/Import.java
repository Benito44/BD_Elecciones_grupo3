package Exercicis.Importacio;

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

            // Dades que recollim de l'arxiu
            String codi_ine, nom;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(11, 13).equals("99")) { // dels totals
                    codi_ine = strLinia.substring(9, 11);
                    nom = strLinia.substring(14, 64);

                    //Inserim dades
                    InsertQuery.insertIntoComunitat(nom, codi_ine);
                }
            }
            System.out.println("Comunitats autonomes importades correctament");
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

            // Dades que recollim de l'arxiu
            String codi_ine_ca, nom_provincia, codi_ine_prov;
            int num_escons;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                // Excloent els totals
                if (!(strLinia.substring(9, 11).equals("99") || strLinia.substring(11, 13).equals("99"))) {
                    codi_ine_ca = strLinia.substring(9, 11);
                    nom_provincia = strLinia.substring(14, 64);
                    codi_ine_prov = strLinia.substring(11, 13);
                    num_escons = Integer.parseInt(strLinia.substring(149, 155));

                    //Inserim dades
                    InsertQuery.insertIntoProvincies(codi_ine_ca, nom_provincia, codi_ine_prov, num_escons);
                }
            }
            System.out.println("Provincies importades correctament");

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

            // Dades que recollim de l'arxiu
            String nom, codi_ine, ine_provincia;
            int districte;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                nom = strLinia.substring(18, 118);
                codi_ine = strLinia.substring(13, 16);
                ine_provincia = strLinia.substring(11, 13);
                districte = Integer.parseInt(strLinia.substring(16, 18)); // Si és 99 és municipi

                //Inserim dades
                InsertQuery.insertIntoMunicipis(nom, codi_ine, ine_provincia, districte);
            }
            System.out.println("Municipis importats correctament");

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


    public static void importarPersonesAndCandidats() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "04021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Dades que recollim de l'arxiu
            String nom, cognom1, cognom2, dni, tipus, codi_ine_provincia, codi_candidatura;
            int num_ordre;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                nom = strLinia.substring(25, 50);
                cognom1 = strLinia.substring(50, 75);
                cognom2 = strLinia.substring(75, 100);
                dni = strLinia.substring(8, 11) + strLinia.substring(19, 24);
                num_ordre = Integer.parseInt(strLinia.substring(21, 24));
                tipus = strLinia.substring(24, 25);
                codi_ine_provincia = strLinia.substring(9, 11);
                codi_candidatura = strLinia.substring(15, 21);

                //Inserim dades
                InsertQuery.insertIntoPersones(nom, cognom1, cognom2, dni);
                InsertQuery.insertIntoCandidats(num_ordre, tipus, dni, codi_ine_provincia, codi_candidatura);
            }
            System.out.println("Importació de persones i candidats finalitzada");

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

            // Dades que recollim de l'arxiu
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
            System.out.println("Candidatures importades correctament");

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

    public static void importVotsMunicipals() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "06021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Dades que recollim de l'arxiu
            String codi_ine_prov, codi_ine_municipi, codi_candidatura;
            int vots, voltes=1;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                    codi_ine_prov = strLinia.substring(9, 11);
                    codi_ine_municipi = strLinia.substring(11, 14);
                    codi_candidatura = strLinia.substring(16, 22);
                    if(codi_candidatura == null) {
                        System.out.println(voltes);
                    }
                    vots = Integer.parseInt(strLinia.substring(22, 30));
                    //Inserim dades
                    InsertQuery.insertIntoVotsMunicipals(codi_ine_municipi, codi_ine_prov, codi_candidatura, vots);
                    voltes++;
            }
            System.out.println("Vots municipis importats correctament");

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

            // Dades que recollim de l'arxiu
            String codi_ine, codi_candidatura;
            int vots, candidats_obtinguts;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (!(strLinia.substring(11, 13).equals("99"))) {
                    codi_ine = strLinia.substring(11, 13);
                    codi_candidatura = strLinia.substring(14, 20);
                    vots = Integer.parseInt(strLinia.substring(20, 28));
                    candidats_obtinguts = Integer.parseInt(strLinia.substring(28, 33));

                    //Inserim dades
                    InsertQuery.insertIntoVotsProvincials(codi_ine, codi_candidatura, vots, candidats_obtinguts);
                }
            }
            System.out.println("Vots provincials importats correctament");

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

    public static void importVotsAutonomiques() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "08021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Dades que recollim de l'arxiu
            String codi_ine, codi_candidatura;
            int vots;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                codi_ine = strLinia.substring(9, 11);
                codi_candidatura = strLinia.substring(14, 20);
                vots = Integer.parseInt(strLinia.substring(20, 28));

                //Inserim dades
                InsertQuery.insertIntoVotsAutonomiques(codi_ine, codi_candidatura, vots);
            }
            System.out.println("Vots comunitat autonoma importats correctament");

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
