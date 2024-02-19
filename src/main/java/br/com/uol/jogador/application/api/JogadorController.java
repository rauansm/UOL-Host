package br.com.uol.jogador.application.api;

import br.com.uol.jogador.application.service.JogadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<JogadorReponse> listaTodosJogadores(Pageable pageable) {
        log.info("[inicia] JogadorController - listaTodosJogadores");
        Page<JogadorReponse> jogadores = jogadorService.listaTodosJogadores(pageable);
        log.info("[finaliza] JogadorController - listaTodosJogadores");
        return jogadores;
    }
}
