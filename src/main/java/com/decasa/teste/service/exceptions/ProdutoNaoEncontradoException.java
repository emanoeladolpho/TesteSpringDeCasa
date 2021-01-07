package com.decasa.teste.service.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {

    public ProdutoNaoEncontradoException(String menssagem, Throwable causa){
        super(menssagem,causa);
    }

    public ProdutoNaoEncontradoException(String menssagem){
        super(menssagem);
    }
}
