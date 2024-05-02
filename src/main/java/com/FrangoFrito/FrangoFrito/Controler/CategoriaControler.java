package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaControler {
    private CategoriaService categoriaService;
    public CategoriaControler(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    @PostMapping("/cadastrarCategoria")
    public void cadastrarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        categoriaService.cadastrarCategoria(categoriaDTO);
    }

    @GetMapping("/listarCategoria")
    public List<CategoriaDTO> getAllCategoria(){
        return categoriaService.listarCategoria();
    }

    @GetMapping("/buscarCategoria/{nomeCategoria}")
    public Categoria buscarCategoria(@PathVariable String nomeCategoria){
        return categoriaService.buscarCategoria(nomeCategoria);
    }

    @GetMapping("/buscarCategoriaId/{id}")
    public Optional<CategoriaDTO> buscarCategoriaId(@PathVariable Integer id){
        return categoriaService.buscarCategoriaId(id);
    }
    @DeleteMapping("/deletarCategoria/{id}")
    public void deletarCategoria(@PathVariable Integer id){
        categoriaService.deletarCategoria(id);
    }
    @PutMapping("/alterarStatusCategoria/{id}")
    public void alterarStatusCategoria(@PathVariable Integer id){
        categoriaService.alterarStatusCategoria(id);
    }
}