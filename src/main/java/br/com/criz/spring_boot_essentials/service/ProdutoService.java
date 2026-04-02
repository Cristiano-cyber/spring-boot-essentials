package br.com.criz.spring_boot_essentials.service;

import br.com.criz.spring_boot_essentials.database.model.ProdutoEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = List.of(
            new ProdutoEntity(1, "Produto 1", new java.math.BigDecimal("10.00"), 100),
            new ProdutoEntity(2, "Produto 2", new java.math.BigDecimal("20.00"), 200),
            new ProdutoEntity(3, "Produto 3", new java.math.BigDecimal("30.00"), 300)

    );

    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

}
