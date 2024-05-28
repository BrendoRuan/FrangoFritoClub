package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private PedidoRepository pedidoRepository;

}
