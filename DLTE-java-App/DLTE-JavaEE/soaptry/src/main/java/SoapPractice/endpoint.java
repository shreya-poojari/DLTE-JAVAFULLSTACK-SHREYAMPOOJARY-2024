package SoapPractice;

import javax.xml.ws.Endpoint;

public class endpoint {
    private static String url="http://localhost:1000/shreya";
    public static void main(String[] args) {
        practice Practice=new practice();
        System.out.println("SOAP webservice running "+url);
        Endpoint.publish(url,Practice);
    }
}
