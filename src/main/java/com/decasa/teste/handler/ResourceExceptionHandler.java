package com.decasa.teste.handler;

import com.decasa.teste.domain.DetalhesErro;
import com.decasa.teste.service.exceptions.LojistaExistenteException;
import com.decasa.teste.service.exceptions.LojistaNaoEncontradoException;
import com.decasa.teste.service.exceptions.ProdutoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice // permite que eu consiga interceptar todas as exceções que podem acontecer no código
public class ResourceExceptionHandler {
    // Essa classe vai ser um manipulador de exceções

    // Ao capturar a execeção, vai ser retornada uma resposta pro cliente na API
    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleProdutoNaoEncontradoException
    (ProdutoNaoEncontradoException e, HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("O Produto não pôde ser encontrado!");
        erro.setStatus(404L);
        erro.setTimestamp(System.currentTimeMillis()); //  pegar o tempo em milisegundos
        erro.setMenssagemDesenvolvedor("http://erros.teste.com/404");
        // O ideal é que exista uma página web com informações de todos os erros que possam ocorrer na API
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(LojistaExistenteException.class)
    public ResponseEntity<DetalhesErro> handleProdutoNaoEncontradoException
            (LojistaExistenteException e, HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("O lojista já existe!!");
        erro.setStatus(409L);
        erro.setTimestamp(System.currentTimeMillis()); //  pegar o tempo em milisegundos
        erro.setMenssagemDesenvolvedor("http://erros.teste.com/409");
        // O ideal é que exista uma página web com informações de todos os erros que possam ocorrer na API
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(LojistaNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleProdutoNaoEncontradoException
            (LojistaNaoEncontradoException e, HttpServletRequest request){

        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("O lojista não pode ser encontrado!");
        erro.setStatus(404L);
        erro.setTimestamp(System.currentTimeMillis()); //  pegar o tempo em milisegundos
        erro.setMenssagemDesenvolvedor("http://erros.teste.com/404");
        // O ideal é que exista uma página web com informações de todos os erros que possam ocorrer na API
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
