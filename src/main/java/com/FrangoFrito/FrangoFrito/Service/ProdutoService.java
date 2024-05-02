package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDto;
import com.FrangoFrito.FrangoFrito.Dto.ProdutoDto;
import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import com.FrangoFrito.FrangoFrito.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    //Metodo para Cadastrar um Produto
    /*public Produto cadastrarProduto (ProdutoDto produtoDto) {
        Produto produto = new Produto();
        produto.setId(produto.getId());
        produto.setNomeProduto(produto.getNomeProduto());
        produto.setCategoria(produto.getCategoria());
        produto.setValorDeCusto(produto.getValorDeCusto());
        produto.setValorDeVenda(produto.getValorDeVenda());
        return produtoRepository.save(produto);
    }*/

    public Produto cadastrarProduto (ProdutoDto produtoDto) {
        Produto produto = new Produto();
        produto.setNomeProduto(produtoDto.getNomeProduto());
        produto.setCategoria(produtoDto.getCategoria());
        produto.setValorDeCusto(produtoDto.getValorDeCusto());
        produto.setValorDeVenda(produtoDto.getValorDeVenda());
        return produtoRepository.save(produto);
    }
    //Metodo para Buscar um Produto
    public Produto buscarProduto(String nomeProduto) {
        return produtoRepository.findByNomeProduto(nomeProduto);
    }

    //Metodo para Buscar um Produto pelo Id
    //public Optional<Produto> buscarProdutoId(Integer id) {
     //   return produtoRepository.findById(id);
    //}

    public ProdutoDto buscarProdutoDtoId(Integer id) {
        Produto  produto = produtoRepository.findById(id).get();
        ProdutoDto produtoDto = new ProdutoDto(produto);
        return produtoDto;
    }
    //Metodo para Deletar uma Produto pelo Id
    public void deletarProduto(Integer id) {
        produtoRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem das Produto
    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }
    //Metodo para alterar o status do Produto
    public Produto alterarStatusProduto(Integer id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null){
            produto.setStatusProduto(!produto.isStatusProduto());
            produtoRepository.save(produto);
        }
        return produto;
    }
}
