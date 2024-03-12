package WebServlet;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/taxsipcalculator/*")
public class SipTax extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // parameters
        String reqInvestment = req.getParameter("investment");
        String reqReturn = req.getParameter("expectedReturn");
        String reqPeriod = req.getParameter("period");
        String reqIncome = req.getParameter("annualIncome");
        String reqRegime = req.getParameter("regime");

        // SIP
        if (reqInvestment != null && reqReturn != null && reqPeriod != null) {
            double monthlyInvestment = Double.parseDouble(reqInvestment);
            double expectedReturn = Double.parseDouble(reqReturn);
            int totalPeriod = Integer.parseInt(reqPeriod);
            double monthlyInterestRate = expectedReturn / 12 / 100;
            double noOfMonths = 12 * totalPeriod;
            double totalReturn = monthlyInvestment * ((Math.pow((1 + monthlyInterestRate), (noOfMonths)) - 1) * (1 + monthlyInterestRate)) / monthlyInterestRate;
            double totalMoneyInvested = noOfMonths * monthlyInvestment;
            double estimatedReturn = totalReturn - totalMoneyInvested;

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Estimated amount = " + estimatedReturn +
                    ", Total return = " + totalReturn +
                    ", Total investment = " + totalMoneyInvested);
        } else {
            String received = findTax(Double.parseDouble(reqIncome), reqRegime);
            resp.getWriter().println(received);
        }
    }
    //tax 
    public String findTax(Double salary,String regime){
        double taxAmount=0;
        switch(regime) {
            case "old":
                if (salary <= 250000) {
                    System.out.println("No tax to pay");
                } else if (salary > 250000 & salary <= 500000) {
                    System.out.println(" pay an tax of 5%");
                    taxAmount = salary * 0.05;
                    System.out.println("Tax amount =" + taxAmount);
                } else if (salary > 50000 & salary <= 1000000) {
                    System.out.println("pay an tax of 20%");
                    taxAmount = salary * 0.2;
                    System.out.println("Tax amount =" + taxAmount);
                } else {
                    System.out.println("pay an tax of 30%");
                    taxAmount = salary * 0.3;
                    System.out.println("Tax amount =" + taxAmount);
                }
                break;
            case "new":
                if (salary <= 300000) {
                    System.out.println("No tax to pay");
                } else if (salary >= 300001 & salary <= 600000) {
                    System.out.println("pay an tax of 5%");
                    taxAmount = salary * 0.05;
                    System.out.println("Tax amount =" + taxAmount);
                } else if (salary >= 600001 & salary <= 900000) {
                    System.out.println("pay an tax of 10%");
                    taxAmount = salary * 0.1;
                    System.out.println("Tax amount =" + taxAmount);
                } else if (salary >= 900001 & salary <= 1200000) {
                    System.out.println("pay an tax of 15%");
                    taxAmount = salary * 0.15;
                    System.out.println("Tax amount =" + taxAmount);
                } else if (salary >= 1200001 & salary <= 1500000) {
                    System.out.println("pay an tax of 20%");
                    taxAmount = salary * 0.2;
                    System.out.println("Tax amount =" + taxAmount);
                } else {
                    System.out.println("pay an tax of 30%");
                    taxAmount = salary * 0.3;
                    System.out.println("Tax amount =" + taxAmount);
                }
                break;
        }
        return Double.toString(taxAmount);
    }
}
