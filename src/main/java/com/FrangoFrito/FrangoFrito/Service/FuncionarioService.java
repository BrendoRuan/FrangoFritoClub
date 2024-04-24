package com.FrangoFrito.FrangoFrito.Service;
import com.FrangoFrito.FrangoFrito.Entity.Funcionario;
import com.FrangoFrito.FrangoFrito.Repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }
    //Metodo para Cadastrar um Funcionario
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    //Metodo para Buscar um Funcionario
    public Funcionario buscarFuncionario(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    //Metodo para Deletar um Funcionario pelo Id
    public void deletarFuncionario(Integer id) {
        funcionarioRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem dos Funcionarios
    public List<Funcionario> listarFuncionario() {
        return funcionarioRepository.findAll();
    }
    //Metodo para alterar o status do Funcionario
    public Funcionario alterarStatusFuncionario(Integer id){
        Funcionario funcionario =  funcionarioRepository.findById(id).orElse(null);
        if (funcionario != null){
            funcionario.setStatus(!funcionario.isStatus());
            funcionarioRepository.save(funcionario);
        }
        return funcionario;
    }
}
