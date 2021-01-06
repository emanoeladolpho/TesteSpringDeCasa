package com.decasa.teste.resource;

import com.decasa.teste.domain.Lojista;
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
        Lojista lojista = lojistaService.buscar(nome);
        return ResponseEntity.status(HttpStatus.OK).body(lojista);
    }
}
