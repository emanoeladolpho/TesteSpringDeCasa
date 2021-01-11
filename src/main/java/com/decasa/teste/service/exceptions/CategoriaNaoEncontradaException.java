package com.decasa.teste.service.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException {

    public CategoriaNaoEncontradaException(String menssagem){
        super(menssagem);
    }

    public CategoriaNaoEncontradaException(String menssagem, Throwable causa){
        super(menssagem, causa);
    }
}
