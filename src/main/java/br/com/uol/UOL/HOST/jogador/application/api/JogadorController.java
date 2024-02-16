package br.com.uol.UOL.HOST.jogador.application.api;

import br.com.uol.UOL.HOST.jogador.application.service.JogadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
}