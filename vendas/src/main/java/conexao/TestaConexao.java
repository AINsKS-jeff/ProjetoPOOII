/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import javax.swing.JOptionPane;

/**
 *
 * @author jeffn
 */
public class TestaConexao {
    public static void main (String[] args){
        try{
            new ConectaFactory().getConection();
            JOptionPane.showMessageDialog(null,"Conectado con sucesso");
        } catch (Exception erro){
            JOptionPane.showMessageDialog(null, "Erro na conexão"+erro);
            
        }
    }
}
