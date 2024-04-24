package com.FrangoFrito.FrangoFrito.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Gerente extends Pessoa{
    private boolean status;

    public Gerente(){

    }
    public Gerente(String cpf, String nome, String endereco, Date data_nasc, boolean status) {
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