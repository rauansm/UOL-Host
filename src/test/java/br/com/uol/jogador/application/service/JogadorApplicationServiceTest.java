package br.com.uol.jogador.application.service;

import br.com.uol.codinome.application.service.CodinomeService;
import br.com.uol.codinome.domain.Codinome;
import br.com.uol.jogador.application.api.JogadorReponse;
import br.com.uol.jogador.application.api.JogadorRequest;
import br.com.uol.jogador.application.repository.JogadorRepository;
import br.com.uol.jogador.domain.Grupo;
import br.com.uol.jogador.domain.Jogador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JogadorApplicationServiceTest {

    @InjectMocks
    JogadorApplicationService jogadorApplicationService;

    @Mock
    JogadorRepository jogadorRepository;

    @Mock
    private CodinomeService codinomeService;
    @Mock
    private Pageable pageable;

    @Test
    void criaJogador_DeveRetornarJogadorResponse_QuandoJogadorCriadoComSucesso() {
        JogadorRequest jogadorRequest = DataHelper.getJogadorRequest();
        Grupo grupo = jogadorRequest.getGrupo();
        Codinome codinome = DataHelper.getCodinome();
        List<String> codinomes = DataHelper.createListCodinome();

        when(jogadorRepository.buscaTodosCodinomesDoGrupo(any())).thenReturn(codinomes);
        when(codinomeService.buscaCodinomeDisponivel(codinomes, grupo)).thenReturn(codinome);
        when(jogadorRepository.salva(any())).thenReturn(new Jogador(jogadorRequest,codinome));
        JogadorReponse jogadorResponse = jogadorApplicationService.criaJogador(jogadorRequest);

        assertNotNull(jogadorResponse);
        assertEquals("Hulk", jogadorResponse.getCodinome());
        assertEquals(JogadorReponse.class, jogadorResponse.getClass());
        assertEquals(UUID.class, jogadorResponse.getIdJogador().getClass());
        assertEquals(Grupo.VINGADORES, jogadorResponse.getGrupo());
    }


    @Test
    void deveRetornarPageDeTodosJogadores() {
        List<Jogador> jogadores = DataHelper.createListJogador();
        Page<Jogador> jogadoresPage = new PageImpl<>(jogadores);

        when(jogadorRepository.buscaTodosJogadores(pageable)).thenReturn(jogadoresPage);
        Page<JogadorReponse> response = jogadorApplicationService.listaTodosJogadores(pageable);

        assertEquals(jogadores.size(), response.getContent().size());
        assertEquals(4, response.getTotalElements());
        assertEquals(1,response.getTotalPages());
        verify(jogadorRepository,times(1)).buscaTodosJogadores(pageable);
    }


}
