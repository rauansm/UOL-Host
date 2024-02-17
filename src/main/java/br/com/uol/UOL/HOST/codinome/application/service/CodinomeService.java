package br.com.uol.UOL.HOST.codinome.application.service;

import br.com.uol.UOL.HOST.codinome.domain.Codinome;
import br.com.uol.UOL.HOST.jogador.domain.Grupo;

import java.util.List;

public interface CodinomeService {
    Codinome buscaCodinomeDisponivel(List<String> codinomesEmUso, Grupo grupo) ;
}
