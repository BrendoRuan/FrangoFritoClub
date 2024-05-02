package com.FrangoFrito.FrangoFrito.Entity;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {
    @Id
    private Integer id;

    private String nomeCategoria;
    private boolean statusCategoria;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<>();
    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    public Categoria() {}
    public Categoria(CategoriaDTO categoria) {
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean isStatusCategoria() {
        return statusCategoria;
    }

    public void setStatusCategoria(boolean statusCategoria) {
        this.statusCategoria = statusCategoria;
    }
}