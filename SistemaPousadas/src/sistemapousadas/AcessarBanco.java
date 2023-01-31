package sistemapousadas;

import java.sql.*;

public class AcessarBanco {
    
    private static String serverName = "localhost";
    private static String mydatabase = "sistema_posadas";
    private static String url = "jdbc:sql://" + serverName + "/" + mydatabase;
    private static String userName = "alunas";
    private static String password = "12345678";
    private static Connection cnn = null;
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    
    public static Connection abrirConexao() {

        try {
            if (AcessarBanco.cnn == null) {
                Class.forName(driverName);
                AcessarBanco.cnn = DriverManager.getConnection(url, userName, password);
                return AcessarBanco.cnn;
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return AcessarBanco.cnn;   
    }
    
     public static int atualizarDados(String sql){
        Statement stmt = null;
        int regAlterados = 0;

        try {
            Connection cnn = abrirConexao();
            stmt = cnn.createStatement();
            regAlterados = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        return regAlterados;
    }
     
     public static ResultSet consultarDados(String sql) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection cnn = abrirConexao();
            stmt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        return rs;
    }
}
