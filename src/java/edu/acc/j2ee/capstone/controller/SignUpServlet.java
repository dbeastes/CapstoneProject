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
import edu.acc.j2ee.capstone.validators.Finders;
import edu.acc.j2ee.capstone.validators.Validators;
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
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
    

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
        
        Customer login = new Customer();
        List<Customer> customerList = new ArrayList<Customer>();
        List<Frameorders> frameOrders = new ArrayList<Frameorders>();
        
        String email = (String) request.getParameter("email");
        FailBean fail = new FailBean();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        customerList = session.createQuery("from Customer").list();
        frameOrders = session.createQuery("from Frameorders").list();
        
        Customer found = Finders.findCustomer(customerList, email );
        Validators validate = new Validators();
        fail = validate.validateInputs(request); 
        if (fail.isNoErrors()){
                
                if (found == null) {
            
                login.setId(customerList.size() + 1);
                login.setEmail(request.getParameter("email"));
                login.setFname(request.getParameter("firstName"));
                login.setLname(request.getParameter("lastName"));
                login.setPassword(request.getParameter("password"));
                session.save(login);
            }
        else{
            fail.setEmailFail("Email address is already being Used");
            request.setAttribute("failBean", fail);
            session.close();
            request.getRequestDispatcher( "SignUpPage.jsp" ).forward( request, response ); 
            
        }
        
         
        
        
        } else {
            request.setAttribute("failBean", fail);
            session.close();
            request.getRequestDispatcher("SignUpPage.jsp").forward(request, response);
        }
        
        session.getTransaction().commit();
        //session.close();
       
        
        HttpSession httpSession = request.getSession();
		
	
            
        httpSession.setAttribute("customer", login);
        httpSession.setAttribute("frameOrders", frameOrders);
        
            request.getRequestDispatcher( "loggedIn.jsp" ).forward( request, response ); 
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
