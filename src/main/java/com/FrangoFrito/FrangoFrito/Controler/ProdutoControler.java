package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Dto.ProdutoDto;
import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import com.FrangoFrito.FrangoFrito.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoControler {
    private ProdutoService produtoService;

    public ProdutoControler(ProdutoService produtoService){
        this.produtoService = produtoService;
    }
    @PostMapping("/cadastrarProduto")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody ProdutoDto produtoDto){
        Produto cadastrarProduto = produtoService.cadastrarProduto(produtoDto);
        return ResponseEntity.ok(cadastrarProduto);
    }

    @GetMapping("/listarProduto")
    public List<Produto> getAllProduto(){
        return produtoService.listarProduto();
    }

    @GetMapping("/buscarProduto/{nomeProduto}")
    public Produto buscarProduto(@PathVariable String nomeProduto){
        return produtoService.buscarProduto(nomeProduto);
    }

   // @GetMapping("/buscarProdutoId/{id}")
    //public Optional<Produto> buscarProdutoId(@PathVariable Integer id){
      // return produtoService.buscarProdutoId(id);
    //}
    @DeleteMapping("/deletarProduto/{id}")
    public void deletarProduto(@PathVariable Integer id){
        produtoService.deletarProduto(id);
    }
    @PutMapping("/alterarStatusProduto/{id}")
    public void alterarStatusProduto(@PathVariable Integer id){
        produtoService.alterarStatusProduto(id);
    }
}
