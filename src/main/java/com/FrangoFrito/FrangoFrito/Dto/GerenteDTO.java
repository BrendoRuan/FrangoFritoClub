package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Gerente;
import org.springframework.beans.BeanUtils;

public class GerenteDTO extends PessoaDTO{
    private Boolean statusGerente;

    public GerenteDTO(){}
    public GerenteDTO(Gerente gerente){BeanUtils.copyProperties(gerente,this);}

    public GerenteDTO(Boolean statusGerente) {
        this.statusGerente = statusGerente;
    }

    public Boolean getStatusGerente() {
        return statusGerente;
    }

    public void setStatusGerente(Boolean statusGerente) {
        this.statusGerente = statusGerente;
    }
}

