package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.FrangoFrito.FrangoFrito.Dto.ClienteDTO;
import com.FrangoFrito.FrangoFrito.Entity.Categoria;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Repository.ClienteRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private Cliente cliente;
    @Autowired
    ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Metodo para Cadastrar uma Categoria
    public void cadastrarCliente(@Valid ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);

    }
    //Metodo para Buscar uma categoria
    public List<ClienteDTO> buscarCliente(String nome) {
        List<Cliente> cliente =  clienteRepository.findByNomeContainingIgnoreCase(nome);
        return cliente.stream().map(ClienteDTO::new).toList();
    }

    //Metodo para Buscar um Categoria pelo Id
    public Optional<ClienteDTO> buscarClienteId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(cliente1 -> modelMapper.map(cliente,ClienteDTO.class));


    }
    //Metodo para Deletar uma categoria pelo Id
    public void deletarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem das categoria
    public List<ClienteDTO> listarCliente() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteDTO::new).toList();}
    //Metodo para alterar o status do Cliente

    //Metodo para atualizar categoria
    public void atualizarCliente(Integer id, @Valid ClienteDTO clienteDTO){
        Cliente cliente= modelMapper.map(clienteDTO, Cliente.class);
        cliente.setId(id);
        clienteRepository.save(cliente);
    }
    //Metodo para alterar o status do Cliente
    public Cliente alterarStatusCliente(Integer id){
        Cliente cliente =  clienteRepository.findById(id).orElse(null);
        if (cliente != null){
            cliente.setStatusCliente(!cliente.getStatusCliente());
            clienteRepository.save(cliente);
        }
        return cliente;
    }
}