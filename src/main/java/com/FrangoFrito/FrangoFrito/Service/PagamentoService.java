package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Entity.Pagamento;
import com.FrangoFrito.FrangoFrito.Repository.PagamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    private static final Logger logger = LoggerFactory.getLogger(PagamentoService.class);

    private PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository){
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento criarPagamento(Pagamento pagamento) {
        logger.info("Criando pagamento para {}", pagamento.getNomePagador());
        pagamento.setDataPagamento(LocalDateTime.now());

        // Simulação de integração com um serviço externo
        if (!chamarServicoExternoPagamento(pagamento)) {
            logger.error("Falha ao processar pagamento externo para {}", pagamento.getNomePagador());
            throw new RuntimeException("Erro ao processar pagamento externo");
        }

        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> obterTodosPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> obterPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    public void deletarPagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }

    private boolean chamarServicoExternoPagamento(Pagamento pagamento) {
        RestTemplate restTemplate = new RestTemplate();
        String urlServicoExterno = "http://servico-externo/api/pagamentos"; // Simulação
        try {
            restTemplate.postForEntity(urlServicoExterno, pagamento, String.class);
            return true;
        } catch (Exception e) {
            logger.error("Erro ao chamar serviço externo: {}", e.getMessage());
            return false;
        }
    }
}
