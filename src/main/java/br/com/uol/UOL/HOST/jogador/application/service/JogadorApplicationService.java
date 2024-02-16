package br.com.uol.UOL.HOST.jogador.application.service;

import br.com.uol.UOL.HOST.jogador.application.api.JogadorReponse;
import br.com.uol.UOL.HOST.jogador.application.api.JogadorRequest;
import br.com.uol.UOL.HOST.jogador.application.repository.JogadorRepository;
import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class JogadorApplicationService implements JogadorService{
    private final JogadorRepository jogadorRepository;
    @Override
    public JogadorReponse criaJogador(JogadorRequest jogadorRequest) {
        log.info("[inicia] JogadorApplicationService - criaJogador");
        Jogador jogador = jogadorRepository.salva(new Jogador(jogadorRequest));
        log.info("[finaliza] JogadorApplicationService - criaJogador");
        return new JogadorReponse(jogador);
    }
}
