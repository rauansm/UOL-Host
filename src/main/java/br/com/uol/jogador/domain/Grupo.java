package br.com.uol.jogador.domain;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.codinome.infra.reader.LerCodinomesJSON;
import br.com.uol.codinome.infra.reader.LerCodinomesXML;
import lombok.Getter;

import java.util.List;

@Getter
public enum Grupo {
    VINGADORES {
        public List<Codinome> lerCodinomes() {
            return new LerCodinomesXML().lerCodinomes();
        }
    },
    LIGA_DA_JUSTICA {
        public List<Codinome> lerCodinomes() {
            return new LerCodinomesJSON().lerCodinomes();
        }
    };

    public abstract List<Codinome> lerCodinomes();

}
