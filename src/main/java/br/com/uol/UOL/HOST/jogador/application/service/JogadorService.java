package br.com.uol.UOL.HOST.jogador.application.service;

import br.com.uol.UOL.HOST.jogador.application.api.JogadorReponse;
import br.com.uol.UOL.HOST.jogador.application.api.JogadorRequest;

import java.io.IOException;

public interface JogadorService {
    JogadorReponse criaJogador(JogadorRequest jogadorRequest) ;
}
