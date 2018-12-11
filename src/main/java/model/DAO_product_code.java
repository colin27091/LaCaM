package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.tables.Product_code;


public class DAO_product_code {
    
    DataSource ds;
    
    
    public DAO_product_code(DataSource ds){
        this.ds = ds;
    }
    
    
    public List<Product_code> getProduct_codes() throws SQLException{
        List<Product_code> product_codes = new ArrayList<Product_code>();

        String sql = "SELECT * FROM PRODUCT_CODE";
        
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Product_code pc = new Product_code();
                
                pc.setProd_code(rs.getString("prod_code"));
                pc.setDiscount_code(rs.getString("discount_code"));
                pc.setDescription(rs.getString("decription"));
     
                product_codes.add(pc);   
            }
            
        }
        return product_codes;
    }
    
    
    
    
    
    
    
}
