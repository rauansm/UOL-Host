package br.com.uol.codinome.infra.reader;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.codinome.domain.Vingadores;
import br.com.uol.handler.APIException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class LerCodinomesJSON {

    public List<Codinome> lerCodinomes() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            try (InputStream inputStream = new URL("https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json").openStream()) {
                Vingadores vingadores = objectMapper.readValue(inputStream, Vingadores.class);
                return vingadores.getCodinomes();
            }
        } catch (IOException e) {
            throw APIException.infra("Erro ao ler o JSON", e);
        }
    }
}
