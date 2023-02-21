package codi_provisional;
import java.sql.*;

public class DBMySQLManager {
    //Conexions
    static String ipAlberto = "10.2.120.240";
    static String ipBenito = "10.2.68.44";
    static String ipDavid = "10.2.211.106";
    static String ipMarc = "";
    static String ipVictor = "10.2.93.209";

    // Propietats
    private static Connection conn = null;
    private String driver = "com.mysql.cj.jdbc.Driver"; //com.mysql.jdbc.Driver
    private String url;
    private String usuari ="isard";
    private String contrasenya = "pirineus";
    private String host = ipVictor;
    private String base_dades = "eleccions_2017";

    // Constructors
    private DBMySQLManager(){

        this.url = "jdbc:mysql://" + host + ":3306/" + base_dades;

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuari, contrasenya);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    // Mètodes
    public static Connection getConnection() {

        if (conn == null){
            new DBMySQLManager();
        }

        return conn;
    }

    public static void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}