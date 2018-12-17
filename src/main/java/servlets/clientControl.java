package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO_login;
import model.DAO_product;
import model.DataSourceFactory;
import model.tables.Customer;
import model.tables.Product;


@WebServlet(name = "clientControl", urlPatterns = {"/clientControl"})
public class clientControl extends HttpServlet {

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
        String views = "Views/PageClient.jsp";
        //response.setContentType("/MaCaL/client");
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        action = (action == null ) ? "" :  action;
        
        System.out.println(action);
        
      
        response.setContentType("/MaCaL/client");
        try{
            DAO_login dao = new DAO_login(DataSourceFactory.getDataSource());
            DAO_product dao_product = new DAO_product(DataSourceFactory.getDataSource());
            int customer_id = Integer.parseInt((String) session.getAttribute("customer_id"));
            Customer customer = dao.getCustomer(customer_id);
            request.setAttribute("customer", customer);
            List<Product> products = dao_product.getProducts();
            

            switch(action){
                case "Mes commandes":
                    response.sendRedirect("/MaCaL/commandesControl");
                break;
                
                case "Gerer le profil":
                    response.sendRedirect("/MaCaL//MaCaL/modifProfilControl");
                break;
                
                case "Deconnexion":
                    session.removeAttribute("customer_id");
                    response.sendRedirect("/MaCaL/");

                break;
                
                
                default : request.setAttribute("products", products);
                            request.getRequestDispatcher(views).forward(request, response);    
            }
            
            
        } catch (Exception ex){
            response.sendRedirect("/MaCaL/");
            //request.setAttribute("error_message", ex);
            //request.getRequestDispatcher(views).forward(request, response);
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
