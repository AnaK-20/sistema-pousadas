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
    
    public static ResultSet getQuartos(String idQuarto){
        String sql = "select * from Quartos where idQuarto =" +idQuarto+ ";";
        ResultSet rs;
        rs = AcessarBanco.consultarDados(sql);
        return rs;
    }
    
    public static int cadastrarQuarto(String idQuarto, String numero, String descricao, String valor, String numCamas){
        int regInseridos = 0;
        String insertSQL = "INSERT INTO Quartos" + "(idQuarto, numero, descricao, valor, numCamas)"
                + " VALUES (" +idQuarto+ ", " +numero+", '"+ descricao+"', "+valor+", "
                +numCamas+ ");";
        regInseridos = AcessarBanco.atualizarDados(insertSQL);

        return regInseridos;
    }
    
     public static int atualizarQuarto(String idQuarto, String numero, String descricao, String valor, String numCamas){
        int regInseridos = 0;
        String updateSQL = "UPDATE Quartos SET "+ "numero = " +numero+ ", descricao = '" +descricao+
                "', valor = " +valor+ ", numCamas = " +numCamas+  
                "WHERE idQuarto = " +idQuarto+ ";";
        regInseridos = AcessarBanco.atualizarDados(updateSQL);

        return regInseridos;
     }
     
     public static int excluirQuarto(String idQuarto){
        int regInseridos = 0;
        String excluirSQL = "DELETE FROM Quartos WHERE idQuarto= " +idQuarto+ ";";
        regInseridos = AcessarBanco.atualizarDados(excluirSQL);

        return regInseridos;
    }
}
