package com.FrangoFrito.FrangoFrito.Entity;

import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.springframework.beans.BeanUtils;

@Entity
public class Produto {
    @Id
    private Integer id;
    private String nomeProduto;
    private Double valorDeCusto;
    private Double valorDeVenda;
    private boolean statusProduto;

    @OneToOne
    @JoinColumn(unique = false)
    private Categoria categoria;

    public Produto(String nomeProduto, Double valorDeCusto, Double valorDeVenda, Categoria categoria) {
        this.nomeProduto = nomeProduto;
        this.valorDeCusto = valorDeCusto;
        this.valorDeVenda = valorDeVenda;
        this.categoria = categoria;
    }
    public Produto() {}
    public Produto(ProdutoDTO produto){
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(boolean statusProduto) {
        this.statusProduto = statusProduto;
    }
}