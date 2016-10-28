package models;

import javax.xml.bind.annotation.XmlAttribute;


public class Parameter {
    @XmlAttribute
    public String name;
    @XmlAttribute
    public String value;
}
