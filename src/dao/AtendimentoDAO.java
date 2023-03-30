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
import model.Atendimento;
import database.Conexao;
import java.sql.Timestamp;

/**
 *
 * @author Aluno_Manha
 */
public class AtendimentoDAO {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno_Manha
 */
    
    public static void salvar(Atendimento atendimento){
        
        String sql = "INSERT INTO atendimento (idCliente, idFuncionario, tipo, endereco, dataMarcado, dataRealizado, horario, valor, descricao, avaliacao, avaliacaoMensagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            //Criar conexão com banco de dados
            conn = Conexao.createConnectionToMysql();
            //Criar uma confirmação para executar uma querry(consulta) no banco
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //Adiciona os valores na querry criada na varivel sql
            
            pstm.setInt(1, atendimento.getIdCliente());
            pstm.setInt(2, atendimento.getIdFuncionario());
            pstm.setString(3, atendimento.getTipo());
            pstm.setString(4, atendimento.getEndereco());
            pstm.setTimestamp(5, atendimento.getDataMarcado());
            pstm.setTimestamp(6, atendimento.getDataRealizado());
            pstm.setInt(7, atendimento.getHorario());
            pstm.setDouble(8, atendimento.getValor());
            pstm.setString(9, atendimento.getDescricao());
            pstm.setInt(10, atendimento.getAvaliacao());
            pstm.setString(11, atendimento.getAvaliacaoMensagem());
            
            //Executa a querry
            pstm.execute();
            
            System.out.println("Atendimento cadastrado com sucesso!!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao tentar cadastrar o atendimento na lista");
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
    
    public static HashMap<String, Atendimento> listarClientes(){
        String sql = "SELECT * FROM atendimento";
        
        HashMap<String,Atendimento> atendimentos = new HashMap<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //Classe que vai recuperar os dados do banco
            rset = (ResultSet) pstm.executeQuery();
            
            while (rset.next()){
                int id = rset.getInt("idAtendimento");
                int idC = rset.getInt("idCliente");
                int idF = rset.getInt("idFuncionario");
                String tipo = rset.getString("tipo");
                String endereco = rset.getString("endereco");
                Timestamp dataCriacao = rset.getTimestamp("dataCriacao");
                Timestamp dataMarcado = rset.getTimestamp("dataMarcado");
                Timestamp dataRealizado = rset.getTimestamp("dataRealizado");
                int horario = rset.getInt("horario");
                double valor = rset.getDouble("valor");
                String descricao = rset.getString("descricao");
                int avaliacao = rset.getInt("avaliacao");
                String avaliacaoMensagem = rset.getString("avaliacaoMensagem");
                Atendimento funcionario = new Atendimento(id, idC, idF, tipo, endereco, dataCriacao, dataMarcado, dataRealizado, horario, valor, descricao, avaliacao, avaliacaoMensagem);
                atendimentos.put(id+"", funcionario);
            }
            
            System.out.println("Atendimentos prontos");
            
        } catch (Exception e) {
            System.out.println("Erro ao listar atendimentos");
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
        return atendimentos;
    }

    public static void alterar(Atendimento atendimento) throws Exception{
        String sql = "UPDATE funcionario SET idCliente = ?, idFuncionario = ?, tipo = ?, endereco = ?, dataMarcado = ?, dataRealizado = ?, horario = ?, valor = ?, descricao = ?, avaliacao = ?, avaliacaoMensagem = ? WHERE idAtendimento = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1,atendimento.getIdCliente());
            pstm.setInt(2,atendimento.getIdFuncionario());
            pstm.setString(3,atendimento.getEndereco());
            pstm.setTimestamp(4,atendimento.getDataMarcado());
            pstm.setTimestamp(5,atendimento.getDataRealizado());
            pstm.setInt(6,atendimento.getHorario());
            pstm.setDouble(7,atendimento.getValor());
            pstm.setString(8,atendimento.getDescricao());
            pstm.setInt(9,atendimento.getAvaliacao());
            pstm.setString(10,atendimento.getAvaliacaoMensagem());
            pstm.setInt(11,atendimento.getIdAtendimento());
            pstm.execute();
            System.out.println("Atendimento atualizado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar o atendimento");
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
    
    public static void excluir(Atendimento atendimento){
        String sql = "DELETE FROM atendimento WHERE idAtendimento = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = Conexao.createConnectionToMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, atendimento.getIdAtendimento());
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
