package com.decasa.teste.repository;

import com.decasa.teste.domain.Lojista;
import com.decasa.teste.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Produto findByNome(String nome);

    @Query(value = "SELECT * FROM PRODUTO ORDER BY PRECO_UNITARIO ASC", nativeQuery = true)
    List<Produto> findAllOrderByPreco();

    @Query (value = "SELECT * FROM Produto WHERE PRECO_UNITARIO = ?1", nativeQuery = true)
    Produto findByPrecoUnitario(Double precoUnitario);

    @Query(value = "SELECT * FROM Produto WHERE LOJISTA_ID = ?1", nativeQuery = true)
    List<Produto> findByLojista(Long id);

    @Query(value = "SELECT * FROM Produto WHERE CATEGORIA_ID = ?1", nativeQuery = true)
    List<Produto> findByCategoria(Long id);

//    @Query(value = "DELETE FROM PRODUTO WHERE LOJISTA_ID = ?1",nativeQuery = true)
//    void deleteAllByLojista_Id(Long id);

    void deleteAllByLojista(Lojista lojista);
}
