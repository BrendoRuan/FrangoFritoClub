package com.FrangoFrito.FrangoFrito.Controler;
import com.FrangoFrito.FrangoFrito.Entity.Funcionario;
import com.FrangoFrito.FrangoFrito.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuncionarioControler {
    private FuncionarioService funcionarioService;
    public FuncionarioControler(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }
    @PostMapping("/cadastrarFuncionario")
    public void cadastrarFuncionario(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.cadastrarFuncionario(funcionario);
    }

    @GetMapping("/listarFuncionario")
    public List<Funcionario> getAllFuncionario(){
        return funcionarioService.listarFuncionario();
    }

    @GetMapping("/buscarFuncionario/{nome}")
    public Funcionario buscarFuncionario(@PathVariable String nome){
        return funcionarioService.buscarFuncionario(nome);
    }

    @DeleteMapping("/deletarFuncionario/{id}")
    public void deletarFuncionario(@PathVariable Integer id){
        funcionarioService.deletarFuncionario(id);
    }
    @PutMapping("/alterarStatusFuncionario/{id}")
    public void alterarStatusFuncionario(@PathVariable Integer id){
        funcionarioService.alterarStatusFuncionario(id);
    }
}