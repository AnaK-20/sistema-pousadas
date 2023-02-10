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
        String sql = "select * from Reservas, Clientes, Quartos where Cliete.cpf = Reservas.fk_cpf"
                + "and Quartos.idQuarto = Reservas.fk_idQuarto and idReserva =" +idReserva+ ";";
        ResultSet rs;
        rs = AcessarBanco.consultarDados(sql);
        return rs;
    }
    public static int cadastrarReserva(int  idReserva, String qtd_pessoas, String valor, String forma_pag,
            String dataEntrada, String dataSaida, String fk_cpf, String comCafe, String fk_idQuarto){
        int regInseridos = 0;
        String insertSQL = "INSERT INTO Reservas" + "(idReserva, qtd_pessoas, valor, forma_pag,"
                + " dataEntrada, dataSaida, fk_cpf, comCafe, fk_idQuarto)"
                + " VALUES (" +idReserva+ ", '" +qtd_pessoas+"',"+ valor+", '" + forma_pag + ", '" +dataEntrada+"', '"
                +dataSaida+ ", '" +fk_cpf+ "', '" +comCafe+ "'" +fk_idQuarto+"' );";
        regInseridos = AcessarBanco.atualizarDados(insertSQL);

        return regInseridos;
    }
    

        
}
