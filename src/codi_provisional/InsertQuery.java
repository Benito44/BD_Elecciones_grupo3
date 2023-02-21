package codi_provisional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class InsertQuery {
    public static void insertIntoComunitat(String nom, String codi_ine) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO comunitats_autonomes (nom,codi_ine)"
                    + " values (?, ?)";

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

            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO provincies (comunitat_aut_id,nom,codi_ine,num_escons)"
                    + " SELECT comunitat_aut_id, ?, ?, ?" +
                    " FROM comnitats_autonomes" +
                    " WHERE codi_ine = ?";

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

            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO municipis (nom, codi_ine,provincia_id,districte)"
                    + "SELECT ?, ?, provincia_id, ? " +
                    "   FROM provincies " +
                    "   WHERE codi_ine = ?);";

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

    public static void insertIntoPersones(String nom, String cog1, String cog2) {
        try {
            //Establim connexió si no s'ha establert
            Connection con = DBMySQLManager.getConnection();

            // the mysql insert statement
            String query = " INSERT INTO persones (nom,cog1,cog2)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, cog1);
            preparedStmt.setString(3, cog2);
            // execute the preparedstatement
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
            String query = " INSERT INTO candidatures (eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional)"
                    + " values (1, ?, ?, ?, ?, ?, ?)";

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
}
