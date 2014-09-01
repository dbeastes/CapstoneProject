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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author dustineastes
 */
public class NewFrameOrderServlet extends HttpServlet {

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
        //response.setContentType("text/html;charset=UTF-8");
        
        
        HttpSession httpSession = request.getSession();
        Customer customer = (Customer)httpSession.getAttribute("customer");
        Frameorders newOrder = new Frameorders();
        List<Frameorders> frameOrders = new ArrayList();
        List<Frameorders> customerFrameOrders = new ArrayList();
        customerFrameOrders = (List<Frameorders>)httpSession.getAttribute("customerFrameOrders");
        frameOrders = (List<Frameorders>)httpSession.getAttribute("frameOrders");
        
        
        if ( customerFrameOrders.size() < 5 ){
        newOrder.setCustomerid(customer.getId());
        newOrder.setFrameid(frameOrders.size() + 1);
        newOrder.setFrametype((String)request.getParameter("frameType"));
        newOrder.setMat((String)request.getParameter("matType"));
        newOrder.setOrdername(customer.getFname() + customerFrameOrders.size());
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
       
        session.save(newOrder);
        

        frameOrders = session.createQuery("from Frameorders").list();
        customerFrameOrders = Finders.findFrameOrders(frameOrders , customer.getId() );
        session.getTransaction().commit();

        httpSession.setAttribute( "customerFrameOrders", customerFrameOrders );
        httpSession.setAttribute("frameOrders", frameOrders);
        request.getRequestDispatcher( "loggedIn.jsp" ).forward( request, response );
       
        } else {
            FailBean fail = new FailBean();
            fail.setNewOrderFail("You already have 5 Saved Frame Orders.  You need to edit an existing Frame order to Create a new design.");
            request.setAttribute("fail", fail);
            request.getRequestDispatcher( "loggedIn.jsp" ).forward(request, response);
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
