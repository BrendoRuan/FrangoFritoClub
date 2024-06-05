package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Entity.*;
import com.FrangoFrito.FrangoFrito.Repository.ClienteRepository;
import com.FrangoFrito.FrangoFrito.Repository.TipoPagamentoRepository;
import com.FrangoFrito.FrangoFrito.Service.CarrinhoService;
import com.FrangoFrito.FrangoFrito.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PedidoControler {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;
    @Autowired
    private CarrinhoService carrinhoService;

/*
    @PostMapping("/cadastrar")
    public ResponseEntity<Pedido> cadastrarPedido(
            @RequestParam Integer clienteId,
            @RequestParam Integer tipoPagamentoId,
            @RequestBody CarrinhoCompra carrinhoCompra) {

        // Obter as entidades Cliente e TipoPagamento do banco de dados
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
        TipoPagamento tipoPagamento = tipoPagamentoRepository.findById(tipoPagamentoId).orElseThrow();

        // Criar a lista de itens do pedido a partir dos itens do carrinho
        List<ItemVenda> itensVenda = carrinhoCompra.getItens().stream().map(item -> {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProdutoDTO(item.getProdutoDTO());
            itemVenda.setQuantidadeDoItem(item.getQuantidadeDoItem());
            itemVenda.setSubTotal(item.getSubTotal());
            return itemVenda;
        }).collect(Collectors.toList());

        // Criar o pedido
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setItens(itensVenda);
        pedido.setTotal(carrinhoCompra.getTotal());
        pedido.setTipoPagamento(tipoPagamento);

        // Salvar o pedido usando o serviço de pedidos
        Pedido pedidoSalvo = pedidoService.cadastrarPedido(pedido);

        // Limpar o carrinho após salvar o pedido
        carrinhoService.limparCarrinho();

        // Retornar a resposta com o pedido criado
        return new ResponseEntity<>(pedidoSalvo, HttpStatus.CREATED);
    }*/
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