package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Entity.CarrinhoCompra;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Entity.Pedido;
import com.FrangoFrito.FrangoFrito.Entity.TipoPagamento;
import com.FrangoFrito.FrangoFrito.Repository.ClienteRepository;
import com.FrangoFrito.FrangoFrito.Repository.TipoPagamentoRepository;
import com.FrangoFrito.FrangoFrito.Service.PagamentoService;
import com.FrangoFrito.FrangoFrito.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoControler {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<Pedido> cadastrarPedido(
            @RequestParam Integer clienteId,
            @RequestParam Integer tipoPagamentoId,
            @RequestBody CarrinhoCompra carrinhoCompra) {

        // Obter as entidades Cliente e TipoPagamento do banco de dados
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
        TipoPagamento tipoPagamento = tipoPagamentoRepository.findById(tipoPagamentoId).orElseThrow();

        // Chamar o serviço para cadastrar o pedido
        Pedido pedido = pedidoService.cadastrarPedido(cliente, carrinhoCompra, tipoPagamento);

        // Retornar a resposta com o pedido criado
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

}