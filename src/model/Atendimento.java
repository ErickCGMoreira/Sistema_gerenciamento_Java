/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Aluno_Manha
 */
public class Atendimento extends modell{
    private int idAtendimento;
    private int idCliente;
    private int idFuncionario;
    private String tipo;
    private String endereco;
    private Timestamp dataCriacao;
    private Timestamp dataMarcado;
    private Timestamp dataRealizado;
    private int horario;
    private double valor;
    private String descricao;
    private int avaliacao;
    private String avaliacaoMensagem;
    
    public Atendimento(){
        
    }
    
    public Atendimento(int idAtendimento, int idCliente, int idFuncionario, String tipo, String endereco, Timestamp dataCriacao, Timestamp dataMarcado, Timestamp dataRealizado, int horario, double valor, String descricao, int avaliacao, String avaliacaoMensagem){
        this.avaliacao = avaliacao;
        this.avaliacaoMensagem = avaliacaoMensagem;
        this.dataCriacao = dataCriacao;
        this.dataMarcado = dataMarcado;
        this.dataRealizado = dataRealizado;
        this.descricao = descricao;
        this.endereco = endereco;
        this.horario = horario;
        this.idAtendimento = idAtendimento;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * @return the idAtendimento
     */
    public int getIdAtendimento() {
        return idAtendimento;
    }

    /**
     * @param idAtendimento the idAtendimento to set
     */
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the dataCriacao
     */
    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the dataMarcado
     */
    public Timestamp getDataMarcado() {
        return dataMarcado;
    }

    /**
     * @param dataMarcado the dataMarcado to set
     */
    public void setDataMarcado(Timestamp dataMarcado) {
        this.dataMarcado = dataMarcado;
    }

    /**
     * @return the dataRealizado
     */
    public Timestamp getDataRealizado() {
        return dataRealizado;
    }

    /**
     * @param dataRealizado the dataRealizado to set
     */
    public void setDataRealizado(Timestamp dataRealizado) {
        this.dataRealizado = dataRealizado;
    }

    /**
     * @return the horario
     */
    public int getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the avaliacao
     */
    public int getAvaliacao() {
        return avaliacao;
    }

    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     * @return the avaliacaoMensagem
     */
    public String getAvaliacaoMensagem() {
        return avaliacaoMensagem;
    }

    /**
     * @param avaliacaoMensagem the avaliacaoMensagem to set
     */
    public void setAvaliacaoMensagem(String avaliacaoMensagem) {
        this.avaliacaoMensagem = avaliacaoMensagem;
    }
}
