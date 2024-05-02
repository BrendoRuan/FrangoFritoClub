package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Categoria;

public class CategoriaDto {
    private Integer id;
    private String nomeCategoria;

    public CategoriaDto() {
    }
    public CategoriaDto(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    public CategoriaDto(Categoria categoria) {
        nomeCategoria = categoria.getNomeCategoria();
        id = categoria.getId();
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
}