package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "record")
public class CustomMetadataXml {

    @XmlElement(name = "field")
    public ArrayList<CustomMetadata> dataList;

    public void add(CustomMetadata data) {
        if (dataList == null)
            dataList = new ArrayList<>();

        dataList.add(data);
    }
}
