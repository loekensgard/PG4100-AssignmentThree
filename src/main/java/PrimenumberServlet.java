import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Thorstein on 14.04.2016.
 */
@WebServlet(name ="primeNumberServlet", urlPatterns = "/primeNumberServlet")
public class PrimenumberServlet extends HttpServlet{
    private NumberChecker nc;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String primeNumber = req.getParameter("primeNumberServlet");
        nc = new NumberChecker(primeNumber);

        try (PrintWriter out = resp.getWriter()) {
            int number = nc.getNumber();

            out.println(nc.toString(number));

        }

    }

}
