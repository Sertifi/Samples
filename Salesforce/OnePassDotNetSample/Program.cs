using OnePassSample.SfPartnerApi;
using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace OnePassSample
{
    class Program
    {
        static string _login = @"nstojka@67demo.com";
        static string _password = @"";
        static string _settingsName = "Settings"; //name of the custom settings object
        static string _linkedOpportunityId = "006F000000XLe0S"; //id of the opportunity to which this contract is tied
        static string _folderName = "Test Invites " + DateTime.Now;
        static string _signer = "mdragilev@sertifi.com";

        static readonly string _oneCallTemplate = 
            @"<s:Envelope xmlns:s=""http://schemas.xmlsoap.org/soap/envelope/"">
	            <s:Header>
		            <h:SessionHeader xmlns:h=""http://soap.sforce.com/schemas/class/Sertifi2_0/SertifiSFAPI"" xmlns=""http://soap.sforce.com/schemas/class/Sertifi2_0/SertifiSFAPI"" xmlns:xsd=""http://www.w3.org/2001/XMLSchema"" xmlns:xsi=""http://www.w3.org/2001/XMLSchema-instance"">
			            <sessionId>{sessionId}</sessionId>
		            </h:SessionHeader>
	            </s:Header>
	            <s:Body xmlns:xsi=""http://www.w3.org/2001/XMLSchema-instance"" xmlns:xsd=""http://www.w3.org/2001/XMLSchema"">
		            <sendEContractToSertifi xmlns=""http://soap.sforce.com/schemas/class/Sertifi2_0/SertifiSFAPI"">
			            <EContractID>{contractId}</EContractID>
			            {settings}
		            </sendEContractToSertifi>
	            </s:Body>
            </s:Envelope>";

        SfPartnerApi.SoapClient _partnerClient = new SfPartnerApi.SoapClient();
        string _sessionId;
        string _serverUrl;

        static void Main(string[] args)
        {
            new Program().OnePassExample();

        }

        private void OnePassExample()
        {
            login(); //creates a session

            string contractId = createContract(); //creates a contract which is a parent object
            string docId = createDocument(contractId); //crates a document to be signed
            string contactId = createContact(contractId, _signer); //creates a signer object
            var settings = findSettings(); //finds the appropriate settings
            string sendResults = sendForSignature(contractId, settings); //sends the document for signature

            Console.WriteLine("Results: " + sendResults);

            Console.WriteLine("Press ENTER to continue");
            Console.ReadLine();
        }

        /// <summary>
        /// Sends the document for signature and parses the results.
        /// </summary>
        /// <param name="contractId"></param>
        /// <param name="settings"></param>
        /// <returns></returns>
        private string sendForSignature(string contractId, sObject settings)
        {
            UriBuilder uri = new UriBuilder(_serverUrl);
            uri.Path = "/services/Soap/class/Sertifi2_0/SertifiSFAPI";
            HttpWebRequest request = CreateWebRequest(uri.ToString());

            //copies the settings sObject to be sent to Sertifi API
            XElement root = new XElement("settings");
            foreach (var item in settings.Any)
            {
                var element = XElement.Parse(item.OuterXml);
                root.Add(element);
            }

            var content = _oneCallTemplate
                .Replace("{sessionId}", _sessionId)
                .Replace("{contractId}", contractId)
                .Replace("{settings}", root.ToString());


            using (Stream stream = request.GetRequestStream())
            {
                var byteContent = UTF8Encoding.UTF8.GetBytes(content);
                stream.Write(byteContent, 0, byteContent.Length);
            }

            using (WebResponse response = request.GetResponse())
            {
                var xdoc = XDocument.Load(response.GetResponseStream());
                var result = xdoc.Descendants().Where(d=>d.Name.LocalName == "result").First().Value;
                return result;
            }
        }

        /// <summary>
        /// Create a soap webrequest to [Url]
        /// </summary>
        /// <returns></returns>
        public HttpWebRequest CreateWebRequest(string url)
        {
            HttpWebRequest webRequest = (HttpWebRequest)WebRequest.Create(url);
            webRequest.Headers.Add(@"SOAPAction", "\"\"");
            webRequest.ContentType = "text/xml;charset=utf-8";
            webRequest.Accept = "text/xml";
            webRequest.Method = "POST";
            return webRequest;
        }

        private string createContact(string contractId, string email)
        {
            //find placeholder e-mail as Contact is required on the kusnction object
            var tempContactId = _partnerClient.query(new queryRequest()
            {
                SessionHeader = new SessionHeader() { sessionId = _sessionId },
                queryString = "select id,name,email from Contact where email = 'placeholder@sertifi.com'"
            }).result.records[0].Id;


            var nvList = new NameValueCollection();
            nvList.Add("Sertifi2_0__Contact__c", tempContactId);
            nvList.Add("Sertifi2_0__TestContract__c", contractId);
            nvList.Add("Sertifi2_0__Signer_Order__c", "1");
            nvList.Add("Sertifi2_0__Level_Name__c", "1st Signer");
            nvList.Add("Sertifi2_0__Email__c", email);

            var contact = new sObject();
            contact.type = "Sertifi2_0__ContractContactJunction__c";
            contact.Any = NvListToXmlElement(nvList);

            var resp = _partnerClient.create(new createRequest()
            {
                SessionHeader = new SessionHeader() { sessionId = _sessionId },
                sObjects = new sObject[] { contact }
            }).result;

            var contactId = resp[0].id;
            return contactId;
        }

        private XmlElement[] NvListToXmlElement(NameValueCollection col)
        {
            List<XmlElement> elements = new List<XmlElement>();
            XmlDocument doc = new XmlDocument();
            foreach (string key in col.Keys)
            {
                XmlElement element = doc.CreateElement(key);
                element.InnerText = col[key];
                elements.Add(element);
            }

            return elements.ToArray();
        }

        private string createDocument(string contractId)
        {
            var nvList = new NameValueCollection();
            nvList.Add("Sertifi2_0__TestContract__c", contractId);
            nvList.Add("Sertifi2_0__Name__c", "Test doc");
            nvList.Add("Sertifi2_0__Number_Signed__c", "0");
            nvList.Add("Sertifi2_0__Document_Type__c", "Signing Document");

            var document = new sObject();
            document.type = "Sertifi2_0__EDocument__c";
            document.Any = NvListToXmlElement(nvList);

            var resp = _partnerClient.create(new createRequest()
            {
                SessionHeader = new SessionHeader() { sessionId = _sessionId },
                sObjects = new sObject[] { document }
            }).result;

            var docId = resp[0].id;

            nvList = new NameValueCollection();
            nvList.Add("parentId", docId);
            nvList.Add("name", "TestDoc.pdf");
            nvList.Add("body", Convert.ToBase64String(File.ReadAllBytes("TestDoc.pdf")));

            var attachment = new sObject();
            attachment.type = "Attachment";
            attachment.Any = NvListToXmlElement(nvList);


            var attachResp = _partnerClient.create(new createRequest()
            {
                SessionHeader = new SessionHeader() { sessionId = _sessionId },
                sObjects = new sObject[] { attachment }
            }).result;

            return docId;
        }

        private string createContract()
        {
            var nvList = new NameValueCollection();
            nvList.Add("Name", _folderName);
            nvList.Add("Sertifi2_0__Message__c", "Optional custom invite message");
            nvList.Add("Sertifi2_0__Sign_Type__c", "Electronically");
            nvList.Add("Sertifi2_0__Opportunity__c", _linkedOpportunityId);
            nvList.Add("Sertifi2_0__Open__c", "1");
            nvList.Add("Sertifi2_0__Partiall__c", "0");
            nvList.Add("Sertifi2_0__Signed__c", "0");
            nvList.Add("Sertifi2_0__Settings__c", _settingsName);

            var contract = new sObject();
            contract.type = "Sertifi2_0__TestContract__c";
            contract.Any = NvListToXmlElement(nvList);

            var resp = _partnerClient.create(new createRequest()
            {
                SessionHeader = new SessionHeader() { sessionId = _sessionId },
                sObjects = new sObject[] { contract }
            }).result;

            var id = resp[0].id;
            return id;
        }

        /// <summary>
        /// Logs in into the partner proxy
        /// </summary>
        private void login()
        {
            var loginRequest = new loginRequest()
            {
                username = _login,
                password = _password
            };

            var loginResults = _partnerClient.login(loginRequest).result;
            _sessionId = loginResults.sessionId;
            _serverUrl = loginResults.serverUrl;

            _partnerClient = new SfPartnerApi.SoapClient();
            _partnerClient.Endpoint.Address = new System.ServiceModel.EndpointAddress(_serverUrl);
        }

        /// <summary>
        /// Finds a Sertifi settings object to be used with the one pass method
        /// </summary>
        /// <returns></returns>
        private OnePassSample.SfPartnerApi.sObject findSettings()
        {
            var fields = String.Join(", ", getSObjectFields("Sertifi2_0__SertifiSettings__c").ToArray());
            var searchString = String.Format("select {0} from Sertifi2_0__SertifiSettings__c where Name = '{1}'", 
                fields, _settingsName);
            var results = _partnerClient.query(new SfPartnerApi.queryRequest()
            {
                SessionHeader = new OnePassSample.SfPartnerApi.SessionHeader() { sessionId = _sessionId },
                queryString = searchString
            }).result;

            var settings = results.records[0];
            return settings;
        }

        /// <summary>
        /// Finds all fields belonging to an object
        /// </summary>
        /// <param name="type"></param>
        /// <returns></returns>
        private List<string> getSObjectFields(string type)
        {
            var desc = _partnerClient.describeSObject(
                new SfPartnerApi.describeSObjectRequest()
                {
                    SessionHeader = new OnePassSample.SfPartnerApi.SessionHeader() { sessionId = _sessionId },
                    sObjectType = type
                }).result;

            var fields = desc.fields.Select(f => f.name).ToList();
            return fields;
        }

        
    }
}
