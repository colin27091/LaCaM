/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.DataSourceFactory;
import model.tables.Customer;

/**
 *
 * @author c
 */
@WebServlet(name = "loginControl", urlPatterns = {"/loginControl"})
public class loginControl extends HttpServlet {

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
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        System.out.println(email);
        try{
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            switch (action) {
		case "connect":
                    System.out.println(email + "     " + mdp);
                    if(dao.isAdmin(email, mdp)){
                        System.out.println("is admin");
                        request.getRequestDispatcher("Views/PageAdmin.jsp").forward(request, response);
                    } else {
                        Customer customer = dao.getCustomerLogin(email,Integer.parseInt(mdp));
                        if(customer != null){
                            System.out.println(customer.toString());
                            request.setAttribute("customer", customer); 
                            request.getRequestDispatcher("clientControl").forward(request, response);
                        } else {
                            request.setAttribute("error_message", "Mauvais identifiant");
                            request.getRequestDispatcher("Views/PageConnexion.jsp").forward(request, response);
                        }
                        
                    }
                    
                    
                    
                    break;
            }
        }catch (Exception ex) {
            
        }
        request.getRequestDispatcher("Views/PageConnexion.jsp").forward(request, response);
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
