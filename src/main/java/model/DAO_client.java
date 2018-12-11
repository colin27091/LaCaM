package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.tables.Customer;

public class DAO_client {
    
    private final DataSource ds;

    
    public DAO_client(DataSource dataSource) {
        this.ds = dataSource;
    }
    
    
   
   public List<Customer> getCustomers() throws SQLException {
       List<Customer> customers = new ArrayList<Customer>();
       
       String sql = "SELECT * FROM CUSTOMER";
       
       try(Connection connection = ds.getConnection();
               PreparedStatement stmt = connection.prepareStatement(sql)){
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               
               Customer c = new Customer();
               
               c.setCustomer_id(rs.getInt("customer_id"));
               c.setDiscount_code(rs.getString("discount_code"));
               c.setZip(rs.getString("zip"));
               c.setName(rs.getString("name"));
               c.setAddressline1(rs.getString("addressline1"));
               c.setAddressline2(rs.getString("addressline2"));
               c.setCity(rs.getString("city"));
               c.setState(rs.getString("state"));
               c.setPhone(rs.getString("phone"));
               c.setFax(rs.getString("fax"));
               c.setEmail(rs.getString("email"));
               c.setCredit_limit(rs.getInt("credit_limit"));
               
               
               
               c.setSommeTotale(this.howManySpend(c));
               
               
               customers.add(c);
               
               
               
           }
       }
       
       return customers;
   }

    public boolean createClient(Customer customer) throws SQLException{
        String sql = "INSERT INTO APP.CUSTOMER(CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, PHONE, FAX, EMAIL, CREDIT_LIMIT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection connection = ds.getConnection();
               PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, customer.getCustomer_id());
            stmt.setString(2, customer.getDiscount_code());
            stmt.setString(3, customer.getZip());
            stmt.setString(4, customer.getName());
            stmt.setString(5, customer.getAddressline1());
            stmt.setString(6, customer.getAddressline2());
            stmt.setString(7, customer.getCity());
            stmt.setString(8, customer.getState());
            stmt.setString(9, customer.getPhone());
            stmt.setString(10, customer.getFax());
            stmt.setString(11, customer.getEmail());
            stmt.setInt(12, customer.getCredit_limit());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex){
            return false;
        }
        
    }
    
    
    public float howManySpend(Customer customer) throws SQLException{
        
        float sommeTotale = 0;
        
        String sql1 = "SELECT SUM(PURCHASE_COST) FROM PRODUCT INNER JOIN PURCHASE_ORDER ON PRODUCT.PRODUCT_ID = PURCHASE_ORDER.PRODUCT_ID WHERE CUSTOMER_ID="+customer.getCustomer_id();
        //somme depensé dans les produit
        String sql2 = "SELECT SUM(SHIPPING_COST) FROM PURCHASE_ORDER WHERE CUSTOMER_ID="+customer.getCustomer_id();
        //somme depensé en frais de port
        
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                PreparedStatement stmt2 = connection.prepareStatement(sql2)){
            ResultSet rs = stmt1.executeQuery();
            ResultSet rs2 = stmt2.executeQuery();
            while(rs.next()){
                sommeTotale += rs.getFloat("1");
            }
            
            while(rs2.next()){
                sommeTotale += rs.getFloat("1");
            }
            
        } catch (Exception ex){
            
        }
        
        
        return sommeTotale;
    }
    
    
}
