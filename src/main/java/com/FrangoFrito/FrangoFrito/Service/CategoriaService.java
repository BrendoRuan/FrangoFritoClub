package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
       this.categoriaRepository = categoriaRepository;
    }

    //Metodo para Cadastrar uma Categoria
    public void cadastrarCategoria(@Valid CategoriaDTO categoriaDTO) {
        Categoria categoriaEntity = new Categoria(categoriaDTO);
        categoriaRepository.save(categoriaEntity);

    }

    //Metodo para Buscar uma categoria
    public Categoria buscarCategoria(String nomeCategoria) {
        return categoriaRepository.findByNomeCategoria(nomeCategoria);
    }

    //Metodo para Buscar um Categoria pelo Id
    public Optional<CategoriaDTO> buscarCategoriaId(Integer id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.map(categoria -> {
            CategoriaDTO categoriaDTO = new CategoriaDTO();
            categoriaDTO.setId(categoria.getId());
            return categoriaDTO;
        });
    }
    //Metodo para Deletar uma categoria pelo Id
    public void deletarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem das categoria
    public List<CategoriaDTO> listarCategoria() {
        List<Categoria> categoria = categoriaRepository.findAll();
        return categoria.stream().map(CategoriaDTO::new).toList();}
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