package com.decasa.teste.service;

import com.decasa.teste.domain.Lojista;
import com.decasa.teste.repository.LojistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojistaService {

    @Autowired
    private LojistaRepository lojistaRepository;

    public List<Lojista> listar(){
        return lojistaRepository.findAll();
    }

    public Lojista salvar(Lojista lojista){
        return lojistaRepository.save(lojista);
    }

    public Lojista buscar(String nomeFantasia){
        Lojista lojista = lojistaRepository.findByNomeFantasia(nomeFantasia);
        return lojista;
    }

    public void atualizar(Lojista lojista){
        lojistaRepository.save(lojista);
    }

    public void deletar(Long id){
        Lojista lojista = new Lojista();
        lojista.setId(id);
        lojistaRepository.delete(lojista);
    }
}
