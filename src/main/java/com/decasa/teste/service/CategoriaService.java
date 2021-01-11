package com.decasa.teste.service;

import com.decasa.teste.domain.Categoria;
import com.decasa.teste.repository.CategoriaRepository;
import com.decasa.teste.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
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
        return categoria;
    }

    public void atulizar(Categoria categoria){
        verificarExistencia(categoria);
        categoriaRepository.save(categoria);
    }

    public void deletar(Long id){
        Categoria categoria = new Categoria();
        categoria.setId(id);
        // AINDA PRECISA DELETAR TOOS OS PRODUTOS DA CATEGORIA QUANDO FOR DELETAR A CATEGORIA
        categoriaRepository.delete(categoria);
    }

    public void verificarExistencia(Categoria categoria){
        buscar(categoria.getId());
    }
}
