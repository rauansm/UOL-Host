package br.com.uol.UOL.HOST.jogador.application.api;

import br.com.uol.UOL.HOST.jogador.domain.Jogador;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/jogador")
public interface JogadorAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    JogadorReponse criaJogador (@Valid @RequestBody JogadorRequest jogadorRequest) ;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<JogadorReponse> listaTodosJogadores();
}
