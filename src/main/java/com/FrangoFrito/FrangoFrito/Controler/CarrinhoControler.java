package com.FrangoFrito.FrangoFrito.Controler;

import com.FrangoFrito.FrangoFrito.Entity.CarrinhoCompra;
import com.FrangoFrito.FrangoFrito.Entity.ItemVenda;
import com.FrangoFrito.FrangoFrito.Service.CarrinhoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarrinhoControler {
    CarrinhoService carrinhoService;

    public CarrinhoControler(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    // Método para listar todos os itens do carrinho
    @GetMapping("/listarItensDoCarrinho")
    public CarrinhoCompra listarItensDoCarrinho() {
        // Cria um novo objeto CarrinhoCompra
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();
        // Obtém a lista de itens do carrinho através do serviço carrinhoService
        List<ItemVenda> itens = carrinhoService.listarItensDoCarrinho();
        // Define os itens do carrinho no objeto carrinhoCompra
        carrinhoCompra.setItens(carrinhoService.listarItensDoCarrinho());
        // Define o total do carrinho calculando o valor dos itens
        carrinhoCompra.setTotal(carrinhoService.calcularValorItens());
        // Retorna o objeto carrinhoCompra
        return carrinhoCompra;
    }

    // Método para listar uma cópia dos itens do carrinho
    @GetMapping("/listarItensDoCarrinhoCopia")
    public CarrinhoCompra listarItensDoCarrinhoCopia() {
        // Cria um novo objeto CarrinhoCompra
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();
        // Obtém a lista de itens do carrinho através do serviço carrinhoService
        List<ItemVenda> itens = carrinhoService.listarItensDoCarrinho();
        // Define os itens do carrinho no objeto carrinhoCompra
        carrinhoCompra.setItens(carrinhoService.listarItensDoCarrinho());
        // Define o total do carrinho calculando o valor dos itens
        carrinhoCompra.setTotal(carrinhoService.calcularValorItens());
        // Retorna o objeto carrinhoCompra
        return carrinhoCompra;
    }

    // Método para adicionar um produto ao carrinho pelo ID
    @PostMapping("/adicionarItemAoCarrinho/{id}")
    public void adicionarProdutoAoCarrinho(@PathVariable Integer id) {
        // Chama o serviço carrinhoService para adicionar o produto ao carrinho
        carrinhoService.adicionarProdutoAoCarrinho(id);
    }

    // Método para remover um produto do carrinho pelo ID
    @DeleteMapping("/removerItemDoCarrinho/{id}")
    public void removerProdutoDoCarrinho(@PathVariable Integer id) {
        // Chama o serviço carrinhoService para remover o produto do carrinho
        carrinhoService.removeProdutoDoCarrinho(id);
    }

    // Método para remover todos os produtos do carrinho
    @DeleteMapping("/removerTodosOsItensDoCarrinho")
    public void removerTodosProdutosDoCarrinho() {
        // Chama o serviço carrinhoService para remover todos os produtos do carrinho
        carrinhoService.removerTodosProdutosDoCarrinho();
    }

    // Método para aumentar a quantidade de um produto no carrinho pelo ID
    @PostMapping("/aumentarItemNoCarrinho/{id}")
    public void aumentarQuantidadeDoProdutoNoCarrinho(@PathVariable Integer id) {
        // Chama o serviço carrinhoService para aumentar a quantidade do produto no carrinho
        carrinhoService.aumentarQuantidadeDoProdutoNoCarrinho(id);
    }

    // Método para diminuir a quantidade de um produto no carrinho pelo ID
    @PostMapping("/diminuirItemNoCarrinho/{id}")
    public void diminuirQuantidadeDoProdutoNoCarrinho(@PathVariable Integer id) {
        // Chama o serviço carrinhoService para diminuir a quantidade do produto no carrinho
        carrinhoService.diminuirQuantidadeDoProdutoNoCarrinho(id);
    }
}