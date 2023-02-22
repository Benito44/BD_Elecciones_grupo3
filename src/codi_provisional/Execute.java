package codi_provisional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Execute {
    public static void main(String[] args) {
        try {
            Connection con = DBMySQLManager.getConnection();

            //Class.forName("com.mysql.cj.jdbc.Driver");

           //Connection con = DriverManager.getConnection("jdbc:mysql://10.2.106.42/eleccions2017", "perepi", "pastanaga");



            // 1. Inserim dades a la taula COMUNITATS
            //Import.importarComunitatsAutonomes();

            // 2. Inserim dades a la taula PROVINCIES
            //Import.importarProvincies();

            // 3. Inserim dades a la taula MUNICIPIS
            //Import.importarMunicipis();

            // 4. Inserim dades a la taula CANDIDATURES
            //Import.importarCandidatures();

            // 5. Inserim dades a la taula PERSONES
            //Import.importarPersones();

            // 6. Inserim dades a la taula CANDIDATS
            //Import.importarCandidats();


            // ?. Inserim dades a la taula VOTS_PROVINCIALS
            Import.importVotsProvincials();

            //TODO: ajuntar persones i candidats en el mateix insert

            // Tanquem connexió
            DBMySQLManager.closeConnection();

        } catch (SQLException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
