
package TripSoapClient;

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
@WebServiceClient(name = "TripSoapClientServiceService", targetNamespace = "http://Client.SOAP_WebServices/", wsdlLocation = "http://DESKTOP-VK3DF3H:8080/Sample_Project-1.0-SNAPSHOT/TripSoapClientServiceService?wsdl")
public class TripSoapClientServiceService
    extends Service
{

    private final static URL TRIPSOAPCLIENTSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException TRIPSOAPCLIENTSERVICESERVICE_EXCEPTION;
    private final static QName TRIPSOAPCLIENTSERVICESERVICE_QNAME = new QName("http://Client.SOAP_WebServices/", "TripSoapClientServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://DESKTOP-VK3DF3H:8080/Sample_Project-1.0-SNAPSHOT/TripSoapClientServiceService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRIPSOAPCLIENTSERVICESERVICE_WSDL_LOCATION = url;
        TRIPSOAPCLIENTSERVICESERVICE_EXCEPTION = e;
    }

    public TripSoapClientServiceService() {
        super(__getWsdlLocation(), TRIPSOAPCLIENTSERVICESERVICE_QNAME);
    }

    public TripSoapClientServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRIPSOAPCLIENTSERVICESERVICE_QNAME, features);
    }

    public TripSoapClientServiceService(URL wsdlLocation) {
        super(wsdlLocation, TRIPSOAPCLIENTSERVICESERVICE_QNAME);
    }

    public TripSoapClientServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRIPSOAPCLIENTSERVICESERVICE_QNAME, features);
    }

    public TripSoapClientServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TripSoapClientServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns TripSoapClientService
     */
    @WebEndpoint(name = "TripSoapClientServicePort")
    public TripSoapClient.TripSoapClientService getTripSoapClientServicePort() {
        return super.getPort(new QName("http://Client.SOAP_WebServices/", "TripSoapClientServicePort"), TripSoapClientService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TripSoapClientService
     */
    @WebEndpoint(name = "TripSoapClientServicePort")
    public TripSoapClientService getTripSoapClientServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Client.SOAP_WebServices/", "TripSoapClientServicePort"), TripSoapClientService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRIPSOAPCLIENTSERVICESERVICE_EXCEPTION!= null) {
            throw TRIPSOAPCLIENTSERVICESERVICE_EXCEPTION;
        }
        return TRIPSOAPCLIENTSERVICESERVICE_WSDL_LOCATION;
    }

}
