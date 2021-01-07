package com.decasa.teste;

import com.decasa.teste.domain.Produto;
import com.decasa.teste.service.LojistaService;
import com.decasa.teste.service.ProdutoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteApplication.class, args);
//        ProdutoService teste = new ProdutoService();
//        System.out.println(teste.buscarPorPreco(10.00));
    }
}
