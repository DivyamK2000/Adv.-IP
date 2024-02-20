package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.util.*;

/**
 *
 * @author gamer
 */
public class action extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Current Time</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Current Time:</h1>");
            out.println("<p>"+ new Date() + "</p>");
            out.println("<meta http-equiv=\"refresh\" content=\"5\">");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
        catch(IOException e){
            System.out.print(e);
        }
    }
}

