package methods;

import org.backend.EmployeePersonalDetails;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

public interface EmployeeWebservice {
    boolean isEstablished();
    void create(List<EmployeePersonalDetails> list);
    List<EmployeePersonalDetails> displayBasedOnEmployeeId(String employeeId);
    List<EmployeePersonalDetails> displayBasedOnPinCode(int pinCode);
    List<EmployeePersonalDetails> read();
    boolean Validation(List<EmployeePersonalDetails> employees);
    void closeConnections();
    @WebService
    public interface EmployeewebService {
        @WebMethod
        boolean isEstablished();
        @WebMethod
        void create(List<EmployeePersonalDetails> list);
        @WebMethod
        EmployeePersonalDetails displayBasedOnEmployeeId(String employeeId);
        @WebMethod
        List<EmployeePersonalDetails> displayBasedOnPinCode(int pinCode);
        @WebMethod
        List<EmployeePersonalDetails> read();
        @WebMethod
        boolean Validationofdata(List<EmployeePersonalDetails> employees);
        @WebMethod
        void closeConnections();
    }
}
