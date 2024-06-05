package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Entity.*;
import com.FrangoFrito.FrangoFrito.Entity.enums.StatusPedido;
import com.FrangoFrito.FrangoFrito.Repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private PedidoRepository pedidoRepository;
    private TipoPagamento tipoPagamento;



    public PedidoService(){
    }

    public PedidoService(ModelMapper modelMapper, PedidoRepository pedidoRepository) {
        this.modelMapper = modelMapper;
        this.pedidoRepository = pedidoRepository;
    }
    public Pedido cadastrarPedido(Cliente cliente, List<ItemVenda> itens, TipoPagamento tipoPagamento) {
        // Criar um novo pedido com as informações fornecidas
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setTipoPagamento(tipoPagamento);

        // Adicionar os itens do carrinho ao pedido e calcular o total
        double total = 0.0;
        for (ItemVenda item : itens) {
            total += item.getSubTotal();
            // Adicionar cada item ao pedido
            pedido.addItem(item);
        }
        pedido.setTotal(total);

        // Salvar o pedido no banco de dados
        return pedidoRepository.save(pedido);
    }

    /*public Pedido cadastrarPedido(Cliente cliente, CarrinhoCompra carrinhoCompra, TipoPagamento tipoPagamento) {
        // Criar um novo objeto Pedido
        Pedido pedido = new Pedido();

        // Completar dados do pedido
        pedido.setCliente(cliente);
        pedido.setTipoPagamento(tipoPagamento);
        pedido.setStatusPedido(StatusPedido.ACEITO);

        // Mapear os itens do carrinho para os itens do pedido, se necessário
        // Exemplo: pedido.setItens(carrinhoCompra.getItens());
        // Calcular o total do pedido, se necessário
        // Exemplo: pedido.setTotal(carrinhoCompra.getTotal());
        // Salvar pedido no banco de dados
        return pedidoRepository.save(pedido);
    }*/
}
