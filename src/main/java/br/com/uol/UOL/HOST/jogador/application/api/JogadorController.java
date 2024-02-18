package br.com.uol.UOL.HOST.jogador.application.api;

import br.com.uol.UOL.HOST.jogador.application.service.JogadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class JogadorController implements JogadorAPI {
    private final JogadorService jogadorService;
    @Override
    public JogadorReponse criaJogador(JogadorRequest jogadorRequest) {
        log.info("[inicia] JogadorController - criaJogador");
        JogadorReponse jogadorCriado = jogadorService.criaJogador(jogadorRequest);
        log.info("[finaliza] JogadorController - criaJogador");
        return jogadorCriado;
    }

    @Override
    public List<JogadorReponse> listaTodosJogadores() {
        log.info("[inicia] JogadorController - listaTodosJogadores");
        List<JogadorReponse> jogadores = jogadorService.listaTodosJogadores();
        log.info("[finaliza] JogadorController - listaTodosJogadores");
        return jogadores;
    }
}
