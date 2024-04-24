package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Funcionario extends Pessoa{
    private boolean Status;

    public Funcionario(){

    }
    public Funcionario(String cpf, String nome, String endereco, Date data_nasc, boolean status) {
        super(cpf, nome, endereco, data_nasc);
        Status = status;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        this.Status = status;
    }
}
