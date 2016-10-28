import https.apps_sertifi_net.services.linkparameter.LinkParameter;
import https.apps_sertifi_net.services.linkparameter.LinkParameterType;
import models.*;
import net.sertifi.apps.services.ArrayOfLinkParameter;
import net.sertifi.apps.services.ArrayOfUrlQueryResult;
import net.sertifi.apps.services.PaymentOperationType;
import net.sertifi.apps.services.PaymentReccurence;
import net.sertifi.apps.services.linkparameter.UrlQueryResult;
import utilities.UrlDownload;
import utilities.XmlWriter;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    private static final GatewayDelegate gatewayDelegate = new GatewayDelegate();

    public static void main(String[] args) throws JAXBException {
        String fileId = createSignatureRequest();
        addSignerToRequest(fileId);
        String documentId = addDocumentToRequest(fileId);
        inviteSigners(fileId);
        setSignatureRequestParameters(fileId);
        getFileStatus(fileId);
        getLink(fileId, documentId);
        createPayment(fileId);
        addLocation(fileId, documentId);

        System.out.println(Constants.DONE);
        System.out.println();
        System.out.println(Constants.EXIT_MESSAGE);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createSignatureRequest() {
        System.out.println("Creating signature request..");

        SignatureRequest signatureRequest = new SignatureRequest();
        signatureRequest.apiCode = Constants.API_CODE;
        signatureRequest.senderEmailAddress = Constants.EMAIL_ADDRESS;
        signatureRequest.senderName = Constants.NAME;
        signatureRequest.fileName = Constants.FOLDER_NAME;
        signatureRequest.signerEmailAddress = Constants.SIGNER_EMAIL_ADDRESS;
        signatureRequest.emailMessage = Constants.EMAIL_MESSAGE;
        String response = gatewayDelegate.createSignatureRequest(signatureRequest);

        System.out.println(response);
        return response;
    }

    private static void addSignerToRequest(String fileId) {
        System.out.println("Adding signers to request..");

        Signer signer = new Signer();
        signer.apiCode = Constants.API_CODE;
        signer.fileId = fileId;
        signer.email = Constants.SIGNER_EMAIL_ADDRESS;
        signer.sequence = Constants.SEQUENCE_LEVEL_2;
        String response = gatewayDelegate.addSignerToRequest(signer);

        System.out.println(response);
    }

    private static String addDocumentToRequest(String fileId) {
        System.out.println("Adding document to request..");

        Document document = new Document();
        document.apiCode = Constants.API_CODE;
        document.fileId = fileId;
        document.file = UrlDownload.downloadFromUrl(Constants.FILE_URL);
        document.fileName = Constants.FILE_NAME;
        document.title = Constants.FILE_TITLE;
        String response = gatewayDelegate.addDocumentToRequest(document);

        System.out.println(response);
        return response;
    }

    private static void inviteSigners(String fileId) {
        System.out.println("Sending out invitation emails...");

        InviteSigners inviteSigners = new InviteSigners();
        inviteSigners.apiCode = Constants.API_CODE;
        inviteSigners.fileId = fileId;
        String response = gatewayDelegate.inviteSigners(inviteSigners);

        System.out.println(response);
    }

    private static void setSignatureRequestParameters(String fileId) throws JAXBException {
        System.out.println("Setting signature request parameters...");

        SignatureRequestParameters sigReqPara = new SignatureRequestParameters();
        sigReqPara.apiCode = Constants.API_CODE;
        sigReqPara.fileId = fileId;

        SignatureRequestXml signatureRequestXml = new SignatureRequestXml();
        SignatureRequestParameter reqParam1 =
                new SignatureRequestParameter(Constants.REQ_PARAM_1_NAME, Constants.REQ_PARAM_1_VALUE);
        SignatureRequestParameter reqParam2 =
                new SignatureRequestParameter(Constants.REQ_PARAM_2_NAME, Constants.REQ_PARAM_2_VALUE);
        signatureRequestXml.add(reqParam1);
        signatureRequestXml.add(reqParam2);
        sigReqPara.xmlContent = XmlWriter.serializeXml(signatureRequestXml);

        CustomMetadataXml metadataXml = new CustomMetadataXml();
        CustomMetadata metadataParam1 =
                new CustomMetadata(Constants.METADATA_PARAM_1_NAME, Constants.METADATA_PARAM_1_TEXT);
        metadataXml.add(metadataParam1);
        sigReqPara.customMetadataXml = XmlWriter.serializeXml(metadataXml);

        String response = gatewayDelegate.setSignatureRequestParameters(sigReqPara);
        System.out.println(response);
    }

    private static void getFileStatus(String fileId) {
        System.out.println("Getting file status...");

        FileStatus fileStatus = new FileStatus();
        fileStatus.apiCode = Constants.API_CODE;
        fileStatus.fileId = fileId;
        fileStatus.includeDocumentDbXml = true;
        gatewayDelegate.getFileStatus(fileStatus);
    }

    private static void getLink(String fileId, String documentId) {
        System.out.println("Getting links...");

        Link link = new Link();
        link.apiCode = Constants.API_CODE;

        LinkParameter documentSignedLink = new LinkParameter();
        documentSignedLink.setFileId(fileId);
        documentSignedLink.setDocumentId(documentId);
        documentSignedLink.setLinkType(LinkParameterType.DOCUMENT_SIGNED_LINK);
        documentSignedLink.setSignerEmail(Constants.SIGNER_EMAIL_ADDRESS);

        LinkParameter documentPrefillLink = new LinkParameter();
        documentPrefillLink.setFileId(fileId);
        documentPrefillLink.setDocumentId(documentId);
        documentPrefillLink.setLinkType(LinkParameterType.DOCUMENT_PREFILL_LINK);
        documentPrefillLink.setSignerEmail(Constants.SIGNER_EMAIL_ADDRESS);

        LinkParameter fileMaintenanceLink = new LinkParameter();
        fileMaintenanceLink.setFileId(fileId);
        fileMaintenanceLink.setDocumentId(documentId);
        fileMaintenanceLink.setLinkType(LinkParameterType.FILE_MAINTENANCE_LINK);
        fileMaintenanceLink.setSignerEmail(Constants.SIGNER_EMAIL_ADDRESS);

        LinkParameter secureFileMaintenanceLink = new LinkParameter();
        secureFileMaintenanceLink.setFileId(fileId);
        secureFileMaintenanceLink.setDocumentId(documentId);
        secureFileMaintenanceLink.setLinkType(LinkParameterType.SECURE_FILE_MAINTENANCE_LINK);
        secureFileMaintenanceLink.setSignerEmail(Constants.SIGNER_EMAIL_ADDRESS);

        ArrayOfLinkParameter linkParameterArray = new ArrayOfLinkParameter();
        linkParameterArray.getLinkParameter().add(documentSignedLink);
        linkParameterArray.getLinkParameter().add(documentPrefillLink);
        linkParameterArray.getLinkParameter().add(fileMaintenanceLink);
        linkParameterArray.getLinkParameter().add(secureFileMaintenanceLink);
        link.linkParameters = linkParameterArray;

        ArrayOfUrlQueryResult resultArray = gatewayDelegate.getLink(link);
        List<UrlQueryResult> resultList = resultArray.getUrlQueryResult();
        for (UrlQueryResult result : resultList)
            System.out.println(result.getLinkType() + ": "+ result.getLink());
    }

    private static void createPayment(String fileId) {
        System.out.println("Creating payments...");

        Payment payment = new Payment();
        payment.apiCode = Constants.API_CODE;
        payment.fileId = fileId;
        payment.amount = BigDecimal.ONE;
        payment.description = Constants.PAYMENT_DESC_PAY;
        payment.recurrence = PaymentReccurence.ONE_TIME;
        payment.datePaymentDue = Constants.DATE_PAYMENT_DUE;
        payment.operation = PaymentOperationType.PAY;
        String payResponse = gatewayDelegate.createPayment(payment);

        System.out.println(payResponse);

        Payment auth = new Payment();
        auth.apiCode = Constants.API_CODE;
        auth.fileId = fileId;
        auth.amount = BigDecimal.ZERO;
        auth.description = Constants.PAYMENT_DESC_AUTH;
        auth.recurrence = PaymentReccurence.ONE_TIME;
        auth.datePaymentDue = Constants.DATE_PAYMENT_DUE;
        auth.operation = PaymentOperationType.AUTHORIZE;
        String authResponse = gatewayDelegate.createPayment(auth);

        System.out.println(authResponse);
    }

    private static void addLocation(String fileId, String documentId) {
        System.out.println("Adding location fields to document...");

        Location signLocation = new Location();
        signLocation.apiCode = Constants.API_CODE;
        signLocation.fileId = fileId;
        signLocation.documentId = documentId;
        signLocation.page = Constants.PAGE_1;
        signLocation.top = Constants.SIGN_TOP;
        signLocation.left = Constants.SIGN_LEFT;
        signLocation.signerEmail = Constants.SIGNER_EMAIL_ADDRESS;
        signLocation.fieldType = Constants.FIELD_TYPE_SIGNATURE;
        signLocation.sequence = Constants.SEQUENCE_LEVEL_1;
        String signResponse = gatewayDelegate.addLocation(signLocation);

        System.out.println(signResponse);

        Location authLocation = new Location();
        authLocation.apiCode = Constants.API_CODE;
        authLocation.fileId = fileId;
        authLocation.documentId = documentId;
        authLocation.page = Constants.PAGE_1;
        authLocation.top = Constants.AUTH_TOP;
        authLocation.left = Constants.AUTH_LEFT;
        authLocation.signerEmail = Constants.SIGNER_EMAIL_ADDRESS;
        authLocation.fieldType = Constants.FIELD_TYPE_AUTH;
        authLocation.sequence = Constants.SEQUENCE_LEVEL_1;
        String authResponse = gatewayDelegate.addLocation(authLocation);

        System.out.println(authResponse);
    }
}
