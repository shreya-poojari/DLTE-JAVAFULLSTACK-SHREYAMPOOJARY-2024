
package service;

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
@WebServiceClient(name = "EmployeeWebServiceImplementationService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:1005/employee?wsdl")
public class EmployeeWebServiceImplementationService
    extends Service
{

    private final static URL EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_EXCEPTION;
    private final static QName EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_QNAME = new QName("http://service/", "EmployeeWebServiceImplementationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:1005/employee?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_WSDL_LOCATION = url;
        EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_EXCEPTION = e;
    }

    public EmployeeWebServiceImplementationService() {
        super(__getWsdlLocation(), EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_QNAME);
    }

    public EmployeeWebServiceImplementationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public EmployeeWebServiceImplementationService(URL wsdlLocation) {
        super(wsdlLocation, EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_QNAME);
    }

    public EmployeeWebServiceImplementationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public EmployeeWebServiceImplementationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeWebServiceImplementationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EmployeeWebServiceImplementation
     */
    @WebEndpoint(name = "EmployeeWebServiceImplementationPort")
    public EmployeeWebServiceImplementation getEmployeeWebServiceImplementationPort() {
        return super.getPort(new QName("http://service/", "EmployeeWebServiceImplementationPort"), EmployeeWebServiceImplementation.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeWebServiceImplementation
     */
    @WebEndpoint(name = "EmployeeWebServiceImplementationPort")
    public EmployeeWebServiceImplementation getEmployeeWebServiceImplementationPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service/", "EmployeeWebServiceImplementationPort"), EmployeeWebServiceImplementation.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_EXCEPTION!= null) {
            throw EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_EXCEPTION;
        }
        return EMPLOYEEWEBSERVICEIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    }

}
