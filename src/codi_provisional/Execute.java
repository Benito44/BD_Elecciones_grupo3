package codi_provisional;

import java.sql.SQLException;

public class Execute {
    public static void main(String[] args) {
        try {
            // 1. Inserim dades a la taula COMUNITATS
            Import.importarComunitatsAutonomes();

            // 2. Inserim dades a la taula PROVINCIES
            Import.importarProvincies();

            // 3. Inserim dades a la taula MUNICIPIS
            Import.importarMunicipis();

            // 4. Inserim dades a la taula PERSONES
            Import.importarPersones();
            // TODO: 17/02/2023 Falta probar i insertar los vots (Inserts_provisionals)

            // 5. Inserim dades a la taula CANDIDATURES
            Import.importarCandidatures();



            // Tanquem connexió
            DBMySQLManager.closeConnection();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
