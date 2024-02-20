package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gamer
 */
public class forward extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            out.println("<h1>This is a forwarding file.");
            
            int num1 = Integer.parseInt(request.getParameter("x"));
            int num2 = Integer.parseInt(request.getParameter("y"));
            int add = num1 + num2;
            
            request.setAttribute("sum", add);
            
            RequestDispatcher fwd = request.getRequestDispatcher("target");
            
            fwd.forward(request, response);
        }
        catch(IOException e){
            System.out.print(e);
        }
    }
}
