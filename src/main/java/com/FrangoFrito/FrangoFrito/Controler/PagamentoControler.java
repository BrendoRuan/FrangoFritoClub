package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Entity.Pagamento;
import com.FrangoFrito.FrangoFrito.Service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
@Validated
public class PagamentoControler {

    private PagamentoService pagamentoServico;

    @PostMapping
    public ResponseEntity<Pagamento> criarPagamento(@Valid @RequestBody Pagamento pagamento) {
        Pagamento pagamentoCriado = pagamentoServico.criarPagamento(pagamento);
        return ResponseEntity.ok(pagamentoCriado);
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> obterTodosPagamentos() {
        List<Pagamento> pagamentos = pagamentoServico.obterTodosPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> obterPagamentoPorId(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoServico.obterPagamentoPorId(id);
        return pagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Long id) {
        pagamentoServico.deletarPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
