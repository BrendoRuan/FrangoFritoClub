package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.Entity;


import java.time.LocalDate;

@Entity
public class Cliente extends Pessoa{
    private boolean statusCliente;
    public Cliente() {}
    public Cliente(String cpf, String nome, String endereco, LocalDate dataNasc, boolean statusCliente,String email, String senha) {
        super(cpf, nome, endereco, dataNasc,email,senha);
        this.statusCliente = statusCliente;
    }

    public boolean getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(boolean statusCliente) {
        this.statusCliente = statusCliente;
    }
}