package models;

import javax.xml.bind.annotation.XmlAttribute;

public class CustomMetadata {

    @XmlAttribute(name = "Name")
    public String name;

    @XmlAttribute(name = "Text")
    public String text;

    public CustomMetadata(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
