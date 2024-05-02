package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Produto;

public class ProdutoDto {
    private Integer id;
    private String nomeProduto;
    private Double valorDeCusto;
    private Double valorDeVenda;
    private Categoria categoria;

    public ProdutoDto() {
    }
    public ProdutoDto(String nomeProduto, Double valorDeCusto, Double valorDeVenda) {
        this.nomeProduto = nomeProduto;
        this.valorDeCusto = valorDeCusto;
        this.valorDeVenda = valorDeVenda;
    }
    public ProdutoDto(Produto produto) {
        nomeProduto = produto.getNomeProduto();
        valorDeCusto = produto.getValorDeCusto();
        valorDeVenda = produto.getValorDeVenda();
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}