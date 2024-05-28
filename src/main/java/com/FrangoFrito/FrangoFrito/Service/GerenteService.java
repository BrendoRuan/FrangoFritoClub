package com.FrangoFrito.FrangoFrito.Service;
import com.FrangoFrito.FrangoFrito.Dto.GerenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import com.FrangoFrito.FrangoFrito.Entity.Gerente;
import com.FrangoFrito.FrangoFrito.Repository.GerenteRepository;
import org.springframework.stereotype.Service;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository gerenteRepository;

    public GerenteDTO cadastrarGerente(GerenteDTO gerenteDTO) {
        Gerente gerente = new Gerente();
        BeanUtils.copyProperties(gerenteDTO, gerente);
        gerente = gerenteRepository.save(gerente);
        BeanUtils.copyProperties(gerente, gerenteDTO);
        return gerenteDTO;
    }

    public List<GerenteDTO> listarGerente() {
        List<Gerente> gerentes = gerenteRepository.findAll();
        return gerentes.stream().map(gerente -> {
                    GerenteDTO gerenteDTO = new GerenteDTO();
                    BeanUtils.copyProperties(gerente, gerenteDTO);
                    return gerenteDTO;
                })
                .collect(Collectors.toList());
    }

    public GerenteDTO buscarPorId(Integer id) {
        Gerente gerente = gerenteRepository.findById(id).orElse(null);
        if (gerente == null) {
            return null;
        }
        GerenteDTO gerenteDTO = new GerenteDTO();
        BeanUtils.copyProperties(gerente, gerenteDTO);
        return gerenteDTO;
    }

    public GerenteDTO buscarGerentePorNome(String nome) {
        Gerente gerente = gerenteRepository.findByNome(nome);
        if (gerente == null) {
            return null;
        }
        GerenteDTO gerenteDTO = new GerenteDTO();
        BeanUtils.copyProperties(gerente, gerenteDTO);
        return gerenteDTO;
    }

    public GerenteDTO atualizarGerente(Integer id, GerenteDTO gerenteDTO) {
        Gerente gerente = gerenteRepository.findById(id).orElse(null);
        if (gerente == null) {
            return null;
        }
        BeanUtils.copyProperties(gerenteDTO, gerente);
        gerente.setId(id);
        gerente = gerenteRepository.save(gerente);
        BeanUtils.copyProperties(gerente, gerenteDTO);
        return gerenteDTO;
    }

    public void deletarGerente(Integer id) {
        gerenteRepository.deleteById(id);
    }
    //Metodo para alterar o status do Gerente
    public Gerente alterarStatusGerente(Integer id){
        Gerente gerente =  gerenteRepository.findById(id).orElse(null);
        if (gerente != null){
            gerente.setstatusGerente(!gerente.getstatusGerente());
            gerenteRepository.save(gerente);
        }
        return gerente;
    }




   /* private GerenteRepository gerenteRepository;
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
    }*/
}
