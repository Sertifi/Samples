
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
 *         &lt;element name="DownloadFileContentsResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "downloadFileContentsResult"
})
@XmlRootElement(name = "DownloadFileContentsResponse")
public class DownloadFileContentsResponse {

    @XmlElement(name = "DownloadFileContentsResult")
    protected byte[] downloadFileContentsResult;

    /**
     * Gets the value of the downloadFileContentsResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDownloadFileContentsResult() {
        return downloadFileContentsResult;
    }

    /**
     * Sets the value of the downloadFileContentsResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDownloadFileContentsResult(byte[] value) {
        this.downloadFileContentsResult = value;
    }

}
