package br.com.uol.jogador.domain;

import br.com.uol.codinome.infra.reader.CodinomeInfra;
import br.com.uol.codinome.infra.reader.LerCodinomesJSON;
import br.com.uol.codinome.infra.reader.LerCodinomesXML;
import lombok.Getter;

@Getter
public enum Grupo {
    VINGADORES {
        @Override
        public CodinomeInfra superHerois() {
            return new LerCodinomesXML();
        }
    },
    LIGA_DA_JUSTICA {
        @Override
        public CodinomeInfra superHerois() {
            return new LerCodinomesJSON();
        }
    };

    public abstract CodinomeInfra  superHerois();

}
