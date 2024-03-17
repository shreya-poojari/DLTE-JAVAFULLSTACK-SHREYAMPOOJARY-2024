package webservice;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/transaction/webservice/*")
public class Transaction extends HttpServlet {
    List<details> transactionList = Stream.of(new details(new Date(2024,7,28),58741.00,"shreya","Friend"),
            new details(new Date(2024,5,5),52364.00,"snehal","family"),
            new details(new Date(2024,2,8),98546.00,"kavya","studies"),
            new details(new Date(2024,11,25),32156.00,"dhanush","hospital"),
            new details(new Date(2024,9,30),12547.00,"sumanth","Food")).collect(Collectors.toList());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //initializing the parameters in url
        String minimumAmount = req.getParameter("minimum");
        String maxAmount = req.getParameter("maximum");

        if (minimumAmount!= null && maxAmount != null) {
            double minimum = Double.parseDouble(minimumAmount);
            double maximum = Double.parseDouble(maxAmount);

            List<details> detail = transactionList.stream()
                    .filter(each -> each.getAmountInTransaction() >= minimum && each.getAmountInTransaction() <= maximum)
                    .collect(Collectors.toList());

            Gson gson = new Gson();
            resp.setContentType("application/json");
            String transactionJson = gson.toJson(detail);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(transactionJson);
        } else {

            Gson gson = new Gson();
            resp.setContentType("application/json");
            String transJson = gson.toJson(transactionList);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(transJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //creating Transaction
        Gson gson=new Gson();

        details detail = gson.fromJson(req.getReader(),details.class);
        transactionList.add(detail);

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(detail.getTo()+" has added to the records");
    }
    ArrayList<details> transactions= (ArrayList<details>) Stream.of(
            new details(new Date(2024,11,15),1234.0,"shreya","Family"),
            new details(new Date(2024,9,25),9876.0,"Snehal","Friend"),
            new details(new Date(2024,12,5),9856.0,"kavya","Education"),
            new details(new Date(2024,5,19),2345.0,"sumanth","Emergency"),
            new details(new Date(2024,7,3),8734.0,"dhanush","food"),
            new details(new Date(2024,1,12),3333.0,"anith","Friend")
    ).collect(Collectors.toList());
}
