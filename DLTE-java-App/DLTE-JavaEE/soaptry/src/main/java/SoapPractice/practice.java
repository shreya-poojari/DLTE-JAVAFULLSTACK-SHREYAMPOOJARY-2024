package SoapPractice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class practice {
    List<String> defaulters;
    public practice(){
        defaulters= Stream.of("Annapoorna","Medhini","Arundhathi","Akash","Prashant","Sanath").collect(Collectors.toList());
    }
    @WebMethod
    public String addDeafulter(String name){
        defaulters.add(name);
        return name+" has added to the defaulters record";
    }
}
