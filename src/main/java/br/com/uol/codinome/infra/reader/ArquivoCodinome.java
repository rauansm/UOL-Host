package br.com.uol.codinome.infra.reader;

import br.com.uol.codinome.domain.Codinome;

import java.util.List;

public interface ArquivoCodinome {
    List<Codinome> lerCodinomesJSON();
    List<Codinome> lerCodinomesXML();
}
