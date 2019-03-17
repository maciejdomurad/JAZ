package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class harmonogramxx extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String LoanAmountS = request.getParameter("LoanAmount");
        String PaymentNumberS = request.getParameter("PaymentNumber");
        String InterestRateS = request.getParameter("InterestRate");
        String FeeS = request.getParameter("Fee");
        String PaymentType = request.getParameter("PaymentType");
        double LoanAmount = Double.parseDouble(LoanAmountS);
        double PaymentNumber = Double.parseDouble(PaymentNumberS);
        double InterestRate = Double.parseDouble(InterestRateS);
        double Fee = Double.parseDouble(FeeS);
        response.setContentType("text/html");
        response.getWriter().println("<fieldset>" +
                "<legend>" +
                "<h1 align=\"center\">Harmonogram</h1>" +
                "</legend>" +
                "<table border=\"1\">" +
                "<tr><td>Numer raty</td><td>Kwota</td></tr>");

        if (PaymentType.equals("malejaca"))
        {
            for (int x=1; x<=PaymentNumber; x++)
            {
                double kwota = ((LoanAmount/PaymentNumber)*(1+(PaymentNumber-x+1)*(InterestRate/100)/12)+Fee);
                response.getWriter().println("<tr><td>" + x + "</td><td>" + Math.round(kwota * 100.00)/100.00 + " zł");
            }
        }
        if (PaymentType.equals("stala"))
        {
            for (int x=1; x<=PaymentNumber; x++)
            {
                double kwota = (LoanAmount*Math.pow(1+((InterestRate/100)/12),PaymentNumber)*(InterestRate/100)/12)/((Math.pow(1+((InterestRate/100)/12),PaymentNumber)-1));
                response.getWriter().println("<tr><td>" + x + "</td><td>" + Math.round(kwota * 100.00)/100.00  + " zł");
            }
        }

        response.getWriter().println("</table></fieldset>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}