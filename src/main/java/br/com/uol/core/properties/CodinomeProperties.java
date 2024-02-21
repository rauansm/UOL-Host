package br.com.uol.core.properties;

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
