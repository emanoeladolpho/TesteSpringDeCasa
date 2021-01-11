package com.decasa.teste.service;

import com.decasa.teste.domain.Categoria;
import com.decasa.teste.repository.CategoriaRepository;
import com.decasa.teste.repository.ProdutoRepository;
import com.decasa.teste.service.exceptions.CategoriaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria buscar(Long id){
        Categoria categoria  = categoriaRepository.findById(id).orElse(null);
        if(categoria == null){
            throw new CategoriaNaoEncontradaException("A categoria não pôde ser encontrada!");
        }
        return categoria;
    }

    public void atulizar(Categoria categoria){
        verificarExistencia(categoria);
        categoriaRepository.save(categoria);
    }

    @Transactional
    public void deletar(Long id){
        Categoria categoria = new Categoria();
        categoria.setId(id);
        verificarExistencia(categoria);
        try{
            produtoRepository.deleteAllByCategoria(categoria);
            categoriaRepository.delete(categoria);
        }catch(Exception e){
            throw new CategoriaNaoEncontradaException("A categoria não pode ser encontrada!");
        }
    }

    public void verificarExistencia(Categoria categoria){
        buscar(categoria.getId());
    }
}