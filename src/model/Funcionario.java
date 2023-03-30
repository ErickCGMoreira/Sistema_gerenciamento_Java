/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aluno_Manha
 */
public class Funcionario extends modell{
    private int idFuncionario;
    private String nome;
    private String cpf;
    private String contato;
    private int idade;
    private String genero;
    private String cep;
    private String endereco;
    private double salario;
    private String dadosBancarios;
    private String dataContrataçao;
    
    public Funcionario(){
        
    }
    
    public Funcionario(int id, String nome, String cpf, String contato, int idade, String genero, String cep, String endereco, double salario, String dadosBancarios, String dataContrataçao){
        this.idFuncionario = id;
        this.nome = nome;
        this.cep = cep;
        this.cpf = cpf;
        this.contato = contato;
        this.idade = idade;
        this.salario = salario;
        this.genero = genero;
        this.endereco = endereco;
        this.dadosBancarios = dadosBancarios;
        this.dataContrataçao = dataContrataçao;
    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the dadosBancarios
     */
    public String getDadosBancarios() {
        return dadosBancarios;
    }

    /**
     * @param dadosBancarios the dadosBancarios to set
     */
    public void setDadosBancarios(String dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    /**
     * @return the dataContrataçao
     */
    public String getDataContrataçao() {
        return dataContrataçao;
    }

    /**
     * @param dataContrataçao the dataContrataçao to set
     */
    public void setDataContrataçao(String dataContrataçao) {
        this.dataContrataçao = dataContrataçao;
    }
}
