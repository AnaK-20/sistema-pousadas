/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapousadas;

import java.sql.ResultSet;

/**
 *
 * @author 20201194010010
 */
public class Reservas {
    public static ResultSet exibirReservas(){
        String sql = "select * from Clientes;";
        ResultSet rs;
        rs = AcessarBanco.consultarDados(sql);
        return rs;
        
    }
    public static ResultSet getReservas(String idReserva){
        String sql = "select * from Reservas where idReserva =" +idReserva+ ";";
        ResultSet rs;
        rs = AcessarBanco.consultarDados(sql);
        return rs;
    }
    public static int cadastrarReserva(String  idReserva, String qtd_pessoas, String valor, String forma_pag,
            String dataEntrada, String dataSaida, String fk_cpf, String comCafe, String fk_idQuarto){
        int regInseridos = 0;
        String insertSQL = "INSERT INTO Reservas" + "(idReserva, qtd_pessoas, valor, forma_pag,"
                + " dataEntrada, dataSaida, fk_cpf, comCafe, fk_idQuarto)"
                + " VALUES (" +idReserva+ ", '" +qtd_pessoas+"',"+ valor+", '" + forma_pag + ", '" +dataEntrada+"', '"
                +dataSaida+ ", '" +fk_cpf+ "', '" +comCafe+ "'" +fk_idQuarto+"' );";
        regInseridos = AcessarBanco.atualizarDados(insertSQL);

        return regInseridos;
    }
    
    public static int atualizarReserva(String  idReserva, String qtd_pessoas, String valor, String forma_pag,
            String dataEntrada, String dataSaida, String fk_cpf, String comCafe, String fk_idQuarto){
        int regInseridos = 0;
        String updateSQL = "UPDATE Reservas SET "+ "qtd_pessoas = " +qtd_pessoas+ ", valor = " +valor+ ", forma_pag ='"
                + forma_pag+"', dataEntrada = '" +dataEntrada+ "', dataSaida = " +dataSaida+ ", fk_cpf = '" 
                +fk_cpf+ "', estado = '" +fk_cpf+ "WHERE idRsesrva = " +idReserva+ ";";
        regInseridos = AcessarBanco.atualizarDados(updateSQL);

        return regInseridos;
        
    }
        
}
