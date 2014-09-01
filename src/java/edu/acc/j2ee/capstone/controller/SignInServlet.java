/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.acc.j2ee.capstone.controller;

import Util.HibernateUtil;
import edu.acc.j2ee.capstone.model.Customer;
import edu.acc.j2ee.capstone.model.FailBean;
import edu.acc.j2ee.capstone.model.Frameorders;
import edu.acc.j2ee.capstone.model.Mat;
import edu.acc.j2ee.capstone.validators.Finders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author dustineastes
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String found = "not found";
      
        String email = (String) request.getParameter("email");
        String password  = (String) request.getParameter("password");
        FailBean fail = new FailBean();
        
        List<Customer> customerList = new ArrayList<>();
        
        List<Frameorders> frameOrders = new ArrayList<>();
        List<Frameorders> customerFrameOrders = new ArrayList<>();
        
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        customerList = session.createQuery("from Customer").list();
        
        frameOrders = session.createQuery("from Frameorders").list();
        
        session.close();
        
     
       Customer login = Finders.findCustomer(customerList, email );
       if (login!=null){
       
           if (login.getPassword().equals(password)) {
            HttpSession httpSession = request.getSession();
		
	
            customerFrameOrders = Finders.findFrameOrders(frameOrders, login.getId() );
            httpSession.setAttribute("customer", login );
            httpSession.setAttribute("frameOrders", frameOrders);
            httpSession.setAttribute("customerFrameOrders", customerFrameOrders );
            
            request.getRequestDispatcher( "loggedIn.jsp" ).forward( request, response );  
        }
        }
       
           fail.setEmailFail("The e-mail or password you entered is Invalid");
           request.setAttribute("failBean", fail);
           request.getRequestDispatcher( "index.jsp" ).forward( request, response );
       
      
        
        
      

        
        
 

            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
