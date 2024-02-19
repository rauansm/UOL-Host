package br.com.uol.UOL.HOST.jogador.infra;

import br.com.uol.UOL.HOST.handler.APIException;
import br.com.uol.UOL.HOST.jogador.application.repository.JogadorRepository;
import br.com.uol.UOL.HOST.jogador.domain.Grupo;
import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        try {
        jogadorSpringDataJPA.save(jogador);
        } catch (DataIntegrityViolationException e) {
        throw APIException.negocio(String.format("Já existe um jogador cadastrado com o email %s.", jogador.getEmail()));}
        log.info("[finaliza] JogadorInfraRepository - salva");
        return jogador;
    }

    @Override
    public List<String> buscaTodosCodinomesDoGrupo(Grupo grupo) {
        log.info("[inicia] JogadorInfraRepository - buscaTodosCodinomesDoGrupo");
        List<String> codinomes = jogadorSpringDataJPA.buscaCodinomes(grupo);
        log.info("[finaliza] JogadorInfraRepository - buscaTodosCodinomesDoGrupo");
        return codinomes;
    }

    @Override
    public Page<Jogador> buscaTodosJogadores(Pageable pageable) {
        log.info("[inicia] JogadorInfraRepository - buscaTodosJogadores");
        Page<Jogador> jogadores = jogadorSpringDataJPA.findAll(pageable);
        log.info("[finaliza] JogadorInfraRepository - buscaTodosJogadores");
        return jogadores;
    }
}
