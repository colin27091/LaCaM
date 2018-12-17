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
        System.out.println(action);
        
        
        
        try{
            
           
            DAO_product dao_product = new DAO_product(DataSourceFactory.getDataSource());
            DAO_login dao = new DAO_login(DataSourceFactory.getDataSource());

            Product product = dao_product.getProduct(Integer.parseInt(request.getParameter("product_id")));
            
            
            
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
                    Product p = new Product();
                    
                    p.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
                    p.setManufacturer_id(Integer.parseInt(request.getParameter("product_id")));
                    p.setProduct_code(request.getParameter("product_code"));
                    p.setPurchase_cost(Float.parseFloat(request.getParameter("purchase_cost")));
                    p.setQuantity_on_hand(Integer.parseInt(request.getParameter("quantity_on_hand")));
                    p.setMarkup(Float.parseFloat(request.getParameter("markup")));
                    p.setAvailable(request.getParameter("available"));
                    p.setDescription(request.getParameter("description"));
                    
                    dao_product.modifProduit(p);
                   
                    response.sendRedirect("/MaCaL/adminControl");

                    } 
                    break;
                case "Annuler les modifications":  
                    response.sendRedirect("/MaCaL/adminControl");
                    break;   
                    
                default :request.setAttribute("product", product);
                         request.getRequestDispatcher(views).forward(request, response);
            }

        }catch (Exception ex){  
        }

    }
}

