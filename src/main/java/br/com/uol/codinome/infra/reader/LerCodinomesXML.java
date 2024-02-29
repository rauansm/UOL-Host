package br.com.uol.codinome.infra.reader;

import br.com.uol.codinome.domain.Codinome;
import br.com.uol.codinome.domain.LigaDaJustica;
import br.com.uol.handler.APIException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class LerCodinomesXML {

    public List<Codinome> lerCodinomes() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(LigaDaJustica.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            LigaDaJustica ligaDaJustica = (LigaDaJustica) unmarshaller.unmarshal(new URL("https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml"));
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
