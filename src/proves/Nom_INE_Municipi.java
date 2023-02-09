package proves;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Nom_INE_Municipi {
    public static void insertData(String nom, String codi_ine, String provincia_id, int districte) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://<IP>/eleccions2017", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
// TODO: 09/02/2023 Introducir el campo autoincremental 
            // the mysql insert statement
            String query = " INSERT INTO municipis (nom, codi_ine,provincia_id,districte)"
                    + " values (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine);
            // TODO: 09/02/2023 REVISAR QUE SEAN STRINGS O INTS 
            preparedStmt.setString(3, provincia_id);
            preparedStmt.setInt(4, districte);
            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
