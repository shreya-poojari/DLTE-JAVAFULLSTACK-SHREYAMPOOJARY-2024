
package org.example.readservice;

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
@WebService(name = "TransactionByName", targetNamespace = "http://readservice/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TransactionByName {


    /**
     * 
     * @param arg0
     * @return
     *     returns readservice.TransactionFetch
     */
    @WebMethod
    @WebResult(name = "FetchTrannsactions", partName = "FetchTrannsactions")
    @Action(input = "http://readservice/TransactionByName/findAllByUsersRequest", output = "http://readservice/TransactionByName/findAllByUsersResponse")
    public TransactionFetch findAllByUsers(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
