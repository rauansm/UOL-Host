package br.com.uol.jogador.application.service;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.jogador.application.api.JogadorRequest;
import br.com.uol.jogador.domain.Grupo;
import br.com.uol.jogador.domain.Jogador;

import java.util.List;
import java.util.UUID;

public class DataHelper {

    public static Jogador createJogador() {
        return Jogador.builder().idJogador(UUID.randomUUID()).email("rauan@gmail.com").nome("rauan").telefone("21979112477")
                .codinome("Hulk").grupo(Grupo.VINGADORES).build();
    }

    public static JogadorRequest getJogadorRequest() {
        return new JogadorRequest("rauan", "rauan@gmail.com", "21979112477", Grupo.VINGADORES);
    }

    public static Codinome getCodinome() {
        return Codinome.builder().codinome("Hulk").build();
    }

    public static List<String> createListCodinome() {
        return List.of(new String("Hulk"),
                new String("Pantera Negra"),
                new String("Thor"),
                new String("Visao")
        );
    }
    public static List<Jogador> createListJogador() {
        return List.of(Jogador.builder().idJogador(UUID.randomUUID()).codinome("Hulk").email("rauanmor@gmail.com").build(),
                Jogador.builder().build(),
                Jogador.builder().idJogador(UUID.randomUUID()).codinome("Pantera Negra").email("rauan@gmail.com").build(),
                Jogador.builder().build()
        );
    }
}