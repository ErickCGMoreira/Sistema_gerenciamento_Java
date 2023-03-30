/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import model.Cliente;
import database.Conexao;
import java.sql.Timestamp;

/**
 *
 * @author Aluno_Manha
 */
public class ClienteDAO {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno_Manha
 */
    
    public static void salvar(Cliente cliente){
        
        String sql = "INSERT INTO cliente (nome, email, senha, cpf, cep, endereco, contato, premium) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            //Criar conexão com banco de dados
            conn = Conexao.createConnectionToMysql();
            //Criar uma confirmação para executar uma querry(consulta) no banco
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //Adiciona os valores na querry criada na varivel sql
            
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEmail());
            pstm.setString(3, cliente.getSenha());
            pstm.setString(4, cliente.getCpf());
            pstm.setString(5, cliente.getCep());
            pstm.setString(6, cliente.getEndereco());
            pstm.setString(7, cliente.getContato());
            pstm.setBoolean(8, cliente.isPremium());
            
            //Executa a querry
            pstm.execute();
            
            System.out.println("Cliente cadastrado com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao tentar cadastrar o Cliente na lista");
            e.printStackTrace();
            
        } finally {
            
            try {
                if (pstm != null) {
                
                    pstm.close();
                
                }
                if(conn != null) {
                    conn.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    
        }
    }
    
    public static HashMap<String, Cliente> listarClientes(){
        String sql = "SELECT * FROM cliente";
        
        HashMap<String,Cliente> clientes = new HashMap<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //Classe que vai recuperar os dados do banco
            rset = (ResultSet) pstm.executeQuery();
            
            while (rset.next()){
                
                int id = rset.getInt("idCliente");
                String nome = rset.getString("nome");
                String email = rset.getString("email");
                String senha = rset.getString("senha");
                String cpf = rset.getString("cpf");
                String cep = rset.getString("cep");
                String endereco = rset.getString("endereco");
                String contato = rset.getString("contato");
                Timestamp data = rset.getTimestamp("dataCadastro");
                boolean premium = rset.getBoolean("premium");
                Cliente cliente = new Cliente(id, nome, email, senha, cpf, cep, endereco, contato, data, premium);
                clientes.put(id+"", cliente);
            }
            
            System.out.println("Clientes prontos");
            
        } catch (Exception e) {
            System.out.println("Erro ao listar clientes");
            e.printStackTrace();
        } finally {
            try {
                if(rset != null){rset.close();}
                if(conn != null){conn.close();}
                if(pstm != null){pstm.close();}
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return clientes;
    }

    public static void alterar(Cliente cliente) throws Exception{
        String sql = "UPDATE cliente SET nome = ?, email = ?, senha = ?, cpf = ?, cep = ?, endereco = ?, contato = ?, premium = ? WHERE idCliente = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEmail());
            pstm.setString(3, cliente.getSenha());
            pstm.setString(4, cliente.getCpf());
            pstm.setString(5, cliente.getCep());
            pstm.setString(6, cliente.getEndereco());
            pstm.setString(7, cliente.getContato());
            pstm.setBoolean(8, cliente.isPremium());
            pstm.setInt(9, cliente.getIdCliente());
            pstm.execute();
            System.out.println("Cliente atualizado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar o cliente");
            ex.printStackTrace();
        }finally {
            try {
                if(conn != null){conn.close();}
                if(pstm != null){pstm.close();}
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void excluir(Cliente cliente){
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, cliente.getIdCliente());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(conn != null){conn.close();}
                if(pstm != null){pstm.close();}
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }    
    
}
