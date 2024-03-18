package readservice;
import org.example.Entity.Transactions;
import javax.xml.ws.Endpoint;

public class EndPoint {
    private static String url="http://localhost:1090/transactions";
    public static void main(String[] args) {
        TransactionByName transactionByUsername=new TransactionByName();
        System.out.println("Webservice hosted @ "+url);
        Endpoint.publish(url,transactionByUsername);
    }
}
