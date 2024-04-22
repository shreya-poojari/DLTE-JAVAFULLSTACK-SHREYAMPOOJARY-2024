package org.example.restService;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Scanner;

public class RestClient {
    private static final String BASE_URL = "http://localhost:6081/employees";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {


            Scanner scanner=new Scanner(System.in);
            String employeeId=scanner.nextLine();
            sendHttpGetRequest(httpClient, BASE_URL + "/employeeId/" + employeeId);

            // Send HTTP GET request to retrieve employees by pin code
//            String pinCode = "576117";
//            sendHttpGetRequest(httpClient, BASE_URL + "/pincode/" + pinCode);
        } finally {
            httpClient.close();
        }
    }

    private static void sendHttpGetRequest(CloseableHttpClient httpClient, String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("HTTP Status Code: " + statusCode);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String json = EntityUtils.toString(entity);
                System.out.println("Response Body:");
                System.out.println(json);

            }
        }
    }
}
