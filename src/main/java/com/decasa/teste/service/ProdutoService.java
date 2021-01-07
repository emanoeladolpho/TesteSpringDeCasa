package com.decasa.teste.service;

import com.decasa.teste.domain.Produto;
import com.decasa.teste.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto buscarById(Long id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        return produto;
    }

    public Produto buscarByNome(String nome){
        Produto produto = produtoRepository.findByNome(nome);
        return produto;
    }

    public Produto salvar(Produto produto){
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public void atualizar(Produto produto){
        produtoRepository.save(produto);
    }

    public void deletar (Long id){
        Produto produto = new Produto();
        produto.setId(id);
        produtoRepository.delete(produto);
    }
}
