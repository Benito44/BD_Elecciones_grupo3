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

            // 5. Inserim dades a la taula PERSONES i CANDIDATS
            Import.importarPersonesAndCandidats();

            // 6. Inserim dades a la taula VOTS_CANDIDATURES_MUN
            //Import.importVotsMunicipis();

            // 7. Inserim dades a la taula VOTS_CANDIDATURES_PROV
            //Import.importVotsProvincials();

            // 8. Inserim dades a la taula VOTS_CANDIDATURES_CA
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
