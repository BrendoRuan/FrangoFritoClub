package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.*;
import com.FrangoFrito.FrangoFrito.Entity.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class PedidoDTO {
    private Integer idPedido;

    private Cliente cliente;

    private CarrinhoCompra carrinhoCompra;

    private TipoPagamento tipoPagamento;

    private StatusPedido statusPedido;

    public PedidoDTO(Integer idPedido,Cliente cliente, CarrinhoCompra carrinhoCompra, TipoPagamento tipoPagamento, StatusPedido statusPedido) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.carrinhoCompra = carrinhoCompra;
        this.tipoPagamento = tipoPagamento;
        this.statusPedido = statusPedido;
    }
    public PedidoDTO(){}
    public PedidoDTO(Pedido pedido) {
        BeanUtils.copyProperties(pedido,this);
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CarrinhoCompra getCarrinhoCompra() {
        return carrinhoCompra;
    }

    public void setCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
        this.carrinhoCompra = carrinhoCompra;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}