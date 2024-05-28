package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Funcionario extends Pessoa{
    private boolean statusFuncionario;

    public Funcionario(){}
    public Funcionario(String cpf, String nome, String endereco, LocalDate dataNasc, boolean statusCliente, String email, String senha) {
        super(cpf, nome, endereco, dataNasc,email,senha);
        this.statusFuncionario = statusFuncionario;
    }

    public boolean getStatusFuncionario() {
        return statusFuncionario;
    }

    public void setStatusFuncionario(boolean statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }
}