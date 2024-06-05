package com.FrangoFrito.FrangoFrito.Entity;


import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class ItemVenda {
    private ProdutoDTO produtoDTO;
    private Double subTotal;
    private Integer quantidadeDoItem;

    public ItemVenda(ProdutoDTO produtoDTO, Double subTotal, Integer quantidadeDoItem) {
        this.produtoDTO = produtoDTO;
        this.subTotal = subTotal;
        this.quantidadeDoItem = quantidadeDoItem;
    }

    public ItemVenda() {

    }

    public ProdutoDTO getProdutoDTO() {
        return produtoDTO;
    }

    public void setProdutoDTO(ProdutoDTO produtoDTO) {
        this.produtoDTO = produtoDTO;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getQuantidadeDoItem() {
        return quantidadeDoItem;
    }

    public void setQuantidadeDoItem(Integer quantidadeDoItem) {
        this.quantidadeDoItem = quantidadeDoItem;
    }
}