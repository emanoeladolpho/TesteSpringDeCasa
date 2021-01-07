package com.decasa.teste.service;

import com.decasa.teste.domain.Lojista;
import com.decasa.teste.repository.LojistaRepository;
import com.decasa.teste.service.exceptions.LojistaExistenteException;
import com.decasa.teste.service.exceptions.LojistaNaoEncontradoException;
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
        if(lojista.getId() != null){
            Lojista l = lojistaRepository.findById(lojista.getId()).orElse(null);
            if(l != null){
              throw new LojistaExistenteException("Este lojista já existe!");
            }
        }
        return lojistaRepository.save(lojista);
    }

    public Lojista buscar(String nomeFantasia){
        Lojista lojista = lojistaRepository.findByNomeFantasia(nomeFantasia);
        if(lojista == null){
            throw new LojistaNaoEncontradoException("O lojista não pode ser econtrado!");
        }
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

    private void verificarExistencia(Lojista lojista){
        buscar(lojista.getNomeFantasia());
    }
}
