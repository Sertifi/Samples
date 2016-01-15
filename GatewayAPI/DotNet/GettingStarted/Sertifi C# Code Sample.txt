using System;
using System.Collections.Generic;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;

namespace SertifiAPIExample
{
    public partial class _Default : System.Web.UI.Page
    {
        //Assign the API Code from the Gateway Kit here
        private const string _APICode = "<API Code from Gateway Welcome Kit>";
        private const string _pdfId = "PDF ID found in document library or provided by Sertifi";

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnCreateRequest_Click(object sender, EventArgs e)
        {
            SertifiAPI.Gateway sertifiAPIRequest = new SertifiAPIExample.SertifiAPI.Gateway();

            //create a request by calling the sertifi API
            string fileID = sertifiAPIRequest.CreateSignatureRequest(
                                _APICode,
                                txtSenderEmail.Text,
                                txtSenderName.Text,
                                txtFileName.Text,
                                txtSigners.Text,
                                txtSecondSigners.Text,
                                txtCCs.Text,
                                rblCosign.SelectedValue,
                                rblSignType.SelectedValue,
                                txtPassword.Text,
                                txtField1.Text,
                                txtField2.Text,
                                txtField3.Text,
                                txtField4.Text,
                                txtEmailMessage.Text);


            string documentID;
            //If you already have a document in your application, you can upload it using AddDocumentToRequest call.
            //FileInfo fileToUpload = new FileInfo(Server.MapPath("PDF name"));
            //byte[] content = File.ReadAllBytes(fileToUpload.FullName);
            //documentID = sertifiAPIRequest.AddDocumentToRequest(_APICode, fileID, content, fileToUpload.Name, "FirstName LastName");

            //Using AddPrepopulatedPdfToRequest call
            string prefillContentInXMLFormat = "<?xml version='1.0' encoding='utf-8'?><record><field Name='First Name' Text='Test Name' /></record>";
            documentID = sertifiAPIRequest.AddPrepopulatedPdfToRequest(_APICode, fileID, _pdfId, "FirstName LastName", prefillContentInXMLFormat);
   
            //After a document is added to the file, you can invite signers to send them a signing link
            //sertifiAPIRequest.InviteSigners(_APICode, fileID, String.Empty);

            //To get the signing link, call  GetLink method
            //Assuming txtSigners.Text contains only one email address
            string signingLink = sertifiAPIRequest.GetSigningLink(_APICode, fileID, txtSigners.Text);
            lnkSigningLink.NavigateUrl = signingLink;
            lnkSigningLink.Text = signingLink;
            
        }
    }
}
