package com.FrangoFrito.FrangoFrito.Controler;
import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.FrangoFrito.FrangoFrito.Dto.ClienteDTO;
import com.FrangoFrito.FrangoFrito.Dto.FuncionarioDTO;
import com.FrangoFrito.FrangoFrito.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FuncionarioControler {
    private FuncionarioService funcionarioService;
    public FuncionarioControler(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }
    @PostMapping("/cadastrarFuncionario")
    public void cadastrarFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO){
        funcionarioService.cadastrarFuncionario(funcionarioDTO);
    }

    @GetMapping("/listarFuncionario")
    public List<FuncionarioDTO> getAllFuncionario(){
        return funcionarioService.listarFuncionario();
    }
    @GetMapping("/buscarFuncionarioId/{id}")
    public Optional<FuncionarioDTO> buscarClienteId(@PathVariable Integer id) {
        return funcionarioService.buscarFuncionarioId(id);
    }
    @GetMapping("/buscarFuncionarioNome/{nome}")
    public List<FuncionarioDTO> buscarFuncionario(@PathVariable String nome){
        return funcionarioService.buscarFuncionarioNome(nome);
    }

    @DeleteMapping("/deletarFuncionario/{id}")
    public void deletarFuncionario(@PathVariable Integer id){
        funcionarioService.deletarFuncionario(id);
    }
    @PutMapping("atualizarFuncionario/{id}")
    public void atualizarFuncionario(@PathVariable Integer id, @Valid @RequestBody FuncionarioDTO funcionarioDTO){
        funcionarioService.atualizarFuncionario(id,funcionarioDTO);}
/* @PutMapping("atualizarCliente/{id}")
    public void atualizarCliente(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO){clienteService.atualizarCliente(id,clienteDTO);}
*/
    @PutMapping("/alterarStatusFuncionario/{id}")
    public void alterarStatusFuncionario(@PathVariable Integer id){
        funcionarioService.alterarStatusFuncionario(id);
    }

}