package br.com.uol.UOL.HOST.jogador.application.repository;

import br.com.uol.UOL.HOST.jogador.domain.Grupo;
import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JogadorRepository {
    Jogador salva(Jogador jogador);

    List<String> buscaTodosCodinomesDoGrupo(Grupo grupo);

    Page<Jogador> buscaTodosJogadores(Pageable pageable);
}
