package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Produto;
import org.springframework.beans.BeanUtils;

public class ProdutoDestaqueDTO {
    private String nomeProduto;
    private Double valorDeVenda;
    private String nomeCategoria;

    public ProdutoDestaqueDTO(String nomeProduto,Double valorDeVenda,String nomeCategoria){
        this.nomeProduto=nomeProduto;
        this.nomeCategoria=nomeCategoria;
        this.valorDeVenda=valorDeVenda;
    }
    public ProdutoDestaqueDTO(){}
    public ProdutoDestaqueDTO(Produto produto){
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
}
