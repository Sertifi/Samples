import models.*;
import net.sertifi.apps.services.ArrayOfUrlQueryResult;
import net.sertifi.apps.services.Gateway;
import net.sertifi.apps.services.GatewaySoap;

public class GatewayDelegate {
    private GatewaySoap gatewaySoap;

    public GatewayDelegate() {
        gatewaySoap = new Gateway().getGatewaySoap();
    }

    public String createSignatureRequest(SignatureRequest signatureRequest) {
        return gatewaySoap.createSignatureRequest(
                signatureRequest.apiCode,
                signatureRequest.senderEmailAddress,
                signatureRequest.senderName,
                signatureRequest.fileName,
                signatureRequest.signerEmailAddress,
                signatureRequest.secondSignerEmailAddress,
                signatureRequest.ccEmailAddress,
                signatureRequest.cosign,
                signatureRequest.signType,
                signatureRequest.password,
                signatureRequest.field1,
                signatureRequest.field2,
                signatureRequest.field3,
                signatureRequest.field4,
                signatureRequest.emailMessage
        );
    }

    public String addSignerToRequest(Signer signer) {
        return gatewaySoap.addSignerToRequest(
                signer.apiCode,
                signer.fileId,
                signer.email,
                signer.sequence
        );
    }

    public String addDocumentToRequest(Document document) {
        return gatewaySoap.addDocumentToRequest(
                document.apiCode,
                document.fileId,
                document.file,
                document.fileName,
                document.title,
                document.xml
        );
    }

    public String inviteSigners(InviteSigners inviteSigners) {
        return gatewaySoap.inviteSigners(
                inviteSigners.apiCode,
                inviteSigners.fileId,
                inviteSigners.emailMessage
        );
    }

    public String addLocation(Location location) {
        return gatewaySoap.addLocation(
                location.apiCode,
                location.fileId,
                location.documentId,
                location.page,
                location.top,
                location.left,
                location.height,
                location.width,
                location.signerEmail,
                location.caption,
                location.fieldType,
                location.sequence
        );
    }

    public String setSignatureRequestParameters(SignatureRequestParameters parameters) {
        return gatewaySoap.setSignatureRequestParameters(
                parameters.apiCode,
                parameters.fileId,
                parameters.xmlContent,
                parameters.customMetadataXml
        );
    }

    public String getFileStatus(FileStatus fileStatus) {
        return gatewaySoap.getFileStatus(
                fileStatus.apiCode,
                fileStatus.fileId,
                fileStatus.includeDocumentDbXml
        );
    }

    public ArrayOfUrlQueryResult getLink(Link link) {
        return gatewaySoap.getLink(
                link.apiCode,
                link.linkParameters
        );
    }

    public String createPayment(Payment payment) {
        return gatewaySoap.createPayment(
                payment.apiCode,
                payment.fileId,
                payment.amount,
                payment.description,
                payment.recurrence,
                payment.datePaymentDue,
                payment.operation
        );
    }
}
