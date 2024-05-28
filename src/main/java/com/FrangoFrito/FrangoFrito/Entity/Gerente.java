package com.FrangoFrito.FrangoFrito.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Gerente extends Pessoa{
    private boolean statusGerente;

    public Gerente(){

    }
    public Gerente(String cpf, String nome, String endereco, LocalDate dataNasc,String email,String senha, boolean statusGerente) {
        super(cpf, nome, endereco, dataNasc,email,senha);
        this.statusGerente = statusGerente;
    }

    public boolean getstatusGerente() {
        return statusGerente;
    }

    public void setstatusGerente(boolean statusGerente) {
        this.statusGerente = statusGerente;
    }

}