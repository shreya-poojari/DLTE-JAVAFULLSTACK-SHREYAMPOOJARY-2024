package jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/updateAmount/*")
public class Update extends HttpServlet {
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

//            // Lookup the data source
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:/OracleDS");
            Connection connection=null;
            connection=dataSource.getConnection();
            String transactionId = req.getParameter("transactionId");
            String amount = req.getParameter("amount");
            PreparedStatement preparedStatement;
            if(transactionId!=null&&amount!=null){
                String query="UPDATE Transactions SET transaction_amount= ?  WHERE transaction_id = ?";
                preparedStatement=connection.prepareStatement(query);
                preparedStatement.setInt(2, Integer.parseInt(transactionId));
                preparedStatement.setInt(1, Integer.parseInt(amount));
                int result=preparedStatement.executeUpdate();
                if(result!=0) resp.getWriter().println("updated yeahh");
                else resp.getWriter().println(" not updated yeahh");
            }
       } catch (NamingException | SQLException e) {
           throw new ServletException("Error updating account", e);
        }

    }
}
