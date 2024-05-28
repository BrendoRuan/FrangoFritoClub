package com.FrangoFrito.FrangoFrito.Service;
import com.FrangoFrito.FrangoFrito.Dto.ClienteDTO;
import com.FrangoFrito.FrangoFrito.Dto.FuncionarioDTO;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Entity.Funcionario;
import com.FrangoFrito.FrangoFrito.Repository.ClienteRepository;
import com.FrangoFrito.FrangoFrito.Repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;
    private Funcionario funcionario;
    @Autowired
    ModelMapper modelMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){this.funcionarioRepository=funcionarioRepository;}

    //Metodo para Cadastrar uma Categoria
    public void cadastrarFuncionario(@Valid FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = modelMapper.map(funcionarioDTO, Funcionario.class);
        funcionarioRepository.save(funcionario);

    }
    //Metodo para Buscar uma categoria pelo nome
    public List<FuncionarioDTO> buscarFuncionarioNome(String nome) {
        List<Funcionario> funcionario =  funcionarioRepository.findByNomeContainingIgnoreCase(nome);
        return funcionario.stream().map(FuncionarioDTO::new).toList();
    }

    //Metodo para Buscar um Categoria pelo Id
    public Optional<FuncionarioDTO> buscarFuncionarioId(Integer id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.map(funcionario1 -> modelMapper.map(funcionario,FuncionarioDTO.class));


    }
    //Metodo para Deletar uma categoria pelo Id
    public void deletarFuncionario(Integer id) {
        funcionarioRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem das categoria
    public List<FuncionarioDTO> listarFuncionario() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(FuncionarioDTO::new).toList();}
    //Metodo para alterar o status do Cliente

    //Metodo para atualizar categoria
    public void atualizarFuncionario(Integer id, @Valid FuncionarioDTO funcionarioDTO){
        Funcionario funcionario= modelMapper.map(funcionarioDTO, Funcionario.class);
        funcionario.setId(id);
        funcionarioRepository.save(funcionario);
    }
    /*    public void atualizarCliente(Integer id, @Valid ClienteDTO clienteDTO){
        Cliente cliente= modelMapper.map(clienteDTO, Cliente.class);
        cliente.setId(id);
        clienteRepository.save(cliente);
    }*/

    //Metodo para alterar o status do Funcionario
    public Funcionario alterarStatusFuncionario(Integer id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario != null) {
            funcionario.setStatusFuncionario(!funcionario.getStatusFuncionario());
            funcionarioRepository.save(funcionario);
        }
        return funcionario;
  }

}
