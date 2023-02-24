package codi_provisional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class InsertQuery {
    public static void insertIntoEleccions() {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query =  "INSERT INTO eleccions (eleccio_i, nom, data) " +
                    "VALUES (1, 'Eleccions 2016', '2016-06-02')";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void insertIntoComunitat(String nom, String codi_ine) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query =  "INSERT INTO comunitats_autonomes (nom,codi_ine) " +
                            "VALUES (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertIntoProvincies(String codi_ine_ca, String nom, String codi_ine_prov, int num_escons) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query = "INSERT INTO provincies (comunitat_aut_id,nom,codi_ine,num_escons) " +
                                "SELECT comunitat_aut_id, ?, ?, ? " +
                                "   FROM comunitats_autonomes " +
                                "WHERE codi_ine = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine_prov);
            preparedStmt.setInt(3, num_escons);
            preparedStmt.setString(4, codi_ine_ca);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertIntoMunicipis(String nom, String codi_ine, String provincia_id, int districte) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query = "INSERT INTO municipis (nom, codi_ine,provincia_id,districte) " +
                                "SELECT ?, ?, provincia_id, ? " +
                                "   FROM provincies " +
                                "WHERE codi_ine = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine);
            preparedStmt.setString(3, String.valueOf(districte));
            preparedStmt.setInt(4, Integer.parseInt(provincia_id));

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertIntoPersones(String nom, String cog1, String cog2, String dni) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query =  "INSERT INTO persones (nom,cog1,cog2, dni) " +
                            "VALUES (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, cog1);
            preparedStmt.setString(3, cog2);
            preparedStmt.setString(4, dni);
            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertIntoCandidats(int num_ordre, String tipo_candidato, String dni, String codigo_ine_provincia, int codi_candidatura) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query =  "INSERT INTO candidats (candidatura_id, persona_id, provincia_id, num_ordre, tipus) " +
                            "VALUES ((SELECT candidatura_id " +
                            "           FROM candidatures " +
                            "           WHERE codi_candidatura = ? AND eleccio_id = 1)," +
                            "       (SELECT persona_id" +
                            "            FROM persones" +
                            "        WHERE dni = ?), " +
                            "         (SELECT provincia_id" +
                            "            FROM provincies" +
                            "        WHERE codi_ine = ?)" +
                            "            , ? , ?)";


            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, codi_candidatura);
            preparedStmt.setString(2, dni);
            preparedStmt.setString(3, codigo_ine_provincia);
            preparedStmt.setInt(4, num_ordre);
            preparedStmt.setString(5, tipo_candidato);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertIntoCandidatures(String codi_candidatura, String nom_curt, String nom_llarg, String codi_acu_provincia, String codi_acu_ca, String codi_acu_nacional) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query =  "INSERT INTO candidatures (eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional) " +
                            "VALUES (1, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, codi_candidatura);
            preparedStmt.setString(2, nom_curt);
            preparedStmt.setString(3, nom_llarg);
            preparedStmt.setString(4, codi_acu_provincia);
            preparedStmt.setString(5, codi_acu_ca);
            preparedStmt.setString(6, codi_acu_nacional);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertIntoVotsProvincials(int codi_ine, int canditatura_id, int vots, int candidats_obtinguts) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query =  "INSERT INTO vots_candidatures_prov (provincia_id, candidatura_id, vots, candidats_obtinguts) " +
                            "VALUES ((SELECT provincia_id " +
                            "           FROM provincies " +
                            "        WHERE codi_ine = ?), " +
                            "       (SELECT candidatura_id " +
                            "           FROM candidatures " +
                            "        WHERE codi_candidatura = ? AND eleccio_id = 1), " +
                            "       ?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, codi_ine);
            preparedStmt.setInt(2, canditatura_id);
            preparedStmt.setInt(3, vots);
            preparedStmt.setInt(4, candidats_obtinguts);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void insertVotsComunitatAutonoma(int comunitat_autonoma_id, int candidatura_id, int vots) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query = " INSERT INTO vots_candidatures_ca (comunitat_autonoma_id,canditatura_id,vots)"
                    + "VALUES ((SELECT candidatura_id" +
                    "    FROM candidatures" +
                    "     WHERE candidatura_id = ? and eleccio_id = 1 )," +
                    " (SELECT comunitat_autonoma_id" +
                    "  FROM comunitats_autonomes" +
                    "   WHERE codi_ine = ?), " +
                    "   ? )";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, comunitat_autonoma_id);
            preparedStmt.setInt(3, vots);
            preparedStmt.setInt(2, candidatura_id);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void insertVotsMunicipis(int candidatura_id, int municipi_id, int vots) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query = " INSERT INTO vots_candidatures_mun (eleccio_id, municipi_id, candidatura_id, vots)"
                    +"VALUES ("
                    + "(SELECT eleccio_id" +
                    "   FROM eleccions_municipis" +
                    "   WHERE candidatura_id = ?)," +
                    "  (SELECT municipi_id" +
                    "   FROM eleccions_municipis" +
                    "   WHERE candidatura_id = ?)," +
                    "   (SELECT candidatura_id" +
                    "       FROM candidatures" +
                    "       WHERE candidatura_id = ? AND eleccio_id = 1), ?" +
                    " )";


            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, 1);
            preparedStmt.setInt(2, municipi_id);
            preparedStmt.setInt(3, candidatura_id);
            preparedStmt.setInt(4, vots);


            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
