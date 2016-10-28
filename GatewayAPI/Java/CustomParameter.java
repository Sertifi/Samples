import javax.xml.bind.annotation.XmlAttribute;

public class CustomParameter {
    @XmlAttribute(name="Name")
    String name;
    @XmlAttribute(name="Text")
    String value;
}
