/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.acc.j2ee.capstone.controller;

import Util.HibernateUtil;
import edu.acc.j2ee.capstone.model.Customer;
import edu.acc.j2ee.capstone.model.Frameorders;
import edu.acc.j2ee.capstone.model.Moulding;
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
@WebServlet(name = "FrameOrderServlet", urlPatterns = {"/FrameOrderServlet"})
public class FrameOrderServlet extends HttpServlet {
            
            
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
      
            
            Customer customer = new Customer();
            List<Moulding> mouldingList = new ArrayList<>();
            List<Frameorders> frameOrders = new ArrayList<>();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            String orderName = (String)request.getParameter("orderName");
            Frameorders order = new Frameorders();
           
            
            mouldingList = session.createQuery("from Moulding").list();
            session.getTransaction().commit();
            
            
            HttpSession httpSession = request.getSession();
	
            customer = (Customer)httpSession.getAttribute("customer");
            
            frameOrders = (List<Frameorders>)httpSession.getAttribute("frameOrders");
            //order = frameOrders.get(0);
            
            if (orderName != null) {
                
                for (Frameorders frameOrder : frameOrders) {
                if (frameOrder.getOrdername().equals(orderName)) {
                    order = frameOrder;

                    }
                }
            }
            
            httpSession.setAttribute("moulding", mouldingList );
            request.setAttribute("frameOrder", order);
            
            request.getRequestDispatcher( "FrameOrderPage.jsp" ).forward( request, response );
        
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
