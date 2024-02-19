package br.com.uol.codinome.domain;

import br.com.uol.handler.APIException;
import lombok.*;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Codinome {

    private String codinome;


    public static void verificaSeExisteCodinomeDisponivel(List<Codinome> codinomeDisponiveis) {
        if (codinomeDisponiveis.isEmpty()) {
            throw APIException.negocio("No momento não possui codinomes disponivel para este grupo!");
        }
    }

    public static Codinome obterCodinomeAleatorio(List<Codinome> codinomesDisponiveis) {
        Random random = new Random();
        int codinomeAleatorio = random.nextInt(codinomesDisponiveis.size());
        return codinomesDisponiveis.get(codinomeAleatorio);
    }

    public Codinome(String codinomeString) {
        this.codinome = codinomeString;
    }
}
