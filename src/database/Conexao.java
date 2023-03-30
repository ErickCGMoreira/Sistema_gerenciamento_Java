/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aluno_Manha
 */
public class Conexao {
    
    //Nome do usuário mySQL
    private static final String USERNAME = "eletrotech_adm";
    //Senha do banco de dados
    private static final String PASSWORD = "slaykween";
    //Caminho do banco de dados, porta(3306) nome da base de dados
    private static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/sa_eletrotech";
    
    public static final Connection createConnectionToMysql() throws Exception {
        
        //Faz com que a classe seja carregada na JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Cria conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        return connection;
    }
    
    public static void main(String[] args) throws Exception {
        
        //Criar ou recuperar uma conexão com o banco
        Connection con = createConnectionToMysql();
        
        //Teste de conexão com o banco de dados
        if (con != null){
            
            System.out.println("Conexao estabelecida com sucesso!!");
            con.close();
        }
    }
    
}
