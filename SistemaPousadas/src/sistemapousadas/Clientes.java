package sistemapousadas;

import java.sql.ResultSet;

public class Clientes {
    public static ResultSet exibirClientes(){
        String sql = "select * from Clientes;";
        ResultSet rs;
        rs = AcessarBanco.colsultarBanco(sql);
        return rs;
        
    }
    
    public static ResultSet getClientes(String cpf){
        String sql = "select * from Clientes where cpf =" +cpf+ ";";
        ResultSet rs;
        rs = AcessarBanco.colsultarBanco(sql);
        return rs;
    }
    
    public static int cadastrarCliente(String cpf, String nome, String telefone,
            String logradouro, int numero, String cidade, String estado){
        int regInseridos = 0;
        String insertSQL = "INSERT INTO Clientes" + "(cpf, nome, telefone, logardouro, numero, cidade, estado)"
                + " VALUES (" +cpf+ ", '" +nome+"',"+ telefone+", '"+logradouro+"', "
                +numero+ ", '" +cidade+ "', '" +estado+ "' );";
        regInseridos = AcessarBanco.atualizarBanco(insertSQL);

        return regInseridos;
    }
    public static int atualizarCadastro(String cpf, String nome, String telefone,
            String logradouro, int numero, String cidade, String estado){
        int regInseridos = 0;
        String updateSQL = "UPDATE Clientes SET "+ "nome = '" +nome+ "', telefone = '" +telefone+
                "', logardouro = '" +logradouro+ "', numero = " +numero+ ", cidade = '" +cidade+ "', estado = '" +estado+ 
                "WHERE cpf = " +cpf+ ";";
        regInseridos = AcessarBanco.atualizarBanco(updateSQL);

        return regInseridos;
        
    }
    public static int excluirCliente(String cpf){
        int regInseridos = 0;
        String excluirSQL = "DELETE FROM caixa WHERE cpf= " +cpf+ ";";
        regInseridos = AcessarBanco.atualizarBanco(excluirSQL);

        return regInseridos;
    }
}
