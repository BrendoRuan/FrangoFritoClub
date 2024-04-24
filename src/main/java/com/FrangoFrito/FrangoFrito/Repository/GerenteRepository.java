package com.FrangoFrito.FrangoFrito.Repository;

import com.FrangoFrito.FrangoFrito.Entity.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente,Integer> {
    Gerente findByNome(String nome);
}
