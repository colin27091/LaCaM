/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO_login;
import model.DAO_manufacturer;
import model.DAO_product;
import model.DataSourceFactory;
<<<<<<< Updated upstream
import model.tables.Customer;
import model.tables.Manufacturer;
=======
>>>>>>> Stashed changes
import model.tables.Product;

/**
 *
 * @author c
 */
@WebServlet(name = "createProductControl", urlPatterns = {"/createProductControl"})
public class createProductControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String views = "Views/PageCreationProduit.jsp";
        
        String action = request.getParameter("action");
        action = (action == null) ? "" : action;
        System.out.println(action);
        
        
        try{
            DAO_login dao = new DAO_login(DataSourceFactory.getDataSource());
            DAO_manufacturer dao_manufacturer = new DAO_manufacturer(DataSourceFactory.getDataSource());
            DAO_product dao_product = new DAO_product(DataSourceFactory.getDataSource());
            switch (action){
                case "Valider":
                    Product product = new Product();
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
                       System.out.println("il y a une erreur");
                            Enumeration<String> enum2 = request.getParameterNames();
                            while(enum2.hasMoreElements()){
                                String att = enum2.nextElement();
                                System.out.println(att);
                                if(!att.equals("ZIP")){
                                    request.setAttribute(att, request.getParameter(att));
                                } else {
                                    
                                    //manufacturers = dao.getZip_code();
                                    //request.setAttribute("codes", products);
                                }
                                
                            }
                       request.getRequestDispatcher(views).forward(request, response);
                   } else {
                       
                   try{
                       
                    product.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
                    product.setManufacturer_id(Integer.parseInt(request.getParameter("manufacturer_id")));
                    product.setProduct_code(request.getParameter("product_code"));
                    product.setPurchase_cost(Float.parseFloat(request.getParameter("purchase_cost")));
                    product.setQuantity_on_hand(Integer.parseInt(request.getParameter("quantity_on_hand")));
                    product.setMarkup(Float.parseFloat(request.getParameter("markup")));
                    product.setAvailable(request.getParameter("available"));
                    product.setDescription(request.getParameter("description")); 
                    
                    if(dao_product.createProduct(product)){
                        response.sendRedirect("/MaCaL/adminControl");
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
                    
                    
                    
                   } catch (Exception ex){
                       Enumeration<String> enumeration = request.getParameterNames();
                       request.setAttribute("error", "L'id et la limite de crédit doivent être des nombres");
                       while(enumeration.hasMoreElements()){
                                String att = enumeration.nextElement();
                                System.out.println(att);
                                if(!att.equals("zip")){
                                    request.setAttribute(att, request.getParameter(att));
                                } else {

                                    List<Manufacturer> codes = dao_manufacturer.getManufacturers();
                                    request.setAttribute("codes", codes);

                                }
                                
                            }
                       
                      
                   }
                   }
                    
                    
                    
                    
                    break;
                case "Annuler":
                    response.sendRedirect("/MaCaL/adminControl");
                    break;
                default:
                    request.setAttribute("manufacturer", dao.getZip_code());
                    request.getRequestDispatcher(views).forward(request, response);
            }
                    
        }catch (Exception ex){
            request.setAttribute("error", "Erreur de base de donnée");

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

