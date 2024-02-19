package br.com.uol.codinome.application.service;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.jogador.domain.Grupo;

import java.util.List;

public interface CodinomeService {
    Codinome buscaCodinomeDisponivel(List<String> codinomesEmUso, Grupo grupo) ;
}
