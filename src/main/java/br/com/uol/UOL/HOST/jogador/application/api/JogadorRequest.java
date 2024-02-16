package br.com.uol.UOL.HOST.jogador.application.api;

import br.com.uol.UOL.HOST.jogador.domain.Grupo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class JogadorRequest {
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    private String telefone;
    private String codinome;
    private Grupo grupo;
}
