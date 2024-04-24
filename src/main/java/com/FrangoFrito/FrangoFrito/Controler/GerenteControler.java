package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Entity.Gerente;
import com.FrangoFrito.FrangoFrito.Repository.GerenteRepository;
import com.FrangoFrito.FrangoFrito.Service.GerenteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GerenteControler {
    private GerenteService gerenteService;
    public GerenteControler(GerenteService gerenteService){
        this.gerenteService = gerenteService;
    }

    @PostMapping("/cadastrarGerente")
    public void cadastrarGerente(@Valid @RequestBody Gerente gerente){
        gerenteService.cadastrarGerente(gerente);
    }
    @GetMapping("/listarGerente")
    public List<Gerente> getAllGerente(){
        return gerenteService.listarGerente();
    }
    @DeleteMapping("/deletarGerente/{id}")
    public void deletarGerente(@PathVariable Integer id){
        gerenteService.deletarGerente(id);
    }
    @PutMapping("/alterarStatusGerente/{id}")
    public void alterarStatusGerente(@PathVariable Integer id){
        gerenteService.alterarStatusGerente(id);
    }
    @GetMapping("/buscarGerente/{nome}")
    public Gerente buscarGerente(@PathVariable String nome){
        return gerenteService.buscarGerente(nome);
    }
}