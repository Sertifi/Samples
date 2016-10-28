
package net.sertifi.apps.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileQueryResult" type="{http://apps.sertifi.net/services/}ArrayOfFileQueryResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fileQueryResult"
})
@XmlRootElement(name = "FileQueryResponse")
public class FileQueryResponse {

    @XmlElement(name = "FileQueryResult")
    protected ArrayOfFileQueryResult fileQueryResult;

    /**
     * Gets the value of the fileQueryResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFileQueryResult }
     *     
     */
    public ArrayOfFileQueryResult getFileQueryResult() {
        return fileQueryResult;
    }

    /**
     * Sets the value of the fileQueryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFileQueryResult }
     *     
     */
    public void setFileQueryResult(ArrayOfFileQueryResult value) {
        this.fileQueryResult = value;
    }

}
