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
import model.DAO_login;
import model.DAO_product;
import model.DataSourceFactory;
import model.tables.Product;

/**
 *
 * @author c
 */
@WebServlet(name = "modifProductControl", urlPatterns = {"/modifProductControl"})
public class modifProductControl extends HttpServlet {

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
        
        
        String views = "Views/PageModifierProduit.jsp";
        
        String action = request.getParameter("action");
        action = (action == null ) ? "" : action;
        
        request.getRequestDispatcher(views).forward(request, response);

    }
}

