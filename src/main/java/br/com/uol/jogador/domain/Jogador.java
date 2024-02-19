package br.com.uol.jogador.domain;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.jogador.application.api.JogadorRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
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
    @Column(nullable = false)
    private String codinome;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Grupo grupo;

    public Jogador(JogadorRequest jogadorRequest, Codinome codinome) {
        this.idJogador = UUID.randomUUID();
        this.nome = jogadorRequest.getNome();
        this.email = jogadorRequest.getEmail();
        this.telefone = jogadorRequest.getTelefone();
        this.codinome = codinome.getCodinome();
        this.grupo = jogadorRequest.getGrupo();
    }
}
