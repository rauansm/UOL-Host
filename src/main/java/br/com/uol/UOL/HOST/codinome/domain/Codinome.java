package br.com.uol.UOL.HOST.codinome.domain;

import br.com.uol.UOL.HOST.handler.APIException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
