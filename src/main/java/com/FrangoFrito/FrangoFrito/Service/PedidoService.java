package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Entity.Pedido;
import com.FrangoFrito.FrangoFrito.Entity.enums.StatusPedido;
import com.FrangoFrito.FrangoFrito.Repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoService(){
    }
    public PedidoService(ModelMapper modelMapper, PedidoRepository pedidoRepository) {
        this.modelMapper = modelMapper;
        this.pedidoRepository = pedidoRepository;
    }

    public void fazerPedido (Pedido pedido){
        pedido.setStatusPedido(StatusPedido.ACEITO);
        pedidoRepository.save(pedido);
    }
    public Pedido buscarPedido(Integer id){
       return pedidoRepository.findById(id).orElseThrow();
    }
}
