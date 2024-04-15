
package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EmployeeWebServiceImplementation", targetNamespace = "http://service/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeWebServiceImplementation {


    /**
     * 
     * @param pinCode
     * @return
     *     returns service.EmployeewebService
     */
    @WebMethod
    @WebResult(name = "employee", partName = "employee")
    @Action(input = "http://service/EmployeeWebServiceImplementation/displayBasedOnPinCodeRequest", output = "http://service/EmployeeWebServiceImplementation/displayBasedOnPinCodeResponse")
    public EmployeewebService displayBasedOnPinCode(
        @WebParam(name = "pinCode", partName = "pinCode")
        int pinCode);

}