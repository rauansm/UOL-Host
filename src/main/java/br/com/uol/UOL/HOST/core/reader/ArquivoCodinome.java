package br.com.uol.UOL.HOST.core.reader;

import br.com.uol.UOL.HOST.codinome.domain.Codinome;

import java.util.List;

public interface ArquivoCodinome {
    List<Codinome> lerCodinomesJSON();
    List<Codinome> lerCodinomesXML();
}
