package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import org.springframework.beans.BeanUtils;

public class CategoriaDTO {
    private Integer id;
    private String nomeCategoria;
    private boolean statusCategoria;

    public CategoriaDTO(Integer id, String nomeCategoria, boolean statusCategoria) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.statusCategoria = statusCategoria;
    }
    public CategoriaDTO(){}
    public CategoriaDTO(Categoria categoria) {
        BeanUtils.copyProperties(categoria,this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public boolean isStatusCategoria() {
        return statusCategoria;
    }

    public void setStatusCategoria(boolean statusCategoria) {
        this.statusCategoria = statusCategoria;
    }
}
