/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO_client;
import model.DAO_product;
import model.DAO_purchase;
import model.DataSourceFactory;
import model.tables.Customer;
import model.tables.Product;
import model.tables.Purchase;

/**
 *
 * @author leolo
 */
@WebServlet(name = "purchaseControl", urlPatterns = {"/purchaseControl"})
public class purchaseControl extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String views ="Views/PageAnciennesCommandes.jsp";
        
        String action = request.getParameter("action");
        action = (action == null) ? "" : action; // Pour le switch qui n'aime pas les null
        
        try{
            
            
            
            
            DAO_purchase dao_purchase = new DAO_purchase(DataSourceFactory.getDataSource());
            DAO_client dao_client = new DAO_client(DataSourceFactory.getDataSource());
            DAO_product dao_product = new DAO_product(DataSourceFactory.getDataSource());
            
            
            
            System.out.println("tout ok");
            HttpSession session = request.getSession();
            Customer customer = dao_client.getCustomer(Integer.parseInt((String) session.getAttribute("customer_id")));
            List<Purchase> purchases = dao_purchase.getPurchases(customer);
            List<Product> products = dao_product.getProducts();
            
            
 
            switch (action) {
		case "Retour au Catalogue":
                    response.sendRedirect("/MaCaL/clientControl");
                    break;
                default: 
                    request.setAttribute("customer", customer);
                    request.setAttribute("purchases", purchases);
                    request.getRequestDispatcher(views).forward(request, response);
            }
       
        
        } catch (Exception ex){
            
            response.sendRedirect("/MaCaL/");
            //response.sendRedirect("/MaCaL/");
            //request.setAttribute("error_message", ex);
            //request.getRequestDispatcher(views).forward(request, response);
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

