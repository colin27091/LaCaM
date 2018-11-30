package model;

import model.tables.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

public class DAO {
    
    private final DataSource ds;
    private String emailAdmin = "root";
    private String mdpAdmin = "root";
    
    
    
    

    public DAO(DataSource dataSource) {
    
        this.ds = dataSource;
    }
    
    
    public Customer getCustomerLogin(String email, int customer_id) throws SQLException{//Si les paramètres de login sont vérifies return le customer
        
        Customer customer = null;
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID="+customer_id;
		try (Connection connection = ds.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            String mail = rs.getString("EMAIL");
                            if(email.equals(mail)){//Si les identifiants sont exact on rempli le customer
                                String discount_code = rs.getString("DISCOUNT_CODE");
                                String zip = rs.getString("ZIP");
                                customer = new Customer(customer_id, discount_code, zip);//Initialisation de customer avec les clé (primaires et etrengère)
                                customer.setName(rs.getString("NAME"));
                                customer.setAddressline1(rs.getString("ADDRESSLINE1"));
                                customer.setAddressline2(rs.getString("ADDRESSLINE2"));
                                customer.setCity(rs.getString("CITY"));
                                customer.setState(rs.getString("STATE"));
                                customer.setPhone(rs.getString("PHONE"));
                                customer.setFax(rs.getString("FAX"));
                                customer.setEmail(rs.getString("EMAIL"));
                                customer.setCredit_limit(rs.getInt("CREDIT_LIMIT"));
                            }
                            
			}
		}
        return customer;//Si le customer == null alors les paramètre de connexion sont incorrect
    }
    
    
    public boolean isAdmin(String email, String mdp){
        return email.equals(emailAdmin) && mdp.equals(mdpAdmin);
    }
    
    
    
    
    
    
}
