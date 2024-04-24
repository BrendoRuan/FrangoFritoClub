package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private Cliente cliente;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Metodo para Cadastrar um Cliente
    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    //Metodo para Buscar um Cliente
    public Cliente buscarCliente(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Optional<Cliente> buscarClienteId(Integer id) {
        return clienteRepository.findById(id);
    }

    //Metodo para Deletar um Cliente pelo Id
    public void deletarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem dos Clientes
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    public Cliente atualizarCliente(Integer id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente != null){
            cliente.setNome(cliente.getNome());
            return clienteRepository.save(cliente);
            }
        return cliente;
    }
    //Metodo para alterar o status do Cliente
    public Cliente alterarStatusCliente(Integer id){
        Cliente cliente =  clienteRepository.findById(id).orElse(null);
        if (cliente != null){
            cliente.setStatus(!cliente.isStatus());
            clienteRepository.save(cliente);
        }
        return cliente;
    }
}