package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


/**
 *
 * @author gamer
 */
public class session extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            response.setContentType("text/html;charset=UTF-8");
            
            HttpSession ses = request.getSession(false);
            if(ses == null){
                ses = request.getSession();
            }
            else {
                //already created!
            }
            Date creationTime = new Date(ses.getCreationTime());
            Date lastAcessedTime = new Date(ses.getLastAccessedTime());
            
            String fname = (String)ses.getAttribute("fname");
            String lname = (String)ses.getAttribute("lname");
            
            out.println("Welcome " + fname + lname + "<br>");
            out.println("The site was created on " + creationTime + "<br>");
            out.println("Page acessed latest: " + lastAcessedTime + "<br>");
            out.close();
        }
    }
    
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            response.setContentType("text/html;charset=UTF-8");
            
            HttpSession ses = request.getSession(false);
            if(ses == null){
                ses = request.getSession();
            }
            else {
                //already created!
            }
            
            Date creationTime = new Date(ses.getCreationTime());
            Date lastAcessedTime = new Date(ses.getLastAccessedTime());
            
            String fname = (String)ses.getAttribute("fname");
            String lname = (String)ses.getAttribute("lname");
            
            out.println("Welcome " + fname + lname + "<br>");
            out.println("The site was created on " + creationTime + "<br>");
            out.println("Page acessed latest: " + lastAcessedTime + "<br>");
            out.close();
        }
    }
}