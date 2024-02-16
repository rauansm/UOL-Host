package br.com.uol.UOL.HOST.jogador.infra;

import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogadorSpringDataJPA extends JpaRepository<Jogador, UUID> {
}
