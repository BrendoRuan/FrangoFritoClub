package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import com.FrangoFrito.FrangoFrito.Repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    ModelMapper modelMapper;
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
       this.categoriaRepository = categoriaRepository;
    }

    //Metodo para Cadastrar uma Categoria
    public void cadastrarCategoria(@Valid CategoriaDTO categoriaDTO) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);

    }

    //Metodo para Buscar uma categoria
    public List<CategoriaDTO> buscarCategoria(String nomeCategoria) {
        List<Categoria> categoria =  categoriaRepository.findByNomeCategoriaContainingIgnoreCase(nomeCategoria);
        List<CategoriaDTO> categoriaDTOList = new ArrayList<>();
        for (Categoria c : categoria){
            categoriaDTOList.add(modelMapper.map(c, CategoriaDTO.class));}
        return categoriaDTOList;
    }
    /*   public List<ProdutoDTO> buscarProduto(String nomeProduto) {
        List<Produto> produto = produtoRepository.findByNomeProdutoContainingIgnoreCase(nomeProduto);
        return produto.stream().map(ProdutoDTO::new).toList();
    }*/
    /*   public List<ClienteDTO> buscarCliente(String nome) {
        List<Cliente> cliente =  clienteRepository.findByNomeContainingIgnoreCase(nome);
        return cliente.stream().map(ClienteDTO::new).toList();
    }*/


    //Metodo para Buscar um Categoria pelo Id
    public Optional<CategoriaDTO> buscarCategoriaId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(categoria1 -> modelMapper.map(categoria,CategoriaDTO.class));


    }
    //Metodo para Deletar uma categoria pelo Id
    public void deletarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem das categoria
    public List<CategoriaDTO> listarCategoria() {
        List<Categoria> categoria = categoriaRepository.findAll();
        List<CategoriaDTO> categoriaDTOList = new ArrayList<>();
        for (Categoria c : categoria)
            categoriaDTOList.add(modelMapper.map(c, CategoriaDTO.class));
        return categoriaDTOList;
    }

    //Metodo para atualizar categoria
    public void atualizarCategoria(Integer id, @Valid CategoriaDTO categoriaDTO){
        Categoria categoria= modelMapper.map(categoriaDTO, Categoria.class);
        categoria.setId(id);
        categoriaRepository.save(categoria);
    }
    public Categoria alterarStatusCategoria(Integer id){
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if (categoria != null){
            categoria.setStatusCategoria(!categoria.isStatusCategoria());
            categoriaRepository.save(categoria);
        }
        return categoria;
    }
}