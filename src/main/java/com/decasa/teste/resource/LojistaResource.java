package com.decasa.teste.resource;

import com.decasa.teste.domain.Lojista;
import com.decasa.teste.domain.Produto;
import com.decasa.teste.service.LojistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lojistas")
public class LojistaResource {

    @Autowired
    private LojistaService lojistaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Lojista>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(lojistaService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Lojista lojista){
        lojista = lojistaService.salvar(lojista);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(lojista.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public ResponseEntity<Lojista> buscarByNomeFantasia(@PathVariable String nome){
        Lojista lojista = lojistaService.buscarByNomeFantasia(nome);
        return ResponseEntity.status(HttpStatus.OK).body(lojista);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lojista> buscarById(@PathVariable Long id){
        Lojista lojista = lojistaService.buscarById(id);
        return ResponseEntity.status(HttpStatus.OK).body(lojista);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> buscarProdutos(@PathVariable("nomeFantasia") String nomeFantasia){
        List produtos =  lojistaService.buscarProdutos(nomeFantasia);
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Lojista lojista, @PathVariable("id") Long id){
        lojista.setId(id);
        lojistaService.atualizar(lojista);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        lojistaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}