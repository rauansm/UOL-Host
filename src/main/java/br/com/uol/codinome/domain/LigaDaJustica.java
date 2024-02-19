package br.com.uol.codinome.domain;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@XmlRootElement(name = "liga_da_justica")
@XmlAccessorType(XmlAccessType.FIELD)
public class LigaDaJustica {

    @XmlElement(name = "codinomes")
    private Codinomes codinomes;

}
