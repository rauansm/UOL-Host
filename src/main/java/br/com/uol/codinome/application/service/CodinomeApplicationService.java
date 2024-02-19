package br.com.uol.codinome.application.service;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.core.reader.ArquivoCodinome;
import br.com.uol.handler.APIException;
import br.com.uol.jogador.domain.Grupo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CodinomeApplicationService implements CodinomeService {

    private final ArquivoCodinome arquivoCodinome;

    @Override
    public Codinome buscaCodinomeDisponivel(List<String> codinomesEmUso, Grupo grupo)  {
        log.info("[inicia] CodinomeApplicationService - buscaCodinomeDisponivel");
        List<Codinome> codinomesArquivo = buscaCodinomesDoArquivo(grupo);
        List<Codinome> codinomesDisponiveis = verificaCodinomesDisponiveis(codinomesArquivo, codinomesEmUso);
        Codinome.verificaSeExisteCodinomeDisponivel(codinomesDisponiveis);
        log.info("[finaliza] CodinomeApplicationService - buscaCodinomeDisponivel");
        return Codinome.obterCodinomeAleatorio(codinomesDisponiveis);
    }

    private List<Codinome> verificaCodinomesDisponiveis(List<Codinome> codinomesArquivo, List<String> codinomeEmUso) {
        return codinomesArquivo.stream()
                .filter(c -> !codinomeEmUso.contains(c.getCodinome()))
                .collect(Collectors.toList());
    }

    private List<Codinome> buscaCodinomesDoArquivo(Grupo grupo) {
        if (grupo.equals(Grupo.VINGADORES)) {
            return arquivoCodinome.lerCodinomesJSON();
        }
        if (grupo.equals(Grupo.LIGA_DA_JUSTICA)) {
            return arquivoCodinome.lerCodinomesXML();
        }
        throw APIException.negocio("Grupo inválido: " + grupo);
    }

}

