/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import conexao.ConectaFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Fornecedores;
/**
 *
 * @author jeffn
 */
public class FornecedoresDAO {
    private Connection con;
    
    public FornecedoresDAO(){
        this.con = new ConectaFactory().getConection();
        
    }
    
    public void cadastrarFornecedores (Fornecedores obj){
        try{
            String sql = "insert into tb_fornecedores (nome, cnpj, email, telefone, celular, cep, "
                    + "endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getCnpj());
            stmt.setString(3,obj.getEmail());
            stmt.setString(4,obj.getTelefone());
            stmt.setString(5,obj.getCelular());
            stmt.setString(6,obj.getCep());
            stmt.setString(7,obj.getEndereco());
            stmt.setInt(8,obj.getNumero());
            stmt.setString(9,obj.getComplemento());
            stmt.setString(10,obj.getBairro());
            stmt.setString(11,obj.getCidade());
            stmt.setString(12,obj.getEstado());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }catch (SQLException erro){
            JOptionPane.showConfirmDialog(null, "Erro ao efetuar o cadastro" + erro);
            
        }
    }
    public void excluirFornecedor (Fornecedores obj){
        try {
            String slq = "delete from tb_fornecedores where id=?";
            PreparedStatement stmt = con.prepareStatement(slq);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao excluir" + erro);
            
        }
    }
    public void alterarFornecedor (Fornecedores obj){
        try{
            String slq = "update tb_fornecedores set nome=?, cnpj=?, email=?, "
                    + "telefone=?, celular=?, "
                    + "cep=?, endereco=?, numero=?, complemento=?, bairro=?, "
                    + "cidade=?, estado=? where id=?";
            
            PreparedStatement stmt = con.prepareStatement(slq);
            
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getCnpj());
            stmt.setString(3,obj.getEmail());
            stmt.setString(4,obj.getTelefone());
            stmt.setString(5,obj.getCelular());
            stmt.setString(6,obj.getCep());
            stmt.setString(7,obj.getEndereco());
            stmt.setInt(8,obj.getNumero());
            stmt.setString(9,obj.getComplemento());
            stmt.setString(10,obj.getBairro());
            stmt.setString(11,obj.getCidade());
            stmt.setString(12,obj.getEstado());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao alterar" + erro);
            
        }
    }
    
    public List<Fornecedores> listarFornecedores(){
        try{
            List<Fornecedores> lista = new ArrayList<>();
            String slq = "select * from tb_fornecedores";
            PreparedStatement stmt = con.prepareStatement(slq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Fornecedores obj = new Fornecedores();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
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
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados" + erro);
            return null;
        }
    }
    
    public List<Fornecedores> listarFornecedoresPorNome(String nome){
        try{
            List<Fornecedores> lista = new ArrayList<>();
            String sql = "select * from tb_fornecedores where nome like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Fornecedores obj = new Fornecedores();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
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
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "erro ao listar dados"+ erro);
            return null;
            
        }
    }
    public Fornecedores consultaFornecedoresPorNome (String nome){
        try{
            String slq = "select * from tb_fornecedores where nome=?";
            PreparedStatement stmt = con.prepareStatement(slq);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Fornecedores obj = new Fornecedores();
            
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
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
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "fornecedor não encontrado!");
            return null;
        } 
    }
    
}
