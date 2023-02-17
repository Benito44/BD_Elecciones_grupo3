package codi_provisional;

public class InsertInDB {
    public static void main(String[] args) {
        // 1. Insertem dades a la taula COMUNITATS
        ReadDataToInsert.readInsertComunitat();

        // 2. Insertem dades a la taula PROVINCIES
        ReadDataToInsert.readInsertProvincies();

        // 3. Insertem dades a la taula MUNICIPIS
        ReadDataToInsert.readInsertMunicipi();
    }
}
