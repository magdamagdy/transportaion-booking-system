
package vehicleSoapClient;

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
@WebServiceClient(name = "vehicleSoapClientService", targetNamespace = "http://client.soap.service.transportationbookingsystem.exalt.com/", wsdlLocation = "http://DESKTOP-VK3DF3H:8080/transportation-booking-system-1.0-SNAPSHOT/vehicleSoapClientService?wsdl")
public class VehicleSoapClientService
    extends Service
{

    private final static URL VEHICLESOAPCLIENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException VEHICLESOAPCLIENTSERVICE_EXCEPTION;
    private final static QName VEHICLESOAPCLIENTSERVICE_QNAME = new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "vehicleSoapClientService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://DESKTOP-VK3DF3H:8080/transportation-booking-system-1.0-SNAPSHOT/vehicleSoapClientService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VEHICLESOAPCLIENTSERVICE_WSDL_LOCATION = url;
        VEHICLESOAPCLIENTSERVICE_EXCEPTION = e;
    }

    public VehicleSoapClientService() {
        super(__getWsdlLocation(), VEHICLESOAPCLIENTSERVICE_QNAME);
    }

    public VehicleSoapClientService(WebServiceFeature... features) {
        super(__getWsdlLocation(), VEHICLESOAPCLIENTSERVICE_QNAME, features);
    }

    public VehicleSoapClientService(URL wsdlLocation) {
        super(wsdlLocation, VEHICLESOAPCLIENTSERVICE_QNAME);
    }

    public VehicleSoapClientService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, VEHICLESOAPCLIENTSERVICE_QNAME, features);
    }

    public VehicleSoapClientService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VehicleSoapClientService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns VehicleSoapClient
     */
    @WebEndpoint(name = "vehicleSoapClientPort")
    public vehicleSoapClient.VehicleSoapClient getVehicleSoapClientPort() {
        return super.getPort(new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "vehicleSoapClientPort"), VehicleSoapClient.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VehicleSoapClient
     */
    @WebEndpoint(name = "vehicleSoapClientPort")
    public VehicleSoapClient getVehicleSoapClientPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://client.soap.service.transportationbookingsystem.exalt.com/", "vehicleSoapClientPort"), VehicleSoapClient.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VEHICLESOAPCLIENTSERVICE_EXCEPTION!= null) {
            throw VEHICLESOAPCLIENTSERVICE_EXCEPTION;
        }
        return VEHICLESOAPCLIENTSERVICE_WSDL_LOCATION;
    }

}
