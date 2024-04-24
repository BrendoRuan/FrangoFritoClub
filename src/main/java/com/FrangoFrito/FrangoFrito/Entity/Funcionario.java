package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Funcionario extends Pessoa{
    private boolean Status;

    public Funcionario(){

    }
    public Funcionario(String cpf, String nome, String endereco, LocalDate dataNasc, boolean status) {
        super(cpf, nome, endereco, dataNasc);
        Status = status;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        this.Status = status;
    }
}