package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Dto.ClienteDTO;
import com.FrangoFrito.FrangoFrito.Dto.TipoPagamentoDTO;
import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import com.FrangoFrito.FrangoFrito.Entity.TipoPagamento;
import com.FrangoFrito.FrangoFrito.Repository.TipoPagamentoRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPagamentoService {
    private TipoPagamentoRepository tipoPagamentoRepository;
    private TipoPagamento tipoPagamento;
    private ModelMapper modelMapper;

    public void cadastrarTipoPagamento(@Valid TipoPagamentoDTO tipoPagamentoDTO) {
        TipoPagamento tipoPagamento = modelMapper.map(tipoPagamentoDTO, TipoPagamento.class);
        tipoPagamentoRepository.save(tipoPagamento);

    }
    //Metodo para Buscar uma categoria
    /*public List<TipoPagamentoDTO> buscarTipoPagamento(String nomeTipoPagamento) {
        List<TipoPagamento> tipoPagamento =  tipoPagamentoRepository. findByNomeTipoPagamentoContainingIgnoreCase(nomeTipoPagamento);
        return tipoPagamento.stream().map(TipoPagamentoDTO::new).toList();
    }*/

    //Metodo para Buscar um Categoria pelo Id
    public Optional<TipoPagamentoDTO> buscarTipoPagamentoId(Integer id) {
        Optional<TipoPagamento> tipoPagamento = tipoPagamentoRepository.findById(id);
        return tipoPagamento.map(cliente1 -> modelMapper.map(tipoPagamento,TipoPagamentoDTO.class));


    }
    //Metodo para Deletar uma categoria pelo Id
    public void deletarTipoPagamento(Integer id) {
        tipoPagamentoRepository.deleteById(id);
    }

    //Metodo para Fazer uma Listagem das categoria
    public List<TipoPagamentoDTO> listarTipoPagamento() {
        List<TipoPagamento> tipoPagamentos = tipoPagamentoRepository.findAll();
        return tipoPagamentos.stream().map(TipoPagamentoDTO::new).toList();}
    //Metodo para alterar o status do Cliente

    //Metodo para atualizar categoria
    public void atualizarTipoPagamento(Integer id, @Valid TipoPagamentoDTO tipoPagamentoDTO){
        TipoPagamento tipoPagamento= modelMapper.map(tipoPagamentoDTO, TipoPagamento.class);
        tipoPagamento.setId(id);
        tipoPagamentoRepository.save(tipoPagamento);
    }
    //Metodo para alterar o status do Cliente
    public TipoPagamento alterarStatusTipo(Integer id){
        TipoPagamento tipoPagamento =  tipoPagamentoRepository.findById(id).orElse(null);
        if (tipoPagamento != null){
            tipoPagamento.setStatusTipoPagamento(!tipoPagamento.getStatusTipoPagamento());
            tipoPagamentoRepository.save(tipoPagamento);
        }
        return tipoPagamento;
    }
}
