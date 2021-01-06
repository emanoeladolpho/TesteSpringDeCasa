package com.decasa.teste.repository;

import com.decasa.teste.domain.Lojista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojistaRepository extends JpaRepository<Lojista,Long>{

    Lojista findByNomeFantasia (String nomeFantasia);
}
