package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import model.tables.Customer;

public class DAO_client {
    
    private final DataSource ds;

    
    public DAO_client(DataSource dataSource) {
        this.ds = dataSource;
    }
    
    
    public boolean clientIsOK(Customer customer){
        String sql ="";
        return true;
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
    
}
