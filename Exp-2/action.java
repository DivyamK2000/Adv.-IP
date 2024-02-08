package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


/**
 *
 * @author gamer
 */
@WebServlet(name = "action", urlPatterns = {"/action"})
public class action extends HttpServlet {
    private static final long serialVersionUID = 1l;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            out.println("<h1> Your Full name is "+ fname + lname +"<br>");
            
            HttpSession ses = request.getSession();
            
            ses.setAttribute("fname", fname);
            ses.setAttribute("lname", lname);
            
            out.println("<a href='session'>Details...</a>");
            out.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter();) {
            response.setContentType("text/html");
            
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            out.println("<h1> Your Full name is "+ fname + lname + "<br>");
            
            HttpSession ses = request.getSession();
            
            ses.setAttribute("fname", fname);
            ses.setAttribute("lname", lname);
            
            out.println("<a href='session'>Details...</a>");
            out.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
