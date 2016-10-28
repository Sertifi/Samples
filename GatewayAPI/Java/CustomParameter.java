import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by JakeHoward on 10/25/2016.
 */
public class CustomParameter {
    @XmlAttribute(name="Name")
    String name;
    @XmlAttribute(name="Text")
    String value;
}
