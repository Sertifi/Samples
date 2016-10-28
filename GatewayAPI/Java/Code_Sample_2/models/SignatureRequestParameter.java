package models;

import javax.xml.bind.annotation.XmlAttribute;

public class SignatureRequestParameter {

    @XmlAttribute(name = "name")
    public String name;

    @XmlAttribute(name = "value")
    public String value;

    public SignatureRequestParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
