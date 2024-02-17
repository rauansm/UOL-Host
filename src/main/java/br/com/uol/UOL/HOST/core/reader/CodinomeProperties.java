package br.com.uol.UOL.HOST.core.reader;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("uol.codinome.url")
public class CodinomeProperties {
    private String json;
    private String xml;
}
