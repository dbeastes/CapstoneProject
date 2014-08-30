
package edu.acc.j2ee.capstone;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CustomerServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   CustomerBean customer = new CustomerBean();
    
   Connection con = null;
    Statement stmt = null;
   String query = "SELECT * FROM APP.CUSTOMER";
   String name = "";
 try {

      Class.forName(
        "org.apache.derby.jdbc.EmbeddedDriver");

// Obtaining a connection to SQL Server
      con = DriverManager.getConnection(
          "jdbc:derby://localhost:1527/moulding" , "javauser", "javauser");
     stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query); 
        rs.next();
        name = rs.getString("LNAME");
      
    } catch (java.lang.ClassNotFoundException e) {
      System.err.println("ClassNotFoundException: "
        +e.getMessage());
    } catch (SQLException e) {
      System.err.println("SQLException: "
        +e.getMessage());
    }
 
  try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + name + "MotherFucker is Connected What What!</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    
    }
}




