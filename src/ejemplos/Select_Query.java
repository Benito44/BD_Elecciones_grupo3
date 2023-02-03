package ejemplos;

import java.sql.*;
import java.util.Calendar;

public class Select_Query {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://<IP>:3306/eleccions2016", "isard", "pirineus");

            //SENTÈNCIA SELECT
            //Preparem una sentència amb paràmetres.
            String query = "SELECT * " +
                    " FROM empleats " +
                    "WHERE data_contractacio BETWEEN ? AND ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            //Preparem les dates
            Calendar cDataInici = Calendar.getInstance();
            cDataInici.add(Calendar.YEAR, -50);

            Calendar cDataFi = Calendar.getInstance();
            cDataFi.add(Calendar.DATE, 1);

            java.sql.Date dataInici = new java.sql.Date(cDataInici.getTime().getTime());
            java.sql.Date dataFi = new java.sql.Date(cDataFi.getTime().getTime());

            preparedStmt.setDate(1, dataInici);
            preparedStmt.setDate(2, dataFi);

            ResultSet rs = preparedStmt.executeQuery();

	/*
	Sentència sense paràmetres.
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT * FROM empleats");
	*/
	/* while(rs.next()) Obtenir els valors per índex de columnes.
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));*/

            while (rs.next()) {
                System.out.println(rs.getInt("empleat_id") +
                        "  " + rs.getString("nom") +
                        "  " + rs.getDate("data_contractacio"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
