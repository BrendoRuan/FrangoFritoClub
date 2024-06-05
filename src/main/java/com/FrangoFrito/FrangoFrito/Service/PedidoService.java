package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Entity.CarrinhoCompra;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Entity.Pedido;
import com.FrangoFrito.FrangoFrito.Entity.TipoPagamento;
import com.FrangoFrito.FrangoFrito.Entity.enums.StatusPedido;
import com.FrangoFrito.FrangoFrito.Repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private PedidoRepository pedidoRepository;
    TipoPagamento tipoPagamento;


    public PedidoService(){
    }
    public PedidoService(ModelMapper modelMapper, PedidoRepository pedidoRepository) {
        this.modelMapper = modelMapper;
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido cadastrarPedido(Cliente cliente, CarrinhoCompra carrinhoCompra, TipoPagamento tipoPagamento) {
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
    }
}
