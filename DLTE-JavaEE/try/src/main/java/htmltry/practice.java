package htmltry;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class practice {

    //http://localhost:7001/DLTE-JavaEE-1/
    @WebServlet("/test")
    public static class TransactionServlet extends HttpServlet {
        // Sample transaction data
        List<Transaction> transactionList = Stream.of(
                new Transaction(new Date(2024,4,12), 10000.0, "shreya", "Family"),
        ).collect(Collectors.toList());

        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter writer = resp.getWriter();

            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Transactions</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Transactions</h1>");

            for (Transaction transaction : transactionList) {
                writer.println("<div>");
                writer.println("<p>Date: " + transaction.getDateOfTransaction() + "</p>");
                writer.println("<p>Amount: " + transaction.getAmountInTransaction() + "</p>");
                writer.println("<p>Name: " + transaction.getTo() + "</p>");
                writer.println("<p>Type: " + transaction.getRemarks() + "</p>");
                writer.println("</div>");
                writer.println("<br>");
            }
            writer.println("</body>");
            writer.println("</html>");
            // Set status to OK
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Gson gson=new Gson();
            Transaction transaction = gson.fromJson(req.getReader(),Transaction.class);
            transactionList.add(transaction);
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter writer = resp.getWriter();

            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Transaction Insertion</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Transaction Added</h1>");
            writer.println("<p>" + transaction.getTo() + " has been added to the records.</p>");
            writer.println("</body>");
            writer.println("</html>");
            // Set status to OK
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }


}
