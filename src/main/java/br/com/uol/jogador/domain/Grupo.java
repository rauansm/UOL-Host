package br.com.uol.jogador.domain;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.codinome.infra.reader.CodinomeReader;
import lombok.Getter;

import java.util.List;

@Getter
public enum Grupo {
    VINGADORES {
        public List<Codinome> lerCodinomes() {
            return CodinomeReader.lerCodinomesJSON(ENDERECO_ARQUIVO_JSON);
        }
    },
    LIGA_DA_JUSTICA {
        public List<Codinome> lerCodinomes() {
            return CodinomeReader.lerCodinomesXML(ENDERECO_ARQUIVO_XML);
        }
    };

    public abstract List<Codinome> lerCodinomes();

    private static final String ENDERECO_ARQUIVO_XML = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";
    private static final String ENDERECO_ARQUIVO_JSON = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";

}
