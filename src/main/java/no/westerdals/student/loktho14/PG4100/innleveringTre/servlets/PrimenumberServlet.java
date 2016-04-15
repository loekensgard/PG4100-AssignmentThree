package no.westerdals.student.loktho14.PG4100.innleveringTre.servlets;

import no.westerdals.student.loktho14.PG4100.innleveringTre.utils.NumberChecker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Thorstein on 14.04.2016.
 */
@WebServlet(name ="primeNumberServlet", urlPatterns = "/primeNumberServlet")
public class PrimenumberServlet extends HttpServlet{
    private NumberChecker nc;
    private static final Logger logger = LogManager.getLogger("Requests");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Debug : Requesting parameter" + " - Date: " + new Date().toString());
        String primeNumber = req.getParameter("primeNumberServlet");
        logger.info("Debug : Users number is " + primeNumber + " - Date: " + new Date().toString());
        nc = new NumberChecker(primeNumber);
        resp.setContentType("text/html");

        output(resp);

    }

    private void output(HttpServletResponse resp) throws IOException {
        try (PrintWriter out = resp.getWriter()) {
            logger.info("Debug : Output started" + " - Date: " + new Date().toString());
            int number = nc.getNumber();
            out.print("<center>");
            out.print("<h1>");
            out.println(nc.toString(number));
            out.print("</h1>");
            out.print("</center>");
            logger.info("Debug : Output stopped"+ " - Date: " + new Date().toString());
        }
    }

}
