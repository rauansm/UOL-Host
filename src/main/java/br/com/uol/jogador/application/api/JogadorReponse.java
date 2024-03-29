package br.com.uol.jogador.application.api;

import br.com.uol.jogador.domain.Grupo;
import br.com.uol.jogador.domain.Jogador;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class JogadorReponse {

    private UUID idJogador;
    private String nome;
    private String email;
    private String telefone;
    private String Codinome;
    private Grupo grupo;

    public JogadorReponse(Jogador jogador) {
        this.idJogador = jogador.getIdJogador();
        this.nome = jogador.getNome();
        this.email = jogador.getEmail();
        this.telefone = jogador.getTelefone();
        this.Codinome = jogador.getCodinome();
        this.grupo = jogador.getGrupo();
    }

    public static List<JogadorReponse> converte(Page<Jogador> jogadores) {
         return jogadores.stream()
                .map(JogadorReponse::new)
                .collect(Collectors.toList());
    }
}
