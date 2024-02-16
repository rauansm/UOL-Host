package br.com.uol.UOL.HOST.jogador.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/jogador")
public interface JogadorAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    JogadorReponse criaJogador (@Valid @RequestBody JogadorRequest jogadorRequest);
}