package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import com.FrangoFrito.FrangoFrito.Repository.CategoriaRepository;
import com.FrangoFrito.FrangoFrito.Repository.ProdutoRepository;
import com.FrangoFrito.FrangoFrito.infra.ModelMapperConfig;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    //Metodo para Cadastrar um Produto
    public void cadastrarProduto(@Valid ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);

        Categoria categoria = categoriaRepository.findById(produtoDTO.getCategoria()).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        produto.setCategoria(categoria);
        produto.setImagem(produtoDTO.getImagem());
        produtoRepository.save(produto);
    }

    //Metodo para Buscar um Produto
    public List<ProdutoDTO> buscarProduto(String nomeProduto) {
        List<Produto> produto = produtoRepository.findByNomeProdutoContainingIgnoreCase(nomeProduto);
        List<ProdutoDTO> produtoDTOLis = new ArrayList<>();
        for (Produto p : produto){
            produtoDTOLis.add(modelMapper.map(p, ProdutoDTO.class));}
       return produtoDTOLis;
     //   return produto.stream().map(ProdutoDTO::new).toList();
    }
    /*public List<ClienteDTO> buscarCliente(String nome) {
        List<Cliente> cliente =  clienteRepository.findByNomeContainingIgnoreCase(nome);
        return cliente.stream().map(ClienteDTO::new).toList();
    }*/

    //Metodo para Buscar um Produto pelo Id
    public Optional<ProdutoDTO> buscarProdutoId(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(produto1 -> modelMapper.map(produto,ProdutoDTO.class));
    }
    /*public Optional<ProdutoDTO> buscarProdutoId(Integer id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional.map(produto -> modelMapper.map(produto, ProdutoDTO.class));
    }
*/

    //Metodo para Deletar uma Produto pelo Id
    public void deletarProduto(Integer id) {
        produtoRepository.deleteById(id);
    }



    //Metodo para Fazer uma Listagem das Produto
    public List<ProdutoDTO> listarProduto() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(produto -> modelMapper.map(produto,ProdutoDTO.class)).collect(Collectors.toList());
    }
    /*    public List<ProdutoDTO> listarProduto() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }*/


    //metodo para atualizar o produto

    public void atualizarProduto(Integer id, ProdutoDTO produtoDTO){
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        Categoria categoria = categoriaRepository.findById(produtoDTO.getCategoria()).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        produto.setCategoria(categoria);
        produto.setId(id);
        produtoRepository.save(produto);
    }
    /*    public void atualizarProduto(Integer id, ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);

        Categoria categoria = categoriaRepository.findById(produtoDTO.getCategoria()).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        produto.setCategoria(categoria);
        produto.setId(id); // Garante que o ID do produto seja o mesmo do que está sendo atualizado
        produtoRepository.save(produto);
    }*/

    //Metodo para alterar o status do Produto
    public Produto alterarStatusProduto(Integer id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null){
            produto.setStatusProduto(!produto.isStatusProduto());
            produtoRepository.save(produto);
        }
        return produto;
    }
    public Produto alterarStatusProdutoEmDestaque(Integer id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null){
            produto.setProdutoEmDestaque(!produto.isProdutoEmDestaque());
            produtoRepository.save(produto);
        }
        return produto;
    }
}
