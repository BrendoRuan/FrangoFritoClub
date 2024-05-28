package com.FrangoFrito.FrangoFrito.Repository;

import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findByNomeProduto(String nomeProduto);
    List<Produto> findByNomeProdutoContainingIgnoreCase(String nomeProduto);

    List<Produto> findByCategoria_NomeCategoriaContainingIgnoreCase(String produtoCategoria);
    List<Produto> findByProdutoEmDestaque(boolean produtoEmDestaque);
}
