package com.FrangoFrito.FrangoFrito.Repository;

import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Categoria findByNomeCategoria(String nomeCategoria);
}
