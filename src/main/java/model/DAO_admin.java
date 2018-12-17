package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.sql.DataSource;

public class DAO_admin {
    
    DataSource ds;
    
    
    public DAO_admin(DataSource ds){
        this.ds = ds;
    }
    
    public HashMap<Integer, Float> getPurchaseFromZip(String date_before, String date_after){
        
        HashMap<Integer, Float> map = new HashMap<Integer, Float>();
        
        String sql = "SELECT MICRO_MARKET.ZIP_CODE, PURCHASE_ORDER.QUANTITY*PRODUCT.PURCHASE_COST + PURCHASE_ORDER.SHIPPING_COST AS SOMME"
                + "FROM PURCHASE_ORDER"
                + "INNER JOIN CUSTOMER"
                + "ON CUSTOMER.CUSTOMER_ID = PURCHASE_ORDER.CUSTOMER_ID"
                + "INNER JOIN PRODUCT"
                + "ON PURCHASE_ORDER.PRODUCT_ID = PRODUCT.PRODUCT_ID"
                + "INNER JOIN MICRO_MARKET"
                + "ON CUSTOMER.ZIP = MICRO_MARKET.ZIP_CODE"
                + "WHERE PURCHASE_ORDER.SALES_DATE <"+ date_before+" AND"
                + "PURCHASE_ORDER.SALES_DATE >"+ date_after;
        
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int zip = rs.getInt("ZIP_CODE");
                float somme = rs.getFloat("SOMME");
                if(map.containsKey(zip)){
                    map.replace(zip, map.get(zip) + somme);
                } else {
                    map.put(zip, somme);
                }
            }
            
        } catch (Exception ex){
            
        }
        
        
        
        
        return map;
    }
    
    
}
