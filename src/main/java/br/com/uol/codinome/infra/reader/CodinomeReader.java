package br.com.uol.codinome.infra.reader;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.codinome.domain.LigaDaJustica;
import br.com.uol.codinome.domain.Vingadores;
import br.com.uol.handler.APIException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j2
@RequiredArgsConstructor
public class CodinomeReader  {

    public static List<Codinome> lerCodinomesJSON(String url) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            try (InputStream inputStream = new URL(url).openStream()) {
                Vingadores vingadores = objectMapper.readValue(inputStream, Vingadores.class);
                return vingadores.getCodinomes();
            }
        } catch (IOException e) {
            throw APIException.infra("Erro ao ler o JSON", e);
        }
    }
    public static List<Codinome> lerCodinomesXML(String url) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(LigaDaJustica.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            LigaDaJustica ligaDaJustica = (LigaDaJustica) unmarshaller.unmarshal(new URL(url));
            return converterStringParaCodinomes(ligaDaJustica.getCodinomes().getCodinome());
        } catch (JAXBException | IOException e) {
            throw APIException.infra("Erro ao ler o XML", e);
        }
    }

    private static List<Codinome> converterStringParaCodinomes(List<String> codinomesString) {
        return codinomesString.stream()
                .map(Codinome::new)
                .collect(Collectors.toList());
    }

}
