/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.DataSourceFactory;

/**
 *
 * @author leolo
 */
@WebServlet(name = "purchaseControl", urlPatterns = {"/purchaseControl"})
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
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            switch (action) {
		case "Retour au Catalogue":
                    response.sendRedirect("/MaCaL/clientControl");
                    break;
                default: request.getRequestDispatcher(views).forward(request, response);
            }
        }
            catch (Exception ex) {
            request.getRequestDispatcher(views).forward(request, response);
        }
            
}
}
