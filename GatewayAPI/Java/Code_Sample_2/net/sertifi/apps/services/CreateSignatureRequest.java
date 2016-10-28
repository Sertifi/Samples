
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
 *         &lt;element name="pstr_APICode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_SenderEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_SenderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Signers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_SecondSigners" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_CCs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Cosign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_SignType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Field1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Field2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Field3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Field4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_EmailMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pstrAPICode",
    "pstrSenderEmail",
    "pstrSenderName",
    "pstrFileName",
    "pstrSigners",
    "pstrSecondSigners",
    "pstrCCs",
    "pstrCosign",
    "pstrSignType",
    "pstrPassword",
    "pstrField1",
    "pstrField2",
    "pstrField3",
    "pstrField4",
    "pstrEmailMessage"
})
@XmlRootElement(name = "CreateSignatureRequest")
public class CreateSignatureRequest {

    @XmlElement(name = "pstr_APICode")
    protected String pstrAPICode;
    @XmlElement(name = "pstr_SenderEmail")
    protected String pstrSenderEmail;
    @XmlElement(name = "pstr_SenderName")
    protected String pstrSenderName;
    @XmlElement(name = "pstr_FileName")
    protected String pstrFileName;
    @XmlElement(name = "pstr_Signers")
    protected String pstrSigners;
    @XmlElement(name = "pstr_SecondSigners")
    protected String pstrSecondSigners;
    @XmlElement(name = "pstr_CCs")
    protected String pstrCCs;
    @XmlElement(name = "pstr_Cosign")
    protected String pstrCosign;
    @XmlElement(name = "pstr_SignType")
    protected String pstrSignType;
    @XmlElement(name = "pstr_Password")
    protected String pstrPassword;
    @XmlElement(name = "pstr_Field1")
    protected String pstrField1;
    @XmlElement(name = "pstr_Field2")
    protected String pstrField2;
    @XmlElement(name = "pstr_Field3")
    protected String pstrField3;
    @XmlElement(name = "pstr_Field4")
    protected String pstrField4;
    @XmlElement(name = "pstr_EmailMessage")
    protected String pstrEmailMessage;

    /**
     * Gets the value of the pstrAPICode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrAPICode() {
        return pstrAPICode;
    }

    /**
     * Sets the value of the pstrAPICode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrAPICode(String value) {
        this.pstrAPICode = value;
    }

    /**
     * Gets the value of the pstrSenderEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrSenderEmail() {
        return pstrSenderEmail;
    }

    /**
     * Sets the value of the pstrSenderEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrSenderEmail(String value) {
        this.pstrSenderEmail = value;
    }

    /**
     * Gets the value of the pstrSenderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrSenderName() {
        return pstrSenderName;
    }

    /**
     * Sets the value of the pstrSenderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrSenderName(String value) {
        this.pstrSenderName = value;
    }

    /**
     * Gets the value of the pstrFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrFileName() {
        return pstrFileName;
    }

    /**
     * Sets the value of the pstrFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrFileName(String value) {
        this.pstrFileName = value;
    }

    /**
     * Gets the value of the pstrSigners property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrSigners() {
        return pstrSigners;
    }

    /**
     * Sets the value of the pstrSigners property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrSigners(String value) {
        this.pstrSigners = value;
    }

    /**
     * Gets the value of the pstrSecondSigners property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrSecondSigners() {
        return pstrSecondSigners;
    }

    /**
     * Sets the value of the pstrSecondSigners property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrSecondSigners(String value) {
        this.pstrSecondSigners = value;
    }

    /**
     * Gets the value of the pstrCCs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrCCs() {
        return pstrCCs;
    }

    /**
     * Sets the value of the pstrCCs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrCCs(String value) {
        this.pstrCCs = value;
    }

    /**
     * Gets the value of the pstrCosign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrCosign() {
        return pstrCosign;
    }

    /**
     * Sets the value of the pstrCosign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrCosign(String value) {
        this.pstrCosign = value;
    }

    /**
     * Gets the value of the pstrSignType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrSignType() {
        return pstrSignType;
    }

    /**
     * Sets the value of the pstrSignType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrSignType(String value) {
        this.pstrSignType = value;
    }

    /**
     * Gets the value of the pstrPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrPassword() {
        return pstrPassword;
    }

    /**
     * Sets the value of the pstrPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrPassword(String value) {
        this.pstrPassword = value;
    }

    /**
     * Gets the value of the pstrField1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrField1() {
        return pstrField1;
    }

    /**
     * Sets the value of the pstrField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrField1(String value) {
        this.pstrField1 = value;
    }

    /**
     * Gets the value of the pstrField2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrField2() {
        return pstrField2;
    }

    /**
     * Sets the value of the pstrField2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrField2(String value) {
        this.pstrField2 = value;
    }

    /**
     * Gets the value of the pstrField3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrField3() {
        return pstrField3;
    }

    /**
     * Sets the value of the pstrField3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrField3(String value) {
        this.pstrField3 = value;
    }

    /**
     * Gets the value of the pstrField4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrField4() {
        return pstrField4;
    }

    /**
     * Sets the value of the pstrField4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrField4(String value) {
        this.pstrField4 = value;
    }

    /**
     * Gets the value of the pstrEmailMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrEmailMessage() {
        return pstrEmailMessage;
    }

    /**
     * Sets the value of the pstrEmailMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrEmailMessage(String value) {
        this.pstrEmailMessage = value;
    }

}
