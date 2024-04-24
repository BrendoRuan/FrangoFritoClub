package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteControler {

    private ClienteService clienteService;

    public ClienteControler(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrarCliente")
    public void cadastrarCliente(@Valid @RequestBody Cliente cliente){
        clienteService.cadastrarCliente(cliente);
    }

    @GetMapping("/listarCliente")
    public List<Cliente> getAllCliente(){
        return clienteService.listarCliente();
    }

    @GetMapping("/buscarCliente/{nome}")
    public Cliente buscarCliente(@PathVariable String nome){
        return clienteService.buscarCliente(nome);
    }

    @DeleteMapping("/deletarCliente/{id}")
    public void deletarCliente(@PathVariable Integer id){
        clienteService.deletarCliente(id);
    }
    @PutMapping("/alterarStatusCliente/{id}")
    public void alterarStatusCliente(@PathVariable Integer id){
        clienteService.alterarStatusCliente(id);
    }
}