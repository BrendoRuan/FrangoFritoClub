package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.TipoPagamento;
import org.springframework.beans.BeanUtils;

public class TipoPagamentoDTO {

    private Integer Id;
    private Integer nomeTipoPgamento;
    private boolean statusTipoPagamento;

    public TipoPagamentoDTO(Integer id, Integer nomeTipoPgamento,boolean statusTipoPagamento) {
        this.Id = id;
        this.nomeTipoPgamento = nomeTipoPgamento;
        this.statusTipoPagamento = statusTipoPagamento;
    }
    public TipoPagamentoDTO(){};
    public TipoPagamentoDTO(TipoPagamento tipoPagamento){BeanUtils.copyProperties(tipoPagamento,this);}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getNomeTipoPgamento() {
        return nomeTipoPgamento;
    }

    public void setNomeTipoPgamento(Integer nomeTipoPgamento) {
        this.nomeTipoPgamento = nomeTipoPgamento;
    }

    public boolean getStatusTipoPagamento() {
        return statusTipoPagamento;
    }

    public void setStatusTipoPagamento(boolean statusTipoPagamento) {
        this.statusTipoPagamento = statusTipoPagamento;
    }
}
