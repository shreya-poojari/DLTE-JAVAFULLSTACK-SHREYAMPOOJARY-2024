package App;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import webservice.Transaction;
import webservice.details;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class test {
    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private StringWriter stringWriter;

    @Mock
    private PrintWriter printWriter;

    @Before
    public void initiate() throws IOException {
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void testDoGet() throws Exception {
        List<details> transactionList = Stream.of(
                new details(new Date("6/5/2024"),52364.00,"snehal","family"),
                new details(new Date("3/8/2024"),12547.00,"sumanth","food")
        ).collect(Collectors.toList());

        Transaction transaction = new Transaction();
        transaction.transactionList= (ArrayList<details>) transactionList;
        when(httpServletRequest.getParameter("Maximum")).thenReturn("1000");
        when(httpServletRequest.getParameter("Minimum")).thenReturn("0");

        transaction.doGet(httpServletRequest, httpServletResponse);

        verify(httpServletResponse).setContentType("application/json");
        assertEquals("Expected response", "[{\"dateOfTransaction\":\"Jun 5, 2024 12:00:00 AM\",\"amountInTransaction\":52364.0,\"to\":\"snehal\",\"remarks\":\"family\"},{\"dateOfTransaction\":\"Mar 8, 2024 12:00:00 AM\",\"amountInTransaction\":12547.0,\"to\":\"sumanth\",\"remarks\":\"food\"}]", stringWriter.toString().trim());
    }

    @Test
    public void testDoPost() throws Exception {

        Transaction transaction = new Transaction();
        Gson gson = new Gson();
        details Details = new details(new Date("3/8/2024"),12547.00,"sumanth","food");
        String jsonDetails = gson.toJson(Details);


        BufferedReader bufferedReader = new BufferedReader(new java.io.StringReader(jsonDetails));
        when(httpServletRequest.getReader()).thenReturn(bufferedReader);


        transaction.doPost(httpServletRequest, httpServletResponse);


        verify(httpServletResponse).setStatus(HttpServletResponse.SC_OK);
        verify(printWriter).println("transaction has been done");
    }
}
