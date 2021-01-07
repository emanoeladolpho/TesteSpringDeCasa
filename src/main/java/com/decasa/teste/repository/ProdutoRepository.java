package com.decasa.teste.repository;

import com.decasa.teste.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Produto findByNome(String nome);

    @Query (value = "SELECT * FROM Produto WHERE PRECO_UNITARIO = ?1", nativeQuery = true)
    Produto findByPrecoUnitario(Double precoUnitario);
}
