package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Entity.Pedido;
import com.FrangoFrito.FrangoFrito.Service.PagamentoService;
import com.FrangoFrito.FrangoFrito.Service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoControler {
    private PedidoService pedidoService;

    public PedidoControler(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    @PostMapping("/fazerPedido")
    public void fazerPedido(Pedido pedido){
        pedidoService.fazerPedido(pedido);
    }
    @GetMapping("/buscarPedido")
    public Pedido buscarPedido(Integer id){
        return pedidoService.buscarPedido(id);

    }
}
