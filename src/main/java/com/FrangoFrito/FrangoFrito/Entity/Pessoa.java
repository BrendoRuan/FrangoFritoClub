package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @CPF
    @NotNull
    protected String cpf;
    @Size(min=5,max=255)
    @NotNull
    protected String nome;
    @Size(min=5,max=255)
    protected String endereco;
    @NotNull
    protected LocalDate dataNasc;
    @Email
    @NotNull
    protected String email;
    @Size(min=5,max=20)
    @NotNull
    protected String senha;
    public Pessoa(){}

    public Pessoa(String cpf, String nome, String endereco, LocalDate dataNasc,String email,String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.email = email;
        this.senha = senha;
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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}