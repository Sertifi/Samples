import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
public class SetSigCustomMeta {
    @XmlElement(name="field")
    List<CustomParameter> fields;

    public SetSigCustomMeta(){
        fields = new ArrayList<CustomParameter>();
    }
    public void add(CustomParameter field){
        fields.add(field);
    }
}
