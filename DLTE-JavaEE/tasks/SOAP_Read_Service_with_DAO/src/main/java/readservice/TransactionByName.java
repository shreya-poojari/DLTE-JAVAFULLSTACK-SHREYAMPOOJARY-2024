package readservice;

import org.example.Middleware.DatabaseTarget;
import org.example.Services.UserDetailsServices;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class TransactionByName {
   TransactionFetch fetchTransactions = new TransactionFetch();
    UserDetailsServices services;
    public TransactionByName() {

        services = new UserDetailsServices(new DatabaseTarget());
    }

    @WebResult(name = "FetchTrannsactions")
    public TransactionFetch findAllByUsers(String username){
        fetchTransactions.setTransactionsList(services.callFindAllByUsers(username));
        return  fetchTransactions;
    }
}
