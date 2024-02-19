package br.com.uol.jogador.application.service;

import br.com.uol.codinome.application.service.CodinomeService;
import br.com.uol.codinome.domain.Codinome;
import br.com.uol.jogador.application.api.JogadorReponse;
import br.com.uol.jogador.application.api.JogadorRequest;
import br.com.uol.jogador.application.repository.JogadorRepository;
import br.com.uol.jogador.domain.Jogador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<JogadorReponse> listaTodosJogadores(Pageable pageable) {
        log.info("[inicia] JogadorApplicationService - listaTodosJogadores");
        Page<Jogador> jogadores = jogadorRepository.buscaTodosJogadores(pageable);
        List<JogadorReponse> jogadoresListResponse = JogadorReponse.converte(jogadores);
        Page<JogadorReponse> jogadorPageResponse = new PageImpl<>(jogadoresListResponse,pageable, jogadores.getTotalElements());
        log.info("[finaliza] JogadorApplicationService - listaTodosJogadores");
        return jogadorPageResponse;
    }
}
