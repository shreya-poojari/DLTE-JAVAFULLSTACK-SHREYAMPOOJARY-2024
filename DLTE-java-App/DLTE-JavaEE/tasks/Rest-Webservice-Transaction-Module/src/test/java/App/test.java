package App;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import webservice.Transaction;
import webservice.details;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class test {
    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private StringWriter stringWriter;
    @Mock
    private PrintWriter printWriter;


    @Before
    public void initiate() throws IOException {
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

    }

    @Test
    public void testFindAll() throws ServletException, IOException {
        details transaction=new details();
        details.userInfoServices=services;
        StringBuilder builder = new StringBuilder("Deposit,0,");
        builder.append(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
        transactionOne.add(builder);
        //details customer1 = new details("shreya","shre123","mudbidri","shrey@gmail.com",789267177L,23400L,transactionOne);
       // details customer2=new details("kavya", "kav123", "udupi", "kav@gmail", 987455335L, 1986L,transactionOne);
        details customer3=new details("snehal", "sne123", "Mangalore", "sne@gmail", 987455335L, 1560L,transactionOne);
        List<details> detailsList = Stream.of(customer3).collect(Collectors.toList());

        when(services.callFindAll()).thenReturn(detailsList);
        transaction.doGet(request,response);

        verify(response).setContentType("application/json");

        verify(services).callFindAll();
        System.out.println(services.callFindAll());

        assertEquals("test: ","[Customer{username='snehal', password='sne123', address='Manglore', email='sne@gmail.com', contact=789267177, initialBalace=1560, transactionDetails=[Deposit,0,19-03-2024]}",stringWriter.toString().trim());

    }

    @Test
    public void testFindUser() throws ServletException, IOException {
        details transaction=new details();
        transaction.userInfoServices=services;
        StringBuilder builder = new StringBuilder("Deposit,0,");
        builder.append(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
        transactionOne.add(builder);
       // details customer1 = new details("shreya","shre123","mudbidri","shrey@gmail.com",789267177L,23400L,transactionOne);
        details customer2=new details("kavya", "kav123", "udupi", "kav@gmail", 987455335L, 1986L,transactionOne);
        //details customer3=new details("snehal", "sne123", "Mangalore", "sne@gmail", 987455335L, 1560L,transactionOne);

        List<details> customerList = Stream.of(customer2).collect(Collectors.toList());

        when(request.getParameter("username")).thenReturn("rakesh");
        when(services.callOneUserTransact(anyString())).thenReturn(customerList);
        transaction.doGet(request,response);

        verify(response).setContentType("application/json");

        verify(services).callOneUserTransact(anyString());
        assertEquals("expected","[Customer{username='kavya', password='kav123', address='udupi', email='kav@gmail', contact=987455335, initialBalace=1986, transactionDetails=[Deposit,0,19-03-2024]}]",stringWriter.toString().trim());
    }

    @Test
    public void findByDate() throws ServletException, IOException {
        details transaction=new details();
        transaction.userInfoServices=services;
        StringBuilder builder = new StringBuilder("Deposit,0,");
        builder.append(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
        transactionOne.add(builder);
        details customer1 = new details("shreya","shre123","mudbidri","shrey@gmail.com",789267177L,23400L,transactionOne);
        //details customer2=new details("kavya", "kav123", "udupi", "kav@gmail", 987455335L, 1986L,transactionOne);
       // details customer3=new details("snehal", "sne123", "Mangalore", "sne@gmail", 987455335L, 1560L,transactionOne);

        List<details> customerList = Stream.of(customer1).collect(Collectors.toList());
        when(request.getParameter("username")).thenReturn("prasha02");
        when(request.getParameter("date")).thenReturn("19-03-2024");
        when(services.callTransactionByDate(anyString(),anyString())).thenReturn(customerList);
        transaction.doGet(request,response);
        verify(response).setContentType("application/json");
        verify(services).callTransactionByDate(anyString(),anyString());
        assertNotEquals("Expected","[Customer{username='shreya', password='shre321', address='mudbidri', email='shrey@gmail.com', contact=789267177, initialBalace=23400, transactionDetails=[Deposit,0,19-03-2024]}",stringWriter.toString().trim());
    }
}
