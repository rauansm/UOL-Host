package br.com.uol.UOL.HOST.jogador.application.api;

import br.com.uol.UOL.HOST.jogador.domain.Grupo;
import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import lombok.Value;

import java.util.UUID;

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
}
