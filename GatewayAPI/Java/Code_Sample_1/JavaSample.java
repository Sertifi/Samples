import https.apps_sertifi_net.services.linkparameter.LinkParameter;
import https.apps_sertifi_net.services.linkparameter.LinkParameterType;
import net.sertifi.apps.services.*;
import net.sertifi.apps.services.linkparameter.UrlQueryResult;
import models.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;


public class JavaSample {
    private static final String pstr_APICode = "";

    public static void main(String[] args) throws Exception{

        /* Setup Soap Connection */
        GatewaySoap SertifiAPIRequest = new Gateway().getGatewaySoap();


        /* CreateSignatureRequest */
        String pstr_SenderEmail = "Sertifitest@sertifi.com";
        String pstr_SenderName = "Sertifi Sender";
        String pstr_FileName = "Test File";
        String pstr_Signers = "Sertifitest@sertifi.com";
        String pstr_SecondSigners = "";
        String pstr_CCs = "";
        String pstr_Cosign = "";
        String pstr_SignType = "elec";
        String pstr_Password = "";
        String pstr_Field1 = "";
        String pstr_Field2 = "";
        String pstr_Field3 = "";
        String pstr_Field4 = "";
        String pstr_EmailMessage = "";


        String pstr_FileID = SertifiAPIRequest.createSignatureRequest(pstr_APICode, pstr_SenderEmail, pstr_SenderName,
                                                                      pstr_FileName, pstr_Signers, pstr_SecondSigners,
                                                                      pstr_CCs, pstr_Cosign, pstr_SignType, pstr_Password,
                                                                      pstr_Field1, pstr_Field2, pstr_Field3, pstr_Field4,
                                                                      pstr_EmailMessage);
        System.out.println("Creating Signature Request... File ID is: " + pstr_FileID);

      
        /* AddSignerToRequest */
        Integer sequence = 2;
        String addSignerResult = SertifiAPIRequest.addSignerToRequest(pstr_APICode, pstr_FileID, pstr_SenderEmail, sequence);
        System.out.println("Adding Signer: " + addSignerResult);


        /* AddDocumentToRequest */
        String file_path = "C:\\Development\\Workspace\\ApiTest\\TestDocument.docx";
        pstr_FileName = "TestDocument.docx";
        byte[] pbyt_File = Files.readAllBytes(new File(file_path).toPath());
        String pstr_Title = "Name of document on website";
        String pstr_Xml = "";
        String pstr_DocumentId = SertifiAPIRequest.addDocumentToRequest(pstr_APICode, pstr_FileID, pbyt_File, pstr_FileName, pstr_Title, pstr_Xml);
        System.out.println("Document ID: " + pstr_DocumentId);


        /* InviteSigners */
        String inviteSignersResult = SertifiAPIRequest.inviteSigners(pstr_APICode, pstr_FileID, pstr_EmailMessage);
        System.out.println("Invite signers result: " + inviteSignersResult);


        /* SetSignatureRequestParameters */
        /* Generate p_XMLContent Parameter */
        JAXBContext jcContent = JAXBContext.newInstance(SetSigXMLContent.class);
        SetSigXMLContent XMLContent = new SetSigXMLContent();

        Parameter param1 = new Parameter();
        Parameter param2 = new Parameter();

        param1.name = "FileNumericId1";
        param1.value = "89";
        param2.name = "FolderExpiresOn";
        param2.value = "2016-12-12";

        XMLContent.add(param1);
        XMLContent.add(param2);

        Marshaller marsh1 = jcContent.createMarshaller();
        marsh1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer1 = new StringWriter();
        marsh1.marshal(XMLContent, writer1);


        /* Generate p_CustomMetadataXML Parameter */
        JAXBContext jcCustomContent = JAXBContext.newInstance(SetSigCustomMeta.class);
        SetSigCustomMeta CustomMetadataXML = new SetSigCustomMeta();

        CustomParameter customparam = new CustomParameter();
        customparam.name = "OrderId";
        customparam.value = "2343";
        CustomMetadataXML.add(customparam);

        Marshaller marsh2 = jcCustomContent.createMarshaller();
        marsh2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer2 = new StringWriter();
        marsh2.marshal(CustomMetadataXML,writer2);

        /* convert xml to string for api call */
        //Example xml: <?xml version="1.0" encoding="UTF-8" standalone="yes"?><file><Parameter name="FileNumericId1" value="89"/><Parameter name="FolderExpiresOn" value="2016-12-12"/></file>
        String p_XMLContent = writer1.toString();
        //Example xml: <?xml version="1.0" encoding="UTF-8" standalone="yes"?><record><field Name="OrderId" Text="2343"/></record>
        String p_CustomMetadataXML = writer2.toString();

        /* SetSignatureRequestParameters api call */
        String sigRequestResult = SertifiAPIRequest.setSignatureRequestParameters(pstr_APICode, pstr_FileID, p_XMLContent, p_CustomMetadataXML);
        System.out.println("Signature Request Parameters result: " + sigRequestResult);


        /* GetLink Calls */
        String pstr_SignerEmail = "Sertifitest@sertifi.com";

        /* setup for DocumentSignedLink */
        LinkParameter DocumentSignedLink = new LinkParameter();
        DocumentSignedLink.setFileId(pstr_FileID);
        DocumentSignedLink.setDocumentId(pstr_DocumentId);
        DocumentSignedLink.setSignerEmail(pstr_SignerEmail);
        DocumentSignedLink.setLinkType(LinkParameterType.DOCUMENT_SIGNED_LINK);

        /* setup for DocumentPrefillLink */
        LinkParameter DocumentPrefillLink = new LinkParameter();
        DocumentPrefillLink.setFileId(pstr_FileID);
        DocumentPrefillLink.setDocumentId(pstr_DocumentId);
        DocumentPrefillLink.setLinkType(LinkParameterType.DOCUMENT_PREFILL_LINK);
        DocumentPrefillLink.setSignerEmail(pstr_SignerEmail);


        /* setup for FileMaintenanceLink */
        LinkParameter FileMaintenanceLink = new LinkParameter();
        FileMaintenanceLink.setFileId(pstr_FileID);
        FileMaintenanceLink.setDocumentId(pstr_DocumentId);
        FileMaintenanceLink.setLinkType(LinkParameterType.FILE_MAINTENANCE_LINK);
        FileMaintenanceLink.setSignerEmail(pstr_SignerEmail);

        /* setup for SecureFileMaintenanceLink */
        LinkParameter SecureFileMaintenanceLink = new LinkParameter();
        SecureFileMaintenanceLink.setFileId(pstr_FileID);
        SecureFileMaintenanceLink.setDocumentId(pstr_DocumentId);
        SecureFileMaintenanceLink.setLinkType(LinkParameterType.SECURE_FILE_MAINTENANCE_LINK);
        SecureFileMaintenanceLink.setSignerEmail(pstr_SignerEmail);

        /* setup array of link parameters to pass to GetLink api call */
        ArrayOfLinkParameter parameters = new ArrayOfLinkParameter();
        parameters.getLinkParameter().add(DocumentSignedLink);
        parameters.getLinkParameter().add(DocumentPrefillLink);
        parameters.getLinkParameter().add(FileMaintenanceLink);
        parameters.getLinkParameter().add(SecureFileMaintenanceLink);

        /* call GetLink and print out the links */
        ArrayOfUrlQueryResult getLinkResult  = SertifiAPIRequest.getLink(pstr_APICode, parameters);
        List<UrlQueryResult> links = getLinkResult.getUrlQueryResult();
        for(UrlQueryResult temp : links){
            String link = temp.getLink();
            String type = temp.getLinkType().value();
            System.out.println(type + ": " + link);
        }


        /* CreatePayment */
        BigDecimal amount = BigDecimal.ONE;
        String description = "Example payment";
        PaymentReccurence recurrence = PaymentReccurence.ONE_TIME;
        String datePaymentDue = "2016/12/25";
        PaymentOperationType operation = PaymentOperationType.PAY;

        String paymentIdPay = SertifiAPIRequest.createPayment(pstr_APICode, pstr_FileID, amount, description,
                                                              recurrence, datePaymentDue, operation);

        description = "Example Authorization";
        amount = BigDecimal.ZERO;
        operation = PaymentOperationType.AUTHORIZE;

        String paymentIdAuth = SertifiAPIRequest.createPayment(pstr_APICode, pstr_FileID, amount, description,
                                                               recurrence, datePaymentDue, operation);


        /* In Document Authorization Example */

        Integer pint_Page = 1;
        Integer pint_Top = 200;
        Integer pint_Left = 400;
        Integer pint_Height = 0;
        Integer pint_width = 0;
        String pstr_Caption = "Payment prompt";
        Integer pint_FieldType = 10;
        sequence = 1;
        String indocumentId = SertifiAPIRequest.addLocation(pstr_APICode, pstr_FileID, pstr_DocumentId,
                                                            pint_Page, pint_Top, pint_Left, pint_Height,
                                                            pint_width, pstr_SignerEmail, pstr_Caption,
                                                            pint_FieldType, sequence);

        System.out.println("Payment ID for payment: " + paymentIdPay);
        System.out.println("Payment ID for authorization:" + paymentIdAuth);
        System.out.println("Add indocument payment field: " + indocumentId);
    }
}
