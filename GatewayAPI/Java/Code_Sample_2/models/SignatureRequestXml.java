package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "file")
public class SignatureRequestXml {

    @XmlElement(name = "parameter")
    public ArrayList<SignatureRequestParameter> parameters;

    public void add(SignatureRequestParameter parameter) {
        if (parameters == null)
            parameters = new ArrayList<>();

        parameters.add(parameter);
    }
}
