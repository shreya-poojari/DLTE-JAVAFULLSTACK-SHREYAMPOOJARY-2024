
package soap.dao;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SoapService", targetNamespace = "http://dao.soap/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SoapService {


    /**
     * 
     * @param date
     * @param string7
     * @param long2
     * @param string8
     * @param string5
     * @param long1
     * @param string6
     * @param string4
     * @param string1
     * @param string2
     */
    @WebMethod
    @Action(input = "http://dao.soap/SoapService/updateAccountRequest", output = "http://dao.soap/SoapService/updateAccountResponse")
    public void updateAccount(
        @WebParam(name = "String1", partName = "String1")
        String string1,
        @WebParam(name = "String2", partName = "String2")
        String string2,
        @WebParam(name = "Date", partName = "Date")
        XMLGregorianCalendar date,
        @WebParam(name = "String4", partName = "String4")
        String string4,
        @WebParam(name = "String5", partName = "String5")
        String string5,
        @WebParam(name = "Long1", partName = "Long1")
        long long1,
        @WebParam(name = "String6", partName = "String6")
        String string6,
        @WebParam(name = "String7", partName = "String7")
        String string7,
        @WebParam(name = "String8", partName = "String8")
        String string8,
        @WebParam(name = "Long2", partName = "Long2")
        long long2);

    /**
     * 
     * @param date
     * @param string5
     * @param long1
     * @param string4
     * @param string1
     * @param string2
     */
    @WebMethod
    @Action(input = "http://dao.soap/SoapService/createAccountRequest", output = "http://dao.soap/SoapService/createAccountResponse")
    public void createAccount(
        @WebParam(name = "String1", partName = "String1")
        String string1,
        @WebParam(name = "String2", partName = "String2")
        String string2,
        @WebParam(name = "Date", partName = "Date")
        XMLGregorianCalendar date,
        @WebParam(name = "String4", partName = "String4")
        String string4,
        @WebParam(name = "String5", partName = "String5")
        String string5,
        @WebParam(name = "Long1", partName = "Long1")
        long long1);

    /**
     * 
     * @param string
     * @return
     *     returns soap.dao.FetchAccount
     */
    @WebMethod
    @WebResult(name = "FindByUsername", partName = "FindByUsername")
    @Action(input = "http://dao.soap/SoapService/findUserRequest", output = "http://dao.soap/SoapService/findUserResponse")
    public FetchAccount findUser(
        @WebParam(name = "String", partName = "String")
        String string);

}
