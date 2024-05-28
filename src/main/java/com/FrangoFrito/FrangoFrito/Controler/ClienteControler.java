
package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.FrangoFrito.FrangoFrito.Dto.ClienteDTO;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ClienteControler {

   private ClienteService clienteService;

    public ClienteControler(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrarCliente")
    public void cadastrarCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        clienteService.cadastrarCliente(clienteDTO);
    }

    @GetMapping("/listarCliente")
    public List<ClienteDTO> getAllCliente(){
        return clienteService.listarCliente();
    }

    @GetMapping("/buscarClienteNome/{nome}")
    public List<ClienteDTO> buscarCliente(@PathVariable String nome){
        return clienteService.buscarCliente(nome);
    }

    @GetMapping("/buscarClienteId/{id}")
    public Optional<ClienteDTO> buscarClienteId(@PathVariable Integer id) {
        return clienteService.buscarClienteId(id);
    }
    @DeleteMapping("/deletarClente/{id}")
    public void deletarCliente(@PathVariable Integer id){
        clienteService.deletarCliente(id);
    }

    @PutMapping("atualizarCliente/{id}")
    public void atualizarCliente(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO){clienteService.atualizarCliente(id,clienteDTO);}

    @PutMapping("/alterarStatusCliente/{id}")
    public void alterarStatusCliente(@PathVariable Integer id){
        clienteService.alterarStatusCliente(id);
    }
}