package com.FrangoFrito.FrangoFrito.Repository;

import com.FrangoFrito.FrangoFrito.Entity.Pedido;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import com.FrangoFrito.FrangoFrito.Entity.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento,Integer> {
    //List<TipoPagamento> findByNomeTipoPagamentoContainingIgnoreCase(String nomeTipoPagamento);
}
