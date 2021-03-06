package com.decasa.teste.service;

import com.decasa.teste.domain.Categoria;
import com.decasa.teste.domain.Produto;
import com.decasa.teste.domain.dto.ProdutoDTO;
import com.decasa.teste.repository.CategoriaRepository;
import com.decasa.teste.repository.ProdutoRepository;
import com.decasa.teste.service.exceptions.CategoriaNaoEncontradaException;
import com.decasa.teste.service.exceptions.ProdutoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Produto> listar(){
        if(produtoRepository == null){
            System.out.println("Lista vazia");
            return null;
        }
        return produtoRepository.findAll();
    }

    public Produto buscarById(Long id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if(produto == null){
            throw new ProdutoNaoEncontradoException("O Produto não pôde ser encontrado!");
        }
        return produto;
    }

    public Produto buscarByNome(String nome){
        return produtoRepository.findByNome(nome);
    }

    public Produto salvar(Produto produto){
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public void atualizar(Produto produto){
        verificarExistencia(produto);
        produtoRepository.save(produto);
    }

    public void deletar (Long id){
        Produto produto = new Produto();
        produto.setId(id);
        verificarExistencia(produto);
        try{
            produtoRepository.delete(produto);
        }catch (EmptyResultDataAccessException e){
            throw new ProdutoNaoEncontradoException("O livro não pôde ser encontrado!");
        }
    }

    public List<Produto> listarOrdemCrescente(){
        List<Produto> produtos = produtoRepository.findAllOrderByPreco();
        if(produtos == null){
            throw new ProdutoNaoEncontradoException("Não há produtos cadastrados!");
        }
        return produtos;
    }

    public Produto buscarPorPreco(Double precoUnitario){
        Produto produto = produtoRepository.findByPrecoUnitario(precoUnitario);
        if(produto == null){
            throw new ProdutoNaoEncontradoException("O produto não pôde ser encontrado!");
        }
        return produto;
    }

    public List<Produto> buscarByLojista(Long id){
        List<Produto> produtos = produtoRepository.findByLojista(id);
        if(produtos == null){
            throw new ProdutoNaoEncontradoException("O produto não pôde ser encontrado!");
        }
        return produtos;
    }

    // QUANDO A CATEOGIRA NAO EXSTE TÁ RETORNANDO ERRO 500 AO INVÉS DE 404
    public List<Produto> buscarByCategoria(Long id){
        List<Produto> produtos = produtoRepository.findByCategoria(id);
        if(verificarExistenciaCategoria(id) == null){
            throw new CategoriaNaoEncontradaException("A categoria não pode ser encontrada!");
        }
        return produtos;
    }

    public ProdutoDTO getProdutoDto(Long id){
       Produto produto = produtoRepository.findById(id).orElse(null);
        ProdutoDTO produtoDto = new ProdutoDTO();
       if(produto != null){
           produtoDto.setNome(produto.getNome());
           produtoDto.setDescricao(produto.getDescricao());
           produtoDto.setPrecoUnitario(produto.getPrecoUnitario());
       }else{
           throw new ProdutoNaoEncontradoException("O produto não pôde ser encontrado!");
       }
       return produtoDto;
    }

    private void verificarExistencia(Produto produto){
        buscarById(produto.getId());
    }

    private Categoria verificarExistenciaCategoria(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }
}