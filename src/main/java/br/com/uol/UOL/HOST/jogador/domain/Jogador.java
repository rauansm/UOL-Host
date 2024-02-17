package br.com.uol.UOL.HOST.jogador.domain;

import br.com.uol.UOL.HOST.codinome.domain.Codinome;
import br.com.uol.UOL.HOST.jogador.application.api.JogadorRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idJogador", updatable = false, unique = true, nullable = false)
    private UUID idJogador;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    private String telefone;
    private String codinome;
    @Enumerated(EnumType.STRING)
    private Grupo grupo;

    public Jogador(JogadorRequest jogadorRequest, Codinome codinome) {
        this.nome = jogadorRequest.getNome();
        this.email = jogadorRequest.getEmail();
        this.telefone = jogadorRequest.getTelefone();
        this.codinome = codinome.getCodinome();
        this.grupo = jogadorRequest.getGrupo();
    }
}
