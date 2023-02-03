/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import conexao.ConectaFactory;
import java.awt.image.ColorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Funcionarios;
import visao.frmLogin;
import visao.frmMenu;

/**
 *
 * @author jeffn
 */
public class FuncionariosDAO {
 private Connection con;
 
 public FuncionariosDAO(){
     this.con = new ConectaFactory().getConection();
     
 }
 
 
 public void cadastrarFuncionarios (Funcionarios obj){
        try{
            String slq = "insert into tb_funcionarios (nome, rg, cpf, email,"
                    + " senha, cargo, nivel_acesso, telefone, celular, cep, "
                    + "endereco, numero, complemento, bairro, cidade, estado)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(slq)) {
                stmt.setString(1,obj.getNome());
                stmt.setString(2,obj.getRg());
                stmt.setString(3,obj.getCpf());
                stmt.setString(4,obj.getEmail());
                stmt.setString(5, obj.getSenha());
                stmt.setString(6, obj.getCargo());
                stmt.setString(7, obj.getNivel_acesso());
                stmt.setString(8,obj.getTelefone());
                stmt.setString(9,obj.getCelular());
                stmt.setString(10,obj.getCep());
                stmt.setString(11,obj.getEndereco());
                stmt.setInt(12,obj.getNumero());
                stmt.setString(13,obj.getComplemento());
                stmt.setString(14,obj.getBairro());
                stmt.setString(15,obj.getCidade());
                stmt.setString(16,obj.getEstado());
                
                stmt.execute();
            }
            
            JOptionPane.showMessageDialog(null,"Cadastro com sucesso!");
        } 
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro"+ erro);
        }
    }
 
 public List<Funcionarios> listarFuncionarios(){
        try {
            List<Funcionarios> lista = new ArrayList<>();
            String slq = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(slq);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
                
            }
            return lista;
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao listar os dados"+ erro);
            return null;
        }
    }
    public void excluirFuncionario(Funcionarios obj){
        try{
            String sql = "delete from tb_funcionarios where id=?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, obj.getId());
                
                stmt.execute();
            }
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a exclusão" + erro);
            
        }
    }
    public void alterarFuncionario(Funcionarios obj){
        try{
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, "
                    + "nivel_acesso=?, telefone=?, celular=?, "
                    + "cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1,obj.getNome());
                stmt.setString(2,obj.getRg());
                stmt.setString(3,obj.getCpf());
                stmt.setString(4,obj.getEmail());
                stmt.setString(5, obj.getSenha());
                stmt.setString(6, obj.getCargo());
                stmt.setString(7, obj.getNivel_acesso());
                stmt.setString(8,obj.getTelefone());
                stmt.setString(9,obj.getCelular());
                stmt.setString(10,obj.getCep());
                stmt.setString(11,obj.getEndereco());
                stmt.setInt(12,obj.getNumero());
                stmt.setString(13,obj.getComplemento());
                stmt.setString(14,obj.getBairro());
                stmt.setString(15,obj.getCidade());
                stmt.setString(16,obj.getEstado());
                stmt.setInt(17, obj.getId());
                
                stmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
        }
    }
    public Funcionarios ConsultaPorNome(String nome){
        try{
            String sql= "select * from tb_funcionarios where nome=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();
             if(rs.next()){
                 obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
             }
             return obj;
        } catch(SQLException erro){
         JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
         return null;
        }
    }
    public List<Funcionarios> listarFuncionarioNome(String nome){
        try{
            List<Funcionarios> lista = new ArrayList<>();
            
            String slq = "select * from tb_funcionarios where nome like?";
            PreparedStatement stmt = con.prepareStatement(slq);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
                
            }
            return lista;
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + erro);
            return null;
        }
    }
    public void efetuarLogin(String email, String senha){
        try{
            String sql = "select * from tb_funcionarios where email=? and senha=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet rs= stmt.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema!");
                frmMenu tela = new frmMenu();
                tela.usuarioLogado = rs.getString("nome");
                tela.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
                new frmLogin().setVisible(true);
                
            }
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            
        }
    }
}
