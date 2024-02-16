package br.com.uol.UOL.HOST.jogador.infra;

import br.com.uol.UOL.HOST.jogador.application.repository.JogadorRepository;
import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
