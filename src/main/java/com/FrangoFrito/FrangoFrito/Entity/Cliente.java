package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

import java.util.Date;

@Entity
public class Cliente{

    @Id
    private Integer id;
    private boolean ativo;
    private String cpf;
    private String nome;
    private String endereco;
    private Date data_nasc;

    public Cliente() {
    }

    public Cliente(boolean ativo, String cpf, String nome, String endereco, Date data_nasc) {
        this.ativo = ativo;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.data_nasc = data_nasc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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