package br.com.uol.UOL.HOST.codinome.application.service;

import br.com.uol.UOL.HOST.codinome.domain.Codinome;
import br.com.uol.UOL.HOST.core.reader.ArquivoCodinome;
import br.com.uol.UOL.HOST.jogador.domain.Grupo;
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
        List<Codinome> codinomesArquivo = buscaCodinomesDoArquivo(grupo);
        List<Codinome> codinomesDisponiveis = verificaCodinomesDisponiveis(codinomesArquivo, codinomesEmUso);
        Codinome.verificaSeExisteCodinomeDisponivel(codinomesDisponiveis);
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
        throw new IllegalArgumentException("Grupo inválido: " + grupo);
    }

}
