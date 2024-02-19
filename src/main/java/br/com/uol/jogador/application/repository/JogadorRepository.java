package br.com.uol.jogador.application.repository;

import br.com.uol.jogador.domain.Grupo;
import br.com.uol.jogador.domain.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JogadorRepository {
    Jogador salva(Jogador jogador);

    List<String> buscaTodosCodinomesDoGrupo(Grupo grupo);

    Page<Jogador> buscaTodosJogadores(Pageable pageable);
}
