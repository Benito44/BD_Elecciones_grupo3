package codi_provisional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Execute {
    public static void main(String[] args) {
        try {
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
            //TODO: adjuntar persones i candidats en el mateix insert

            // 7. Inserim dades a la taula VOTS_CANDIDATURES_MUN

            // 8. Inserim dades a la taula VOTS_CANDIDATURES_PROV
            //Import.importVotsProvincials();

            // 9. Inserim dades a la taula VOTS_CANDIDATURES_CA
            // Import.importVotsAutonomics();

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
