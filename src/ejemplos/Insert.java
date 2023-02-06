package ejemplos;
import java.sql.*;
import java.util.Calendar;

public class Insert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://10.2.68.44/eleccions2017", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO candidats (candidat_id,candidatura_id,persona_id,provincia_id,num_ordre,tipus)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, 1);
            preparedStmt.setInt(2, 1);
            preparedStmt.setInt(3, 3);
            preparedStmt.setInt(4, 4);
            preparedStmt.setInt(5, 5);
            preparedStmt.setString(6, "T");
            //preparedStmt.setDate(6, startDate);
            /*preparedStmt.setString(7, "IT_PROG");
            preparedStmt.setFloat(8, 5000.12f);*/

            // execute the preparedstatement
            preparedStmt.execute();

            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
