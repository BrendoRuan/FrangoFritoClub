package com.FrangoFrito.FrangoFrito.Repository;

import com.FrangoFrito.FrangoFrito.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
    Funcionario findByNome(String nome);
}
