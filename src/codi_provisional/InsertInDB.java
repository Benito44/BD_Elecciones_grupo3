package codi_provisional;

import java.sql.SQLException;

public class InsertInDB {
    public static void main(String[] args) {
        try {
            // 1. Inserim dades a la taula COMUNITATS
            ReadDataToInsert.readInsertComunitat();

            // 2. Inserim dades a la taula PROVINCIES
            ReadDataToInsert.readInsertProvincies();

            // 3. Inserim dades a la taula MUNICIPIS
            ReadDataToInsert.readInsertMunicipi();

            // Tanquem connexió
            DBMySQLManager.closeConnection();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
