package models;

import javax.xml.bind.annotation.XmlAttribute;

public class CustomParameter {
    @XmlAttribute(name="Name")
    public String name;
    @XmlAttribute(name="Text")
    public String value;
}
