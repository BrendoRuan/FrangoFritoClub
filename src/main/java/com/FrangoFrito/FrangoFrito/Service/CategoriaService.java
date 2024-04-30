package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
       this.categoriaRepository = categoriaRepository;
    }

    //Metodo para Cadastrar um Cliente
    public void cadastrarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    //Metodo para Buscar um Cliente
    public Categoria buscarCategoria(String nomeCategoria) {
        return categoriaRepository.findByNomeCategoria(nomeCategoria);
    }

    //Metodo para Buscar um Categoria pelo Id
    public Optional<Categoria> buscarCategoriaId(Integer id) {
        return categoriaRepository.findById(id);
    }

    //Metodo para Deletar uma categoria pelo Id
    public void deletarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem das categoria
    public List<Categoria> listarCategoria() {
        return categoriaRepository.findAll();
    }
    //Metodo para alterar o status do Cliente
    public Categoria alterarStatusCategoria(Integer id){
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if (categoria != null){
            categoria.setStatusCategoria(!categoria.isStatusCategoria());
            categoriaRepository.save(categoria);
        }
        return categoria;
    }
}