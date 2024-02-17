package br.com.uol.UOL.HOST.jogador.infra;

import br.com.uol.UOL.HOST.jogador.application.repository.JogadorRepository;
import br.com.uol.UOL.HOST.jogador.domain.Grupo;
import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class JogadorInfraRepository implements JogadorRepository {
    private final JogadorSpringDataJPA jogadorSpringDataJPA;

    @Override
    public Jogador salva(Jogador jogador) {
        log.info("[inicia] JogadorInfraRepository - salva");
        Jogador jogadorSalvo = jogadorSpringDataJPA.save(jogador);
        log.info("[finaliza] JogadorInfraRepository - salva");
        return jogadorSalvo;
    }

    @Override
    public List<String> buscaTodosCodinomesDoGrupo(Grupo grupo) {
        log.info("[inicia] JogadorInfraRepository - buscaTodosCodinomesDoGrupo");
        List<String> codinomes = jogadorSpringDataJPA.buscaCodinomes(grupo);
        log.info("[finaliza] JogadorInfraRepository - buscaTodosCodinomesDoGrupo");
        return codinomes;
    }
}
