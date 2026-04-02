package br.com.criz.spring_boot_essentials.database.model;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProdutoEntity {

    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
