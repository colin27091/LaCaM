/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO_login;
import model.DAO_client;
import model.DAO_purchase;
import model.DAO_product;
import model.DataSourceFactory;
import model.tables.Customer;
import model.tables.Product;
import model.tables.Purchase;

/**
 *
 * @author leolo
 */
@WebServlet(name = "commandesControl", urlPatterns = {"/commandesControl"})
public class commandesControl {
    
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
        String action = request.getParameter("action");
        action = (action == null) ? "" : action; // Pour le switch qui n'aime pas les null
        String views ="Views/PageAnciennesCommandes.jsp";
        System.out.print(action);
        try{
          
            
            DAO_purchase dao_purchase = new DAO_purchase(DataSourceFactory.getDataSource());
            DAO_client dao_client = new DAO_client(DataSourceFactory.getDataSource());
            DAO_product dao_product = new DAO_product(DataSourceFactory.getDataSource());
            
            Customer customer = dao_client.getCustomer(Integer.parseInt(request.getParameter("customer_id")));
            List<Purchase> purchases = dao_purchase.getPurchases(customer);
            List<Product> products = dao_product.getProducts();
            request.setAttribute("purchases", purchases);
            
 
            switch (action) {
		case "Retour au Catalogue":
                    response.sendRedirect("/MaCaL/clientControl");
                    break;
                default: 
                    request.setAttribute("products", products);
                    request.getRequestDispatcher(views).forward(request, response);
            }
       
        
        } catch (Exception ex){
            response.sendRedirect("/MaCaL/");
            //request.setAttribute("error_message", ex);
            //request.getRequestDispatcher(views).forward(request, response);
        } 
}
}
