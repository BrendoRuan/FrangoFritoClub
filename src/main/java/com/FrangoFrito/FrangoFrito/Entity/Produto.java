package com.FrangoFrito.FrangoFrito.Entity;

import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String nomeProduto;
    @NotNull
    private Double valorDeCusto;
    @NotNull
    private Double valorDeVenda;
    /*
    * {
"nomeProduto":"frango frito",
"valorDeCusto":8.00,
"valorDeVenda":13.00,
"descricao":"Experimente nosso Balde de Frango Frito, a estrela do Club da Asinha! Cada pedaço é selecionado e marinado em temperos secretos, garantindo sabor e suculência incomparáveis",
"statusProduto":true,
"produtoEmDestaque":false,
"categoria":{
    "id":1
}
}
    * */
    @NotNull
    private boolean statusProduto;
    @NotNull
    private boolean produtoEmDestaque;
    @NotNull
    private String descricao;
    private String imagem;



    //@NotNull
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto(String nomeProduto, String imagem, Double valorDeCusto, Double valorDeVenda, Categoria categoria,String descricao) {
        this.nomeProduto = nomeProduto;
        this.valorDeCusto = valorDeCusto;
        this.valorDeVenda = valorDeVenda;
        this.categoria = categoria;
        this.descricao = descricao;
        this.imagem = imagem;
    }
    public Produto() {}

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
    public boolean isProdutoEmDestaque() {
        return produtoEmDestaque;
    }

    public void setProdutoEmDestaque(boolean produtoEmDestaque) {
        this.produtoEmDestaque = produtoEmDestaque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}