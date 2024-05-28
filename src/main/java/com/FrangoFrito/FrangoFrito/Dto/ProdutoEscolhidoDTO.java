package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Produto;
import org.springframework.beans.BeanUtils;

public class ProdutoEscolhidoDTO {
    private String nomeProduto;
    private Double valorDeVenda;
    private String nomeCategoria;
    private String descricao;

    public ProdutoEscolhidoDTO(String nomeProduto,Double valorDeVenda,String nomeCategoria,String descricao){
        this.nomeProduto=nomeProduto;
        this.nomeCategoria=nomeCategoria;
        this.valorDeVenda=valorDeVenda;
        this.descricao = descricao;
    }
    public ProdutoEscolhidoDTO(){}
    public ProdutoEscolhidoDTO(Produto produto){
        BeanUtils.copyProperties(produto,this);
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(Double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
