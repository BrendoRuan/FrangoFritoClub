package com.FrangoFrito.FrangoFrito.Entity.enums;

public enum StatusPedido {
    ACEITO(0,"Pedido aceito" ),
    EM_PREPARO(1, "Em preparo"),
    EM_TRANSPORTE(2, "Em transporte"),
    ENTREGUE(3,"Pedido Entregue"),
    CANCELADO(4,"Pedido cancelado");

    StatusPedido(int i, String s) {
    }
}
