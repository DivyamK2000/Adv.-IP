package Exp-4;

public class dropDatabase {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = "jdbc:mysql://127.0.0.1:3306";
            String uname = "Divyam";
            String pass = "Divyam@9570";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - Drop Database</title>");            
            out.println("</head>");
            out.println("<body>");
            try(Connection conn = DriverManager.getConnection(url, uname, pass)){
                String dbName = "experimentDB";
                try(Statement s = conn.createStatement();){
                    s.executeUpdate("DROP DATABASE IF EXISTS " + dbName +";");
                    out.println("<b>Database " + dbName + " droped!</b>");    
                }
            }
            catch(SQLException e){
                out.println(e.getMessage());
            }
            out.println("</body>");
            out.println("</html>");
        }
        catch(IOException e1){
            System.out.println(e1.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            processRequest(request, response);
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            processRequest(request, response);
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
