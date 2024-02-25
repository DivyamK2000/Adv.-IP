package Exp-4;

public class updateTable {
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
        try(PrintWriter out = response.getWriter()){
            String url = "jdbc:mysql://127.0.0.1:3306/experimentDB";
            String uname = "Divyam";
            String pass = "Divyam@9570";
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - Update Table</title>");            
            out.println("</head>");
            out.println("<body>");
            try(Connection conn = DriverManager.getConnection(url, uname, pass)){
            
                try(Statement s = conn.createStatement()){
                    s.executeUpdate("UPDATE student SET UID='23MCI10060', NAME='DIVYAM', COURSE='MAM', SECTION='MAM-1A'"
                            + "WHERE UID='23MCI10011';");
                    out.println("Data updated in table!");
                        
                    ResultSet rs = s.executeQuery("SELECT * FROM student");
                    out.println("<table border=1>");
                    out.println("<tr><th>UID</th><th>NAME</th><th>COURSE</th>"
                            + "<th>SECTION</th></tr>");
                    while(rs.next()){
                        String u = rs.getString("UID");
                        String n = rs.getString("NAME");
                        String c = rs.getString("COURSE");
                        String se = rs.getString("SECTION");
                        out.println("<tr><td>"+u+"</td><td>"+n+"</td><td>"+c
                                +"</td><td>"+se+"</td></tr>");
                    }
                }
            }
            catch(SQLException e){
                out.println(e);
            }
            out.println("</body>");
            out.println("</html>");
            out.close();
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
