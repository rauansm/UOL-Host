package br.com.uol.UOL.HOST.jogador.application.api;

import br.com.uol.UOL.HOST.jogador.domain.Grupo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class JogadorRequest {

    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotNull
    private Grupo grupo;
}
