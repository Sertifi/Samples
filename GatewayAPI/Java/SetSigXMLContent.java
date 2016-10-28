import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JakeHoward on 10/25/2016.
 */
@XmlRootElement(name="file")
@XmlAccessorType(XmlAccessType.FIELD)
public class SetSigXMLContent {
    //create list of parameters where Parameter is a separate class with
    @XmlElement(name="Parameter")
    List<Parameter> options;
    public SetSigXMLContent(){
        options = new ArrayList<Parameter>();
    }
    public void add(Parameter option){
        options.add(option);
    }
//    Boolean MaskEmailsFromClient;
//    LocalDate FolderExpiresOn;
//    String EmailGroupName;
//    Boolean ConsolidatedSigning;
//    Integer FileNumericId1;
//
//    public String getEmailGroupName(){
//        return EmailGroupName;
//    }
//    public void setEmailGroupName(String name){
//        EmailGroupName = name;
//    }
//    public Boolean getMaskEmailsFromClient(){
//        return MaskEmailsFromClient;
//    }
//    public void setMaskEmailsFromClient(Boolean value){
//        MaskEmailsFromClient = value;
//    }
//    public String getFolderExpiresOn(){
//        return FolderExpiresOn.toString();
//    }
//    public void setFolderExpiresOn(Integer year, Integer month, Integer day){
//        FolderExpiresOn = LocalDate.of(year,month,day);
//    }
//    public Boolean getConsolidatedSigning(){
//        return ConsolidatedSigning;
//    }
//    public void setConsolidatedSigning(Boolean value){
//        ConsolidatedSigning = value;
//    }
//    public Integer getFileNumericId1(){
//        return FileNumericId1;
//    }
//    public void setFileNumericId1(Integer value){
//        FileNumericId1 = value;
//    }

//    public String xmlString(){
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        XMLEncoder xmlEncoder = new XMLEncoder(outStream);
//        xmlEncoder.writeObject(this);
//        xmlEncoder.close();
//
//        String xml = xmlEncoder.toString();
//        return xml;
//    }
}
