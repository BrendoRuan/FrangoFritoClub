package com.FrangoFrito.FrangoFrito.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPedido;
    private Double valorTotal;
    @OneToOne
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos;
    @OneToOne
    private Funcionario funcionario;
    @OneToOne
    private TipoPagamento tipoPagamento;
    private boolean statusPedido;
    private Pedido(){}

    public Pedido(Integer idPedido, Double valorTotal, List<Produto>  produtos, Funcionario funcionario, TipoPagamento tipoPagamento, boolean statusPedido,Cliente cliente) {
        this.idPedido = idPedido;
        this.valorTotal = valorTotal;
        this.produtos = produtos;
        this.funcionario = funcionario;
        this.tipoPagamento = tipoPagamento;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto>  getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produto) {
        this.produtos = produtos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public boolean getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(boolean statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void calcularValorTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getValorDeVenda();
        }
        this.valorTotal = total;
    }
}
