package sistemapousadas;

import java.sql.*;

public class AcessarBanco {
    
    private static String serverName = "localhost";
    private static String mydatabase = "sistema_posadas";
    private static String url = "jdbc:sql://" + serverName + "/" + mydatabase;
    private static String userName = "alunas";
    private static String password = "";
    private static Connection cnn = null;
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    
    
}
