<?php
$wsdl = "https://apps.sertifi.net/Services/Gateway.asmx?WSDL";
$client = new soapclient($wsdl, array('trace' => 1)); // remove secondary parameter for production code
$apiCode = "your-API-code-goes-here";

// CreateSignatureRequest method call
$params = array( 'pstr_APICode' => $apiCode, 'pstr_SenderEmail' => "test@yourdomain.com",
'pstr_SenderName' => "Test User", 'pstr_FileName' => "Test Agreement", 'pstr_Signers' => "test@yourdomain.com", 'pstr_SecondSigners' => "",
'pstr_CCs' => "",'pstr_Cosign' => "false",'pstr_SignType' => "both", 'pstr_Password' => "", 'pstr_Field1' => "", 'pstr_Field2' => "", 'pstr_Field3' => "",
'pstr_Field4' => "", 'pstr_EmailMessage' => "");
$file_id = $client->CreateSignatureRequest($params);
echo "<br/> file id = " .$file_id->CreateSignatureRequestResult ."<br/>"; // debugging info

// AddPrepopulatedPdfToRequestResult method call
$pdf_id = "PDF_ID"; // this is taken from the sertifi dashboard, once a fillable pdf is uploaded
$address = "address";
$merchant_name = "name";
$xmlStr = "<?xml version=\"1.0\" encoding=\"us-ascii\"?><record><field Name=\"merchant_name\" Text=\"".$merchant_name."\" /><field Name=\"address\" Text=\"".$address."\" /></record>";
$pdf_request_params = array( 'pstr_APICode' => $apiCode, 'pstr_FileID' => $file_id->CreateSignatureRequestResult,
	'pstr_PdfID' => $pdf_id, 'pstr_Title' => "Agreement", 'pstr_Xml' => $xmlStr);
$Document_ID = $client->AddPrepopulatedPdfToRequest($pdf_request_params);
echo "<br/>Document Id = " .$Document_ID->AddPrepopulatedPdfToRequestResult ."<br/>";  // debugging info

// AddDocumentToRequest method call
$filename = str_replace("sertifi_example.php", "", $_SERVER['SCRIPT_FILENAME']) ."/FileName.pdf"; // this should get the physical file path
echo "<br/>filename = " .$filename ."<br/>";
$fileBinary = fread(fopen($filename, "r"), filesize($filename)); // pass in the binary, the php soap library will convert it for you (don't double convert!)
$adddocumenttorequest_params = array('pstr_APICode' => $apiCode, 'pstr_FileID' => $file_id->CreateSignatureRequestResult,
									'pbyt_File' => $fileBinary, 'pstr_FileName' => "FileName.pdf", 'pstr_Title' => "Your File Title");
$AddDocumentToRequestResponse = $client->AddDocumentToRequest($adddocumenttorequest_params);
echo "<br/> Add Document to Request Response: " .$AddDocumentToRequestResponse->AddDocumentToRequestResult;


// GetLink method call
$array_of_link_params = array(
	'LinkParameter' => array('FileId' => $file_id->CreateSignatureRequestResult, 'DocumentId' => $Document_ID->AddPrepopulatedPdfToRequestResult,
		'LinkType' => "SigningPageLink", 'SignerEmail' => "test@yourdomain.com"));
$get_link_parameters = array( 'p_APICode' => $apiCode, 'parameters' => $array_of_link_params);
$iframe_link = $client->GetLink($get_link_parameters);
echo "<br/> Link: " .$iframe_link->GetLinkResult->UrlQueryResult->Link ."<br/>";  // debugging info

// SetRedirectURL method call
$set_redirect_params = array( 'p_APICode' => $apiCode, 'p_FileID' => $file_id->CreateSignatureRequestResult,
	'p_redirectUrl' => "http://www.yourdomain.com");
$response = $client->SetRedirectURL($set_redirect_params);
		   
// DownloadSignedDocument method call
$download_params = array( 'pstr_APICode' => $apiCode, 'pstr_FileID' => $file_id->CreateSignatureRequestResult,
	'pstr_DocumentID' => $Document_ID->AddPrepopulatedPdfToRequestResult);
$file = $client->DownloadSignedDocument($download_params);

?>