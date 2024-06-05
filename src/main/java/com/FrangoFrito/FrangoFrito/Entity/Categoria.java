package com.FrangoFrito.FrangoFrito.Entity;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull

    private String nomeCategoria;
    @NotNull
    private boolean statusCategoria;

    @OneToMany(mappedBy = "Categoria",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Produto> produtos = new ArrayList<Produto>();
    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    public Categoria() {}
    public Categoria(CategoriaDTO categoria) {
        BeanUtils.copyProperties(categoria,this);
    }

    public Integer getIdCategoria() {
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
    public void addProduto(Produto produto) {
        produtos.add(produto);
        produto.setCategoria(this);
    }

    public void removeProduto(Produto produto) {
        produtos.remove(produto);
        produto.setCategoria(null);
    }

    public boolean isStatusCategoria() {
        return statusCategoria;
    }

    public void setStatusCategoria(boolean statusCategoria) {
        this.statusCategoria = statusCategoria;
    }
}