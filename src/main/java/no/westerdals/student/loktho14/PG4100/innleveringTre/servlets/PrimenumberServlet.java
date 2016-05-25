package no.westerdals.student.loktho14.PG4100.innleveringTre.servlets;

import no.westerdals.student.loktho14.PG4100.innleveringTre.utils.NumberChecker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Thorstein 14.04.2016.
 *
 *
 */
@WebServlet(name ="primeNumberServlet", urlPatterns = "/primeNumberServlet")
public class PrimenumberServlet extends HttpServlet{
    private NumberChecker nc;
    private static final Logger logger = LogManager.getLogger("Results");



    /**
     * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse
     *      resp)
     *
     *      This method gets the number from the user, and sends the number to my NumberChecker
     *      and gives the user a answer. The result depends on the number, is it a prime or not.
     *
     *      @param req HttpServletRequest
     *      @param resp HttpServletResponse
     *      @throws ServletException
     *      @throws IOException
     */

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Debug : Requesting parameter");
        String primeNumber = req.getParameter("primeNumberServlet");
        logger.info("Debug : Users number is " + primeNumber);
        nc = new NumberChecker(primeNumber);
        resp.setContentType("text/html");

        output(resp);

    }
    /**
     * @param resp
     * @throws IOException
     *
     * This method prints the results on in a jsp file.
     *
     */
    private void output(HttpServletResponse resp) throws IOException {
        try (PrintWriter out = resp.getWriter()) {
            logger.info("Debug : Output started");
            int number = nc.getNumber();
            out.print("<center>");
            out.print("<h1>");
            out.println(nc.toString(number));
            out.print("</h1>");
            out.print("</center>");
            logger.info("Debug : Output stopped");
        }
    }

}
