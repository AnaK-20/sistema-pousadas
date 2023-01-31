package sistemapousadas;

import java.sql.ResultSet;
import sistemapousadas.AcessarBanco;

public class Clientes {
    public static ResultSet exibirClientes(){
        String sql = "select * from Clientes;";
        ResultSet rs;
        rs = AcessarBanco.consultarDados(sql);
        return rs;
        
    }
    
    public static ResultSet getClientes(String cpf){
        String sql = "select * from Clientes where cpf =" +cpf+ ";";
        ResultSet rs;
        rs = AcessarBanco.consultarDados(sql);
        return rs;
    }
    
    public static int cadastrarCliente(String cpf, String nome, String telefone,String data_nascimento,
            String logradouro, String numero, String cidade, String estado){
        int regInseridos = 0;
        String insertSQL = "INSERT INTO Clientes" + "(cpf, nome, telefone, data_nascimento, logardouro, numero, cidade, estado)"
                + " VALUES (" +cpf+ ", '" +nome+"',"+ telefone+", '" + data_nascimento + ", '" +logradouro+"', '"
                +numero+ ", '" +cidade+ "', '" +estado+ "' );";
        regInseridos = AcessarBanco.atualizarDados(insertSQL);

        return regInseridos;
    }
    public static int atualizarCadastro(String cpf, String nome, String telefone, String data_nascimento,
            String logradouro, String numero, String cidade, String estado){
        int regInseridos = 0;
        String updateSQL = "UPDATE Clientes SET "+ "nome = '" +nome+ "', telefone = '" +telefone+ ", '" + data_nascimento+
                "', logardouro = '" +logradouro+ "', numero = " +numero+ ", cidade = '" +cidade+ "', estado = '" +estado+ 
                "WHERE cpf = " +cpf+ ";";
        regInseridos = AcessarBanco.atualizarDados(updateSQL);

        return regInseridos;
        
    }
    public static int excluirCliente(String cpf){
        int regInseridos = 0;
        String excluirSQL = "DELETE FROM Clientes WHERE cpf= " +cpf+ ";";
        regInseridos = AcessarBanco.atualizarDados(excluirSQL);

        return regInseridos;
    }
}
