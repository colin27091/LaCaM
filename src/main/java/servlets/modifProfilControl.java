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
import javax.sql.DataSource;
import model.DAO;
import model.DAO_client;
import model.DataSourceFactory;
import model.tables.Customer;

/**
 *
 * @author c
 */
@WebServlet(name = "modifProfilControl", urlPatterns = {"/modifProfilControl"})
public class modifProfilControl extends HttpServlet {

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
        
        
        String views = "Views/PageGererProfil.jsp";
        
        String action = request.getParameter("action");
        action = (action == null ) ? "" : action;
        System.out.println(action);
        
        
        
        try{
            
           
            DAO_client dao_client = new DAO_client(DataSourceFactory.getDataSource());
            DAO dao = new DAO(DataSourceFactory.getDataSource());

            Customer customer = dao_client.getCustomer(Integer.parseInt(request.getParameter("customer_id")));
            List<String> codes = dao.getZip_code();
            
            
            
            switch(action){
                case "Valider les modifications":
                    
                    
                    Enumeration<String> enum1 = request.getParameterNames();
                    boolean erreur = false;
                    while(enum1.hasMoreElements()){
                        if(request.getParameter(enum1.nextElement()).equals("")){
                            erreur = true;
                            System.out.print(erreur);
                            request.setAttribute("error", "Tout les champs doivent être rempli");
                            
                        }
                    }
                    
                    
                    if(erreur){
                        
                        request.getRequestDispatcher(views).forward(request, response);
                        
                    } else {
                    
                    
                    Customer c = new Customer();
                    
                    c.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
                    c.setName(request.getParameter("name"));
                    c.setAddressline1(request.getParameter("addressline1"));
                    c.setAddressline2(request.getParameter("addressline2"));
                    c.setCity(request.getParameter("city"));
                    c.setZip(request.getParameter("zip"));
                    c.setState(request.getParameter("state"));
                    c.setPhone(request.getParameter("phone"));
                    c.setFax(request.getParameter("fax"));
                    c.setEmail(request.getParameter("email"));
                    c.setCredit_limit(Integer.parseInt(request.getParameter("credit_limit")));
                    c.setDiscount_code(request.getParameter("discount_code")); 
                    
                    
                    dao_client.modifProfil(c);
                   
                    response.sendRedirect("/MaCaL/clientControl?customer_id="+c.getCustomer_id());

                    } 
                    break;
                
                case "Annuler les modifications":
                    
                    
                    response.sendRedirect("/MaCaL/clientControl?customer_id="+ customer.getCustomer_id());
                    
                    
                    break;
                    
                    
                    
                default :request.setAttribute("customer", customer);
                         request.setAttribute("codes", codes);
                         request.getRequestDispatcher(views).forward(request, response);
            }
            
            
            
            
            
            
        }catch (Exception ex){
            
            
            
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
