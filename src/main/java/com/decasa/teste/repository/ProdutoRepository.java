package com.decasa.teste.repository;

import com.decasa.teste.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Produto findByNome(String nome);
}
