package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import org.springframework.beans.BeanUtils;

public class ProdutoDTO {
    private Integer id;
    private String nomeProduto;
    private Double valorDeCusto;
    private Double valorDeVenda;
    private boolean statusProduto;
    private Categoria categoria;

    public ProdutoDTO(Integer id, String nomeProduto, Double valorDeCusto, Double valorDeVenda, boolean statusProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valorDeCusto = valorDeCusto;
        this.valorDeVenda = valorDeVenda;
        this.statusProduto = statusProduto;
        this.categoria = categoria;
    }
    public ProdutoDTO(){}

    public ProdutoDTO(Produto produto){
        BeanUtils.copyProperties(produto,this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorDeCusto() {
        return valorDeCusto;
    }

    public void setValorDeCusto(Double valorDeCusto) {
        this.valorDeCusto = valorDeCusto;
    }

    public Double getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(Double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    public boolean isStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(boolean statusProduto) {
        this.statusProduto = statusProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
