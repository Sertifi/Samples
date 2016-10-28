package utilities;

import models.CustomMetadataXml;
import models.SignatureRequestXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlWriter {
    public static String serializeXml(Object xml) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context;

        if (xml instanceof SignatureRequestXml)
            context = JAXBContext.newInstance(SignatureRequestXml.class);
        else
            context = JAXBContext.newInstance(CustomMetadataXml.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(xml, writer);

        return writer.toString();
    }
}
