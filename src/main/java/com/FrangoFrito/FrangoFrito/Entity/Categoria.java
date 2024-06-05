package com.FrangoFrito.FrangoFrito.Entity;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {
  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Corrigido o strategy para GenerationType.IDENTITY
    private Integer id;

    @NotNull
    @Column(nullable = false) // Adicionada a anotação para garantir que o campo não seja nulo no banco de dados
    private String nomeCategoria;

    @Column(nullable = false) // Adicionada a anotação para garantir que o campo não seja nulo no banco de dados
    private boolean statusCategoria;

    //@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) // Adicionado mappedBy para indicar o relacionamento bidirecional
    //private List<Produto> produtos = new ArrayList<>();

    // Construtor vazio
    public Categoria() {}

    // Construtor com nomeCategoria
    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    // Construtor com CategoriaDTO
    public Categoria(CategoriaDTO categoria) {
        BeanUtils.copyProperties(categoria, this);
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

    public boolean isStatusCategoria() {
        return statusCategoria;
    }

    public void setStatusCategoria(boolean statusCategoria) {
        this.statusCategoria = statusCategoria;
    }

    /*public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // Método para adicionar produto à lista
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        produto.setCategoria(this); // Define a categoria deste produto como a categoria atual
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull

    private String nomeCategoria;
    @NotNull
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

    public boolean isStatusCategoria() {
        return statusCategoria;
    }

    public void setStatusCategoria(boolean statusCategoria) {
        this.statusCategoria = statusCategoria;
    }
}