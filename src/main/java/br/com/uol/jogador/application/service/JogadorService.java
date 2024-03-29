package br.com.uol.jogador.application.service;

import br.com.uol.jogador.application.api.JogadorReponse;
import br.com.uol.jogador.application.api.JogadorRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JogadorService {
    JogadorReponse criaJogador(JogadorRequest jogadorRequest) ;

    Page<JogadorReponse> listaTodosJogadores(Pageable pageable);
}
