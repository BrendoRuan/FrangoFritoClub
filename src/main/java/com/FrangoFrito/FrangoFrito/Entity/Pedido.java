package com.FrangoFrito.FrangoFrito.Entity;

import com.FrangoFrito.FrangoFrito.Entity.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPedido;
    @OneToOne
    @NotNull
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private CarrinhoCompra carrinhoCompra;
    @OneToOne
    @NotNull
    private TipoPagamento tipoPagamento;
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
    private Pedido(){}

    public Pedido(Cliente cliente,CarrinhoCompra carrinhoCompras, TipoPagamento tipoPagamento, StatusPedido statusPedido) {
        this.cliente = cliente;
        this.carrinhoCompra = carrinhoCompras;
        this.tipoPagamento = tipoPagamento;
        this.statusPedido = statusPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void cancelarPedido(){
        this.statusPedido = StatusPedido.CANCELADO;
    }
    public void pedidoAceito(){
        this.statusPedido = StatusPedido.ACEITO;
    }
    public void emPreparo(){
        this.statusPedido = StatusPedido.EM_PREPARO;
    }
    public void emTransporte(){
        this.statusPedido = StatusPedido.EM_TRANSPORTE;
    }
    public void entregue(){
        this.statusPedido  = StatusPedido.ENTREGUE;
    }
}