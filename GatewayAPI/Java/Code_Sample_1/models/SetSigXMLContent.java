package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name="file")
@XmlAccessorType(XmlAccessType.FIELD)
public class SetSigXMLContent {

    @XmlElement(name="Parameter")
    List<Parameter> options;
    public SetSigXMLContent(){
        options = new ArrayList<Parameter>();
    }
    public void add(Parameter option){
        options.add(option);
    }
}