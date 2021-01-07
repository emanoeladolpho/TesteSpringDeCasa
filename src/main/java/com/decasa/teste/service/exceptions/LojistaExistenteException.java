package com.decasa.teste.service.exceptions;

public class LojistaExistenteException extends RuntimeException {

    public LojistaExistenteException(String menssagem){
        super(menssagem);
    }

    public LojistaExistenteException(String menssagem, Throwable causa){
        super(menssagem,causa);
    }
}
