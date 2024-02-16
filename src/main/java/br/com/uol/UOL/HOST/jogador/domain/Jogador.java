package br.com.uol.UOL.HOST.jogador.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idJogador", updatable = false, unique = true, nullable = false)
    private UUID idJogador;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    private String telefone;
    private String codinome;
    @Enumerated(EnumType.STRING)
    private Grupo grupo;
}
