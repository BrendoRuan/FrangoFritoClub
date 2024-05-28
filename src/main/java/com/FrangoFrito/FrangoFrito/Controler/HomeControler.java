package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import com.FrangoFrito.FrangoFrito.Dto.ProdutoDestaqueDTO;
import com.FrangoFrito.FrangoFrito.Dto.ProdutoEscolhidoDTO;
import com.FrangoFrito.FrangoFrito.Repository.ProdutoRepository;
import com.FrangoFrito.FrangoFrito.Service.HomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class HomeControler {
    @Autowired
    HomeService homeService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProdutoRepository produtoRepository;


    @GetMapping("/BuscaHome/{produtoCategoria}")
    public List<ProdutoDTO> buscadorHome(@PathVariable String produtoCategoria){
        return homeService.buscarProdutocategoria(produtoCategoria)
                .stream().map(produto -> modelMapper.map(produto, ProdutoDTO.class)).collect(Collectors.toList());
    }
    @GetMapping("/ItensEmDestaque")
    public ResponseEntity<List<ProdutoDestaqueDTO>> listarProdutosEmDestaque() {
        List<ProdutoDestaqueDTO> produtosEmDestaque = homeService.listarProdutosEmDestaque();
        return ResponseEntity.ok(produtosEmDestaque);
    }
    @GetMapping("/ItensEmDestaque/{id}")
    public ResponseEntity<ProdutoEscolhidoDTO> descricaoProduto(@PathVariable Integer id){
        Optional<ProdutoEscolhidoDTO> produtoDTO = homeService.descricaoProduto(id);
        return produtoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
    /*@GetMapping("/listarProduto")
    public List<ProdutoDTO> getAllProduto(){
        return produtoService.listarProduto();
    }*/
