package br.com.criz.spring_boot_essentials.service;

import br.com.criz.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.criz.spring_boot_essentials.dto.ProdutoDto;
import br.com.criz.spring_boot_essentials.exception.NotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>(List.of(
            new ProdutoEntity(1, "Produto 1", new java.math.BigDecimal("10.00"), 100),
            new ProdutoEntity(2, "Produto 2", new java.math.BigDecimal("20.00"), 200),
            new ProdutoEntity(3, "Produto 3", new java.math.BigDecimal("30.00"), 300)

    ));

    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoEntity createProduct(ProdutoDto produtoDto) {
        int newId = PRODUTOS.size() + 1;
        ProdutoEntity newProduto = new ProdutoEntity(newId, produtoDto.getNome(), produtoDto.getPreco(), produtoDto.getQuantidade());
        PRODUTOS.add(newProduto);
        return newProduto;

    }

    public ProdutoEntity updateProduct(ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() ->new NotFoundException("Produto não encontrado"));

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;

    }

    public void deleteProduct(Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }
}
