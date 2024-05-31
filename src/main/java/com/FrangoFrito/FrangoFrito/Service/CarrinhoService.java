package com.FrangoFrito.FrangoFrito.Service;

import com.FrangoFrito.FrangoFrito.Dto.ProdutoDTO;
import com.FrangoFrito.FrangoFrito.Entity.ItemVenda;
import com.FrangoFrito.FrangoFrito.Entity.Produto;
import com.FrangoFrito.FrangoFrito.Repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarrinhoService {
    ProdutoRepository produtoRepository;
    ModelMapper modelMapper;

    private final List<ItemVenda> itens = new ArrayList<>();

    public CarrinhoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    // Método para adicionar um produto ao carrinho pelo ID
    public void adicionarProdutoAoCarrinho(Integer id) {
        // Busca o produto pelo ID no repositório. Se não for encontrado, lança uma exceção
        Produto produto = produtoRepository.findById(id).orElseThrow();
        // Converte o objeto Produto em ProdutoDTO
        ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);

        // Percorre a lista de itens no carrinho
        for (ItemVenda item : itens) {
            // Se o produto já estiver no carrinho, incrementa a quantidade
            if (item.getProdutoDTO().getId().equals(produto.getId())) {
                item.setQuantidadeDoItem(item.getQuantidadeDoItem() + 1);
                // Atualiza o subtotal do item
                item.setSubTotal(item.getQuantidadeDoItem() * produtoDTO.getValorDeVenda());
                return; // Sai do método após atualizar o item existente
            }
        }

        // Se o produto não estiver no carrinho, cria um novo item de venda
        ItemVenda novoItem = new ItemVenda();
        novoItem.setProdutoDTO(produtoDTO);
        novoItem.setQuantidadeDoItem(1);
        novoItem.setSubTotal(produtoDTO.getValorDeVenda());
        // Adiciona o novo item à lista de itens no carrinho
        itens.add(novoItem);
    }

    // Método para remover um produto do carrinho pelo ID
    public void removeProdutoDoCarrinho(Integer id) {
        // Percorre a lista de itens no carrinho
        for (int i = 0; i < itens.size(); i++) {
            ItemVenda item = itens.get(i);
            // Se a quantidade do item for maior que 1, decrementa a quantidade
            if (item.getQuantidadeDoItem() > 1) {
                item.setQuantidadeDoItem(item.getQuantidadeDoItem() - 1);
                // Atualiza o subtotal do item
                item.setSubTotal(item.getQuantidadeDoItem() * item.getProdutoDTO().getValorDeVenda());
            } else {
                // Se a quantidade do item for 1, remove o item do carrinho
                itens.remove(i);
            }
            calcularValorItens(); // Recalcula o valor total dos itens no carrinho
            break; // Sai do loop após encontrar e processar o item
        }
    }

    // Método para remover todos os produtos do carrinho
    public void removerTodosProdutosDoCarrinho() {
        itens.clear(); // Remove todos os itens do carrinho
        calcularValorItens(); // Recalcula o valor total dos itens no carrinho
    }

    // Método para aumentar a quantidade de um produto no carrinho pelo ID
    public void aumentarQuantidadeDoProdutoNoCarrinho(Integer id) {
        // Percorre a lista de itens no carrinho
        for (ItemVenda item : itens) {
            // Se encontrar o produto, incrementa a quantidade
            if (item.getProdutoDTO().getId().equals(id)) {
                item.setQuantidadeDoItem(item.getQuantidadeDoItem() + 1);
                calcularValorItens(); // Recalcula o valor total dos itens no carrinho
                return; // Sai do método após encontrar e processar o item
            }
        }
    }

    // Método para diminuir a quantidade de um produto no carrinho pelo ID
    public void diminuirQuantidadeDoProdutoNoCarrinho(Integer id) {
        // Percorre a lista de itens no carrinho
        for (ItemVenda item : itens) {
            // Se encontrar o produto, verifica a quantidade
            if (item.getProdutoDTO().getId().equals(id)) {
                // Se a quantidade for maior que 1, decrementa a quantidade
                if (item.getQuantidadeDoItem() > 1) {
                    item.setQuantidadeDoItem(item.getQuantidadeDoItem() - 1);
                }
                calcularValorItens(); // Recalcula o valor total dos itens no carrinho
                return; // Sai do método após encontrar e processar o item
            }
        }
    }

    // Método para listar todos os itens do carrinho
    public List<ItemVenda> listarItensDoCarrinho() {
        return itens; // Retorna a lista de itens no carrinho
    }

    // Método para listar uma cópia dos itens do carrinho
    public List<ItemVenda> listarItensDoCarrinhoCopia() {
        return Collections.unmodifiableList(itens); // Retorna uma lista não modificável dos itens no carrinho
    }

    // Método para calcular o valor total dos itens no carrinho
    public double calcularValorItens() {
        double valorItens = 0.0;

        // Percorre a lista de itens no carrinho
        for (ItemVenda item : itens) {
            // Soma o valor de cada item (quantidade * valor de venda)
            valorItens += item.getQuantidadeDoItem() * item.getProdutoDTO().getValorDeVenda();
        }

        return valorItens; // Retorna o valor total dos itens no carrinho
    }
}