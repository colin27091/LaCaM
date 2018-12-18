/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import model.DAO_login;
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
        String views ="Views/PageConnexion.jsp";
        System.out.print(action);
        try{
            DAO_login dao = new DAO_login(DataSourceFactory.getDataSource());
            switch (action) {
		case "Se connecter":
                    System.out.println(email + "     " + mdp);
                    if(dao.isAdmin(email, mdp)){
                        System.out.println("is admin");
                        HttpSession session = request.getSession();
                        session.setAttribute("root", true);
                        response.sendRedirect("/MaCaL/adminControl");
                    } else {
                        if(dao.getLogin(email,Integer.parseInt(mdp))){
                            HttpSession session = request.getSession();
                            session.setAttribute("customer_id", mdp);
                            System.out.println(session == null);
                            response.sendRedirect("clientControl");
                            
                        } else {
                            request.setAttribute("error_message", "Mauvais identifiant");
                            request.getRequestDispatcher(views).forward(request, response);
                        }
                        
                    }
                    break;
                case "Creer un compte":
                    response.sendRedirect("createCompteControl");
                    break;
                default: request.getRequestDispatcher(views).forward(request, response);
            }
            
            
        }catch (Exception ex) {
            request.setAttribute("error_message", "Identifiant/Mot de passe invalide");
            request.getRequestDispatcher(views).forward(request, response);
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