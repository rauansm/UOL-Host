package br.com.uol.UOL.HOST.jogador.infra;

import br.com.uol.UOL.HOST.jogador.domain.Grupo;
import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JogadorSpringDataJPA extends JpaRepository<Jogador, UUID> {
    @Query("Select codinome from Jogador j where j.grupo = :grupo")
    List<String> buscaCodinomes(Grupo grupo);
}
