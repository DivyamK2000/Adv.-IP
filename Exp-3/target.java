package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gamer
 */
@WebServlet(name = "target", urlPatterns = {"/target"})
public class target extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            int sum = (int) request.getAttribute("sum");
            
            float avg = (float)(sum/2.0);
            
            out.println("Sum is: "+ sum);
            out.println("<br>Average is: " + avg);
        }
    }
}

