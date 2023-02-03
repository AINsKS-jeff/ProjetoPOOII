/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaFactory {
    public Connection getConection(){
        try{
            return DriverManager.getConnection("JDBC:mysql://127.0.0.1/bdvendas", "teste", "123");
        } 
        catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
