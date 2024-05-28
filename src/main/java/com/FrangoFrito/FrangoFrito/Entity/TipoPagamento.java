package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class TipoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min=5,max=255)
    @NotNull
    private Integer nomeTipoPagamento;

    private TipoPagamento(){}
    private boolean statusTipoPagamento;

    public TipoPagamento(Integer id, Integer nomeTipoaPgamento,boolean statusTipoPagamento) {
        this.id = id;
        this.nomeTipoPagamento = nomeTipoPagamento;
        this.statusTipoPagamento = statusTipoPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNomeTipoPagamento() {
        return nomeTipoPagamento;
    }

    public void setNomeTipoPagamento(Integer nomeTipoPagamento) {
        this.nomeTipoPagamento = nomeTipoPagamento;
    }

    public boolean getStatusTipoPagamento() {
        return statusTipoPagamento;
    }

    public void setStatusTipoPagamento(boolean statusTipoPagamento) {
        this.statusTipoPagamento = statusTipoPagamento;
    }
}
