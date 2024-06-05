package com.FrangoFrito.FrangoFrito.Entity;


import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import jakarta.persistence.*;

@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private ProdutoDTO produtoDTO;
    private Double subTotal;
    private Integer quantidadeDoItem;

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