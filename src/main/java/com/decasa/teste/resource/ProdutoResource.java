package com.decasa.teste.resource;

import com.decasa.teste.domain.Produto;
import com.decasa.teste.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listar());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> buscar(@PathVariable Long id){
        Produto produto = produtoService.buscarById(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
    public ResponseEntity<Produto> buscarByNome(@PathVariable String nome){
        Produto produto = produtoService.buscarByNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @RequestMapping(value = "/listarPreco", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> listarOrdemCrescente(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarOrdemCrescente());
    }

    @RequestMapping(value = "/preco/{precoUnitario}", method = RequestMethod.GET)
    public ResponseEntity<Produto> buscarPorPreco(@PathVariable("precoUnitario") Double precoUnitario){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarPorPreco(precoUnitario));
    }

    @RequestMapping(value = "/lojista/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> buscarPorLojista(@PathVariable("id") Long idLojista){
        List<Produto> produtos = produtoService.buscarByLojista(idLojista);
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> buscarByCategoria(@PathVariable("id") Long id){
        List<Produto> produtos = produtoService.buscarByCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Produto produto){
        produto = produtoService.salvar(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Produto produto, @PathVariable("id") Long id){
        produto.setId(id);
        produtoService.atualizar(produto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}