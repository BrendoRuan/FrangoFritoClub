package com.FrangoFrito.FrangoFrito.Dto;


import com.FrangoFrito.FrangoFrito.Entity.Pessoa;
import org.springframework.beans.BeanUtils;
import java.time.LocalDate;

public abstract class PessoaDTO {
    private Integer id;
    private String cpf;
    private String nome;
    private String endereco;
    private LocalDate dataNasc;
    private String email;
    private String senha;

    public PessoaDTO(){}
    public PessoaDTO(Pessoa pessoa) {
        BeanUtils.copyProperties(pessoa,this);
    }

    public PessoaDTO(Integer id, String cpf, String nome, String endereco, LocalDate dataNasc, String email, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
