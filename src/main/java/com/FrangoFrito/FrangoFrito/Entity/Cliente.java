package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

import java.util.Date;

@Entity
public class Cliente extends Pessoa{
    private boolean status;
    public Cliente() {
    }
    public Cliente(String cpf, String nome, String endereco, Date data_nasc, boolean status) {
        super(cpf, nome, endereco, data_nasc);
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}