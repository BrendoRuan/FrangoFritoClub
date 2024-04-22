package com.FrangoFrito.FrangoFrito.Entity;

import java.util.Date;

public class Pessoa {

    private String cpf;
    private String nome;
    private String endereco;
    private Date data_nasc;
    public Pessoa(){}

    public Pessoa(String cpf, String nome, String endereco, Date data_nasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.data_nasc = data_nasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

}