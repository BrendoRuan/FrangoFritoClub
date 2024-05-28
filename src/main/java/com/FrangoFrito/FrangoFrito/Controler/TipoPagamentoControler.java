package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Dto.CategoriaDTO;
import com.FrangoFrito.FrangoFrito.Dto.TipoPagamentoDTO;
import com.FrangoFrito.FrangoFrito.Service.CategoriaService;
import com.FrangoFrito.FrangoFrito.Service.TipoPagamentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TipoPagamentoControler {
    private TipoPagamentoService tipoPagamentoService;
    public TipoPagamentoControler(TipoPagamentoService tipoPagamentoService){this.tipoPagamentoService=tipoPagamentoService;}

    @PostMapping("/cadastrarTipoPagamento")
    public void cadastrarTipoPagamento(@Valid @RequestBody TipoPagamentoDTO tipoPagamentoDTO){
        tipoPagamentoService.cadastrarTipoPagamento(tipoPagamentoDTO);
    }

    @GetMapping("/listarTipoPagamento")
    public List<TipoPagamentoDTO> listarTipoPagamento(){
        return tipoPagamentoService.listarTipoPagamento();
    }

    /*@GetMapping("/buscarTipoPagamento/{nomeTipoPagamento}")
    public List<TipoPagamentoDTO>  buscarTipoPagamento(@PathVariable String nomeTipoPagamento){
        return tipoPagamentoService.buscarTipoPagamento(nomeTipoPagamento);
    }*/

    @GetMapping("/buscarTipoPagamentoId/{id}")
    public Optional<TipoPagamentoDTO> buscarTipoPagamentoId(@PathVariable Integer id){
        return tipoPagamentoService.buscarTipoPagamentoId(id);
    }
    @DeleteMapping("/deletarTipoPagamento/{id}")
    public void deletarTipoPagamento(@PathVariable Integer id){
        tipoPagamentoService.deletarTipoPagamento(id);
    }
    @PutMapping("atualizarTipoPagamento/{id}")
    public void atualizarTipoPagamento(@PathVariable Integer id, @Valid @RequestBody TipoPagamentoDTO tipoPagamentoDTO){
        tipoPagamentoService.atualizarTipoPagamento(id,tipoPagamentoDTO);}
    @PutMapping("/alterarStatusTipoPagamento/{id}")
    public void alterarStatusTipo(@PathVariable Integer id){
        tipoPagamentoService.alterarStatusTipo(id);
    }
}
