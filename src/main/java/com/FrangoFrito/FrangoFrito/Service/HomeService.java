package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Dto.ProdutoDestaqueDTO;
import com.FrangoFrito.FrangoFrito.Dto.ProdutoEscolhidoDTO;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import com.FrangoFrito.FrangoFrito.Repository.CategoriaRepository;
import com.FrangoFrito.FrangoFrito.Repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    HomeService homeService;


    public List<Produto> buscarProdutocategoria(String produtoCategoria) {
        List<Produto> produtos = produtoRepository.findByNomeProdutoContainingIgnoreCase(produtoCategoria);
        List<Produto> produtosCat = produtoRepository.findByCategoria_NomeCategoriaContainingIgnoreCase(produtoCategoria);
        produtosCat.addAll(produtos);
        return produtosCat;
    }

    public List<ProdutoDestaqueDTO> listarProdutosEmDestaque() {
        List<Produto> produtos = produtoRepository.findByProdutoEmDestaque(true);
        List<ProdutoDestaqueDTO> produtosDestaqueDTO  = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDestaqueDTO dto = modelMapper.map(produto, ProdutoDestaqueDTO.class);
            produtosDestaqueDTO.add(dto);
        }
        return produtosDestaqueDTO;
    }
    public Optional<ProdutoEscolhidoDTO>descricaoProduto(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(produto1 -> modelMapper.map(produto,ProdutoEscolhidoDTO.class));
    }


}
    /*public List<ProdutoDTO> listarProdutosEmDestaque(List<ProdutoDTO> produtos) {
        List<ProdutoDTO> produtosEmDestaque = new ArrayList<>();
        for (ProdutoDTO produto : produtos) {
            if (produto.isProdutoEmDestaque()) {
                produtosEmDestaque.add(produto);
            }

        }
        return produtosEmDestaque;
    }*/
        /*    public List<ProdutoDTO> listarProduto() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(produto -> modelMapper.map(produto,ProdutoDTO.class)).collect(Collectors.toList());
    }*/
  /*  private List<List<?>> buscadorHome(String nomeProduto, String nomeCategoria){
        List<Produto> produto = produtoRepository.findByNomeProdutoContainingIgnoreCase(nomeProduto);
        List<ProdutoDTO> produtoDTOLis = new ArrayList<>();
        for (Produto p : produto){
            produtoDTOLis.add(modelMapper.map(p, ProdutoDTO.class));}
        List<Categoria> categoria =  categoriaRepository.findByNomeCategoriaContainingIgnoreCase(nomeCategoria);
        List<CategoriaDTO> categoriaDTOList = new ArrayList<>();
        for (Categoria c : categoria){
            categoriaDTOList.add(modelMapper.map(c, CategoriaDTO.class));}

        List<List<?>> resultadoBusca = new ArrayList<>();
        resultadoBusca.add(produtoDTOLis);
        resultadoBusca.add(categoriaDTOList);
        return resultadoBusca;

    }*/
