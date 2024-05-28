package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class PedidoDTO {
    private Integer idPedido;
    private Double valorTotal;

    private Cliente cliente;

    private List<Produto> produto;

    private Funcionario funcionario;

    private TipoPagamento tipoPagamento;
    private boolean statusPedido;

    public PedidoDTO(Integer idPedido, Double valorTotal, Cliente cliente, List<Produto> produto, Funcionario funcionario, TipoPagamento tipoPagamento, boolean statusPedido) {
        this.idPedido = idPedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.produto = produto;
        this.funcionario = funcionario;
        this.tipoPagamento = tipoPagamento;
        this.statusPedido = statusPedido;
    }

    public PedidoDTO(){}

    public PedidoDTO(Pedido pedido){
        BeanUtils.copyProperties(pedido, this);
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
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

    public boolean isStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(boolean statusPedido) {
        this.statusPedido = statusPedido;
    }
}
