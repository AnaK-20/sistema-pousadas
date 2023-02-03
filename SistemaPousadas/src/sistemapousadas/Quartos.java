package sistemapousadas;

import java.sql.ResultSet;
import sistemapousadas.AcessarBanco;

public class Quartos {
    public static ResultSet exibirQuartos() {
        String sql = "select * from Quartos;";
        ResultSet rs;
        rs = AcessarBanco.consultarDados(sql);
        return rs;
        
    }
    
    public static ResultSet getQuartos(int idQuarto){
        String sql = "select * from Quartos where idQuarto =" +idQuarto+ ";";
        ResultSet rs;
        rs = AcessarBanco.consultarDados(sql);
        return rs;
    }
    
    public static int cadastrarQuarto(int idQuarto, int numero, String descricao, double valor, int numCamas){
        int regInseridos = 0;
        String insertSQL = "INSERT INTO Quartos" + "(idQuarto, numero, descricao, valor, numCamas)"
                + " VALUES (" +idQuarto+ ", " +numero+", '"+ descricao+"', "+valor+", "
                +numCamas+ ");";
        regInseridos = AcessarBanco.atualizarDados(insertSQL);

        return regInseridos;
    }
    
     public static int atualizarQuarto(int idQuarto, int numero, String descricao, double valor, int numCamas){
        int regInseridos = 0;
        String updateSQL = "UPDATE Quartos SET "+ "numero = " +numero+ ", descricao = '" +descricao+
                "', valor = " +valor+ ", numCamas = " +numCamas+  
                "WHERE idQuarto = " +idQuarto+ ";";
        regInseridos = AcessarBanco.atualizarDados(updateSQL);

        return regInseridos;
     }
     
     public static int excluirQuarto(int idQuarto){
        int regInseridos = 0;
        String excluirSQL = "DELETE FROM Quartos WHERE idQuarto= " +idQuarto+ ";";
        regInseridos = AcessarBanco.atualizarDados(excluirSQL);

        return regInseridos;
    }
}
