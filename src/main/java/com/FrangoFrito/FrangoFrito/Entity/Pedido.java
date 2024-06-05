package com.FrangoFrito.FrangoFrito.Entity;

import com.FrangoFrito.FrangoFrito.Entity.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPedido;
    @OneToOne
    @NotNull
    private Cliente cliente;
   // @OneToOne
    //private CarrinhoCompra carrinhoCompra;
    @OneToOne
    @NotNull
    private TipoPagamento tipoPagamento;
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens = new ArrayList<>();

    private double total;
    public Pedido(){}

    public Pedido(Cliente cliente, double total, /*CarrinhoCompra carrinhoCompra,*/ TipoPagamento tipoPagamento, StatusPedido statusPedido) {
        this.cliente = cliente;
        this.total = total;
        //this.carrinhoCompra = carrinhoCompra;
        this.tipoPagamento = tipoPagamento;
        this.statusPedido = statusPedido;
    }

    public void addItem(ItemVenda item) {
        this.itens.add(item);
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    /*public CarrinhoCompra getCarrinhoCompra() {
        return carrinhoCompra;
    }

    public void setCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
        this.carrinhoCompra = carrinhoCompra;}

        */


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