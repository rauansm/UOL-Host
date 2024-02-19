package br.com.uol.codinome.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class Vingadores {
    @JsonProperty("vingadores")
    private List<Codinome> codinomes;
}
