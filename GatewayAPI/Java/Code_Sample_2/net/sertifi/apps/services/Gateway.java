
package net.sertifi.apps.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Gateway", targetNamespace = "http://apps.sertifi.net/services/", wsdlLocation = "https://sandbox.sertifi.net/abeltest/Services/Gateway.asmx?WSDL")
public class Gateway
    extends Service
{

    private final static URL GATEWAY_WSDL_LOCATION;
    private final static WebServiceException GATEWAY_EXCEPTION;
    private final static QName GATEWAY_QNAME = new QName("http://apps.sertifi.net/services/", "Gateway");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.sertifi.net/abeltest/Services/Gateway.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GATEWAY_WSDL_LOCATION = url;
        GATEWAY_EXCEPTION = e;
    }

    public Gateway() {
        super(__getWsdlLocation(), GATEWAY_QNAME);
    }

    public Gateway(WebServiceFeature... features) {
        super(__getWsdlLocation(), GATEWAY_QNAME, features);
    }

    public Gateway(URL wsdlLocation) {
        super(wsdlLocation, GATEWAY_QNAME);
    }

    public Gateway(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GATEWAY_QNAME, features);
    }

    public Gateway(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Gateway(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GatewaySoap
     */
    @WebEndpoint(name = "GatewaySoap")
    public GatewaySoap getGatewaySoap() {
        return super.getPort(new QName("http://apps.sertifi.net/services/", "GatewaySoap"), GatewaySoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GatewaySoap
     */
    @WebEndpoint(name = "GatewaySoap")
    public GatewaySoap getGatewaySoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://apps.sertifi.net/services/", "GatewaySoap"), GatewaySoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GATEWAY_EXCEPTION!= null) {
            throw GATEWAY_EXCEPTION;
        }
        return GATEWAY_WSDL_LOCATION;
    }

}
