package br.com.uol.jogador.application.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/jogador")
public interface JogadorAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    JogadorReponse criaJogador (@Valid @RequestBody JogadorRequest jogadorRequest) ;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    Page<JogadorReponse> listaTodosJogadores(@PageableDefault (size = 10) Pageable pageable);
}
