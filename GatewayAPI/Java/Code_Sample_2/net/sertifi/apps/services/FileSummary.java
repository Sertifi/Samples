
package net.sertifi.apps.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for FileSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileStatus" type="{http://apps.sertifi.net/services/}RoomStatus"/>
 *         &lt;element name="OwnerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Unsigned" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Signed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DateLastAction" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileSummary", propOrder = {
    "fileId",
    "fileStatus",
    "ownerEmail",
    "unsigned",
    "signed",
    "dateCreated",
    "dateLastAction"
})
public class FileSummary {

    @XmlElement(name = "FileId")
    protected String fileId;
    @XmlElement(name = "FileStatus", required = true)
    @XmlSchemaType(name = "string")
    protected RoomStatus fileStatus;
    @XmlElement(name = "OwnerEmail")
    protected String ownerEmail;
    @XmlElement(name = "Unsigned")
    protected int unsigned;
    @XmlElement(name = "Signed")
    protected int signed;
    @XmlElement(name = "DateCreated", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreated;
    @XmlElement(name = "DateLastAction", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateLastAction;

    /**
     * Gets the value of the fileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * Sets the value of the fileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileId(String value) {
        this.fileId = value;
    }

    /**
     * Gets the value of the fileStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RoomStatus }
     *     
     */
    public RoomStatus getFileStatus() {
        return fileStatus;
    }

    /**
     * Sets the value of the fileStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomStatus }
     *     
     */
    public void setFileStatus(RoomStatus value) {
        this.fileStatus = value;
    }

    /**
     * Gets the value of the ownerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }

    /**
     * Sets the value of the ownerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerEmail(String value) {
        this.ownerEmail = value;
    }

    /**
     * Gets the value of the unsigned property.
     * 
     */
    public int getUnsigned() {
        return unsigned;
    }

    /**
     * Sets the value of the unsigned property.
     * 
     */
    public void setUnsigned(int value) {
        this.unsigned = value;
    }

    /**
     * Gets the value of the signed property.
     * 
     */
    public int getSigned() {
        return signed;
    }

    /**
     * Sets the value of the signed property.
     * 
     */
    public void setSigned(int value) {
        this.signed = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreated(XMLGregorianCalendar value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the dateLastAction property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastAction() {
        return dateLastAction;
    }

    /**
     * Sets the value of the dateLastAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastAction(XMLGregorianCalendar value) {
        this.dateLastAction = value;
    }

}
