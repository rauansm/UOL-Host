package br.com.uol.UOL.HOST.jogador.application.service;

import br.com.uol.UOL.HOST.codinome.application.service.CodinomeService;
import br.com.uol.UOL.HOST.codinome.domain.Codinome;
import br.com.uol.UOL.HOST.jogador.application.api.JogadorReponse;
import br.com.uol.UOL.HOST.jogador.application.api.JogadorRequest;
import br.com.uol.UOL.HOST.jogador.application.repository.JogadorRepository;
import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class JogadorApplicationService implements JogadorService {

    private final JogadorRepository jogadorRepository;
    private final CodinomeService codinomeService;

    @Override
    public JogadorReponse criaJogador(JogadorRequest jogadorRequest)  {
        log.info("[inicia] JogadorApplicationService - criaJogador");
        List<String> codinomesEmUso = jogadorRepository.buscaTodosCodinomesDoGrupo(jogadorRequest.getGrupo());
        Codinome codinome = codinomeService.buscaCodinomeDisponivel(codinomesEmUso,jogadorRequest.getGrupo());
        Jogador jogador = jogadorRepository.salva(new Jogador(jogadorRequest,codinome));
        log.info("[finaliza] JogadorApplicationService - criaJogador");
        return new JogadorReponse(jogador);
    }

    @Override
    public List<JogadorReponse> listaTodosJogadores() {
        log.info("[inicia] JogadorApplicationService - listaTodosJogadores");
        List<Jogador> jogadores = jogadorRepository.buscaTodosJogadores();
        log.info("[finaliza] JogadorApplicationService - listaTodosJogadores");
        return JogadorReponse.converte(jogadores);
    }
}
