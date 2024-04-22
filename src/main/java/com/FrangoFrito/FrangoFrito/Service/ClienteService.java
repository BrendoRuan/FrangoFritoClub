package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Metodo para Cadastrar um Cliente
    public void cadastrarCliente(Cliente cliente) {
        //Aqui faz o relacionmento Bidirecional, referenciando a Pessoa ao Cliente depois Salva
        clienteRepository.save(cliente);
    }

    //Metodo para Buscar um Cliente
    public Cliente buscarCliente(String nome) {
        return clienteRepository.findByNome(nome);
    }

    //Metodo para Deletar um Cliente pelo Id
    public void deletarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem dos Clientes
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }
    public Cliente alterarStatus(Integer id){
        Cliente cliente =  clienteRepository.findById(id).orElse(null);
        if (cliente != null){
            cliente.setAtivo(!cliente.isAtivo());
            clienteRepository.save(cliente);
        }
        return cliente;
    }
}