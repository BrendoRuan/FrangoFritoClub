package com.FrangoFrito.FrangoFrito.Repository;

import com.FrangoFrito.FrangoFrito.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findByNomeProduto(String nomeProduto);
}
