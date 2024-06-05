package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import com.FrangoFrito.FrangoFrito.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoControler {
    private ProdutoService produtoService;

    public ProdutoControler(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/cadastrarProduto")
    public void cadastrarProduto(@RequestPart("imagem") MultipartFile imagem,@RequestPart("produtos") ProdutoDTO produto) {

        try{
            if (!imagem.isEmpty()){
                byte[] bytes= imagem.getBytes();
                String fileName = imagem.getOriginalFilename();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("C:\\Intel\\FrangoFrito\\src\\main\\resources\\imagem"+fileName));
                stream.write(bytes);
                stream.close();
                produto.setImagem(fileName);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        produtoService.cadastrarProduto(produto);
    }

/*@PostMapping("/cadastrarProduto")
public void cadastrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
    produtoService.cadastrarProduto(produtoDTO);
}*/

@GetMapping("/listarProduto")
public List<ProdutoDTO> getAllProduto() {
    return produtoService.listarProduto();
}

@GetMapping("/buscarProduto/{nomeProduto}")
public List<ProdutoDTO> buscarProduto(@PathVariable String nomeProduto) {
    return produtoService.buscarProduto(nomeProduto);
}

@GetMapping("/buscarProdutoId/{id}")
public Optional<ProdutoDTO> buscarProdutoId(@PathVariable Integer id) {
    return produtoService.buscarProdutoId(id);
}

@PutMapping("atualizarProduto/{id}")
public void atualizarProduto(@PathVariable Integer id, @Valid @RequestBody ProdutoDTO produtoDTO) {
    produtoService.atualizarProduto(id, produtoDTO);
}

@DeleteMapping("/deletarProduto/{id}")
public void deletarProduto(@PathVariable Integer id) {
    produtoService.deletarProduto(id);
}


@PutMapping("/alterarStatusProduto/{id}")
public void alterarStatusProduto(@PathVariable Integer id) {
    produtoService.alterarStatusProduto(id);
}

@PutMapping("/alterarStatusProdutoEmDestaque/{id}")
public void alterarStatusProdutoEmDestaque(@PathVariable Integer id) {
    produtoService.alterarStatusProdutoEmDestaque(id);
}
}

