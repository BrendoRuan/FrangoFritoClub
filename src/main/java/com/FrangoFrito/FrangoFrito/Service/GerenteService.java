package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Entity.Gerente;
import com.FrangoFrito.FrangoFrito.Repository.GerenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {
    private GerenteRepository gerenteRepository;
    public GerenteService(GerenteRepository gerenteRepository){
        this.gerenteRepository = gerenteRepository;
    }

    //Metodo para Cadastrar um Gerente
    public void cadastrarGerente(Gerente gerente) {
        gerenteRepository.save(gerente);
    }
    //Metodo para Fazer uma Listagem dos Gerente
    public List<Gerente> listarGerente() {
        return gerenteRepository.findAll();
    }

    //Metodo para Deletar um Gerente pelo Id
    public void deletarGerente(Integer id) {
        gerenteRepository.deleteById(id);
    }
    //Metodo para Buscar um Gerente
    public Gerente buscarGerente(String nome) {
        return gerenteRepository.findByNome(nome);
    }
    //Metodo para alterar o status do Gerente
    public Gerente alterarStatusGerente(Integer id){
        Gerente gerente =  gerenteRepository.findById(id).orElse(null);
        if (gerente != null){
            gerente.setStatus(!gerente.isStatus());
            gerenteRepository.save(gerente);
        }
        return gerente;
    }
}
