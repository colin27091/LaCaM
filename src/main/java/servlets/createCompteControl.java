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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.DAO_client;
import model.DataSourceFactory;
import model.tables.Customer;

/**
 *
 * @author c
 */
public class createCompteControl extends HttpServlet {

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
        String views = "Views/PageCreationCompte.jsp";
        
        String action = request.getParameter("action");
        action = (action == null) ? "" : action;
        System.out.println(action);
        
        try{
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            DAO_client dao_client = new DAO_client(DataSourceFactory.getDataSource());
            switch (action){
                case "Valider":
                    Customer customer = new Customer();
                    Enumeration<String> enume = request.getParameterNames();
                    boolean erreur = false;
                    while(enume.hasMoreElements()){
                        if(request.getParameter(enume.nextElement()).equals("")){
                            erreur = true;
                            request.setAttribute("error", "Tout les champs doivent être rempli");
                            
                        }
                    }
                    
                   if(erreur){
                       Enumeration<String> enumeration = request.getParameterNames();
                            while(enumeration.hasMoreElements()){
                                String att = enumeration.nextElement();
                                System.out.println(att);
                                if(!att.equals("zip")){
                                    request.setAttribute(att, request.getParameter(att));
                                } else {
                                    request.setAttribute("codes", dao.getZip_code());
                                }
                                
                            }
                       request.getRequestDispatcher(views).forward(request, response);
                   } else {
                       
                   
                    customer.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
                    customer.setName(request.getParameter("name"));
                    customer.setAddressline1(request.getParameter("addressline1"));
                    customer.setAddressline2(request.getParameter("addressline2"));
                    customer.setCity(request.getParameter("city"));
                    customer.setZip(request.getParameter("zip"));
                    customer.setState(request.getParameter("state"));
                    customer.setPhone(request.getParameter("phone"));
                    customer.setFax(request.getParameter("fax"));
                    customer.setEmail(request.getParameter("email"));
                    customer.setCredit_limit(Integer.parseInt(request.getParameter("credit_limit")));
                    customer.setDiscount_code(request.getParameter("discount_code"));
                    
                    if(dao_client.createClient(customer)){
                        response.sendRedirect("/MaCaL/loginControl");
                    } else {
                        Enumeration<String> enumeration = request.getParameterNames();
                            while(enumeration.hasMoreElements()){
                                String att = enumeration.nextElement();
                                if(!att.equals("zip")){
                                    request.setAttribute(att, request.getParameter(att));
                                }
                                
                            }
                            
                        request.setAttribute("error", "Un client possède déjà cet ID");
                        request.getRequestDispatcher(views).forward(request, response);
                    }
                   }
                    
                    break;
                case "Annuler":
                    response.sendRedirect("/MaCaL/loginControl");
                    break;
                default:
                    request.setAttribute("codes", dao.getZip_code());
                    request.getRequestDispatcher(views).forward(request, response);
            }
                    
        }catch (Exception ex){
            request.setAttribute("error", "L'id et le crédit limite sont des nombres");
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
