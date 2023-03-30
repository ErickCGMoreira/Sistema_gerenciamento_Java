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
import model.Funcionario;
import database.Conexao;

/**
 *
 * @author Aluno_Manha
 */
public class FuncionarioDAO {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno_Manha
 */
    
    public static void salvar(Funcionario funcionario){
        
        String sql = "INSERT INTO funcionario (nome, cpf, contato, idade, genero, cep, endereco, salario, dadosBancarios, dataContratacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            //Criar conexão com banco de dados
            conn = Conexao.createConnectionToMysql();
            //Criar uma confirmação para executar uma querry(consulta) no banco
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //Adiciona os valores na querry criada na varivel sql
            
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCpf());
            pstm.setString(3, funcionario.getContato());
            pstm.setInt(4, funcionario.getIdade());
            pstm.setString(5, funcionario.getGenero());
            pstm.setString(6, funcionario.getCep());
            pstm.setString(7, funcionario.getEndereco());
            pstm.setDouble(8, funcionario.getSalario());
            pstm.setString(9, funcionario.getDadosBancarios());
            pstm.setString(10, funcionario.getDataContrataçao());
            
            //Executa a querry
            pstm.execute();
            
            System.out.println("Funcionario cadastrado com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao tentar cadastrar o funcionario na lista");
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
    
    public static HashMap<String, Funcionario> listarClientes(){
        String sql = "SELECT * FROM funcionario";
        
        HashMap<String,Funcionario> funcionarios = new HashMap<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //Classe que vai recuperar os dados do banco
            rset = (ResultSet) pstm.executeQuery();
            
            while (rset.next()){
                int id = rset.getInt("idFuncionario");
                String nome = rset.getString("nome");
                String cpf = rset.getString("cpf");
                String contato = rset.getString("contato");
                int idade = rset.getInt("idade");
                String genero = rset.getString("genero");
                String cep = rset.getString("cep");
                String endereco = rset.getString("endereco");
                double salario = rset.getDouble("salario");
                String dadosBancarios = rset.getString("dadosBancarios");
                String dataContratacao = rset.getString("dataContratacao");
                Funcionario funcionario = new Funcionario(id, nome, cpf, contato, idade, genero, cep, endereco, salario, dadosBancarios, dataContratacao);
                funcionarios.put(id+"", funcionario);
            }
            
            System.out.println("Funcionarios prontos");
            
        } catch (Exception e) {
            System.out.println("Erro ao listar funcionarios");
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
        return funcionarios;
    }

    public static void alterar(Funcionario funcionario) throws Exception{
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, contato = ?, idade = ?, genero = ?, cep = ?, endereco = ?, salario = ?, dadosBancarios = ?, dataContratacao = ? WHERE idFuncionario = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,funcionario.getNome());
            pstm.setString(2,funcionario.getCpf());
            pstm.setString(3,funcionario.getContato());
            pstm.setInt(4,funcionario.getIdade());
            pstm.setString(5,funcionario.getGenero());
            pstm.setString(6,funcionario.getCep());
            pstm.setString(7,funcionario.getEndereco());
            pstm.setDouble(8,funcionario.getSalario());
            pstm.setString(9,funcionario.getDadosBancarios());
            pstm.setString(10,funcionario.getDataContrataçao());
            pstm.setInt(11,funcionario.getIdFuncionario());
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
    
    public static void excluir(Funcionario funcionario){
        String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, funcionario.getIdFuncionario());
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
