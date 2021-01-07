package com.decasa.teste.service.exceptions;

public class LojistaNaoEncontradoException extends RuntimeException {

    public LojistaNaoEncontradoException(String menssagem, Throwable causa){
        super(menssagem,causa);
    }

    public LojistaNaoEncontradoException(String menssagem){
        super(menssagem);
    }

}
