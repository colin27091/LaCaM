/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO_client;
import model.DAO_manufacturer;
import model.DAO_product;
import model.DataSourceFactory;
import model.tables.Customer;
import model.tables.Manufacturer;
import model.tables.Product;

/**
 *
 * @author c
 */
@WebServlet(name = "adminControl", urlPatterns = {"/adminControl"})
public class adminControl extends HttpServlet {

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
        String views = "/Views/PageAdmin.jsp";
        String action = request.getParameter("action");
        action = (action == null ) ? "" : action;
        System.out.println(action);
        
        
        
        
        
        try{
            DAO_product dao_product = new DAO_product(DataSourceFactory.getDataSource());
            DAO_manufacturer dao_manufacturer = new DAO_manufacturer(DataSourceFactory.getDataSource());
            DAO_client dao_client = new DAO_client(DataSourceFactory.getDataSource());
            
            List<Customer> customers = dao_client.getCustomers();
            
            
            HttpSession session = request.getSession();
            boolean root = (boolean) session.getAttribute("root");
            
            
            request.setAttribute("customers", customers);
            
            List<Product> products = dao_product.getProducts();
            request.setAttribute("products", products);
            List<Manufacturer> manufacturers = dao_manufacturer.getManufacturers();
            request.setAttribute("manufacturers", manufacturers);
            
            System.out.println(action);
            switch(action){
                case "Page Creation Produit":
                    
                    
                    System.out.println("passe par la");
                    response.sendRedirect("/MaCaL/createProductControl");
                    
                              
                    
                    break;
                    
                case "Se Deconnecter":
                    response.sendRedirect("/MaCaL/");
                    break;
                default: request.getRequestDispatcher(views).forward(request, response);
                    
            }
           
            
        }catch (Exception ex){
            response.sendRedirect("/MaCaL/");
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
