package br.com.uol.UOL.HOST.codinome.domain;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class Codinomes {

    @XmlElement(name = "codinome")
    public List<String> codinome;



}
