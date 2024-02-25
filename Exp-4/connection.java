package Exp-4;

public class connection {
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
        PrintWriter out = response.getWriter();
        String url = "jdbc:mysql://127.0.0.1:3306";
        String uname = "Divyam";
        String pass = "Divyam@9570";
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet - Connection</title>");
        out.println("</head>");
        out.println("<body>");
        try(Connection conn = DriverManager.getConnection(url, uname, pass)){
            out.println("<h1>Connected to database successfully!</h2>");
            Statement s = conn.createStatement();
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            out.println("<br>");
            while(rs.next()){
                out.println("<b>Table: </b>" + rs.getString(3) + "<br>");
            }
            
            conn.close();
        }
        catch(SQLException e1){
            out.println(e1.getMessage());
        }
        out.println("</html></body>");
        out.close();
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
