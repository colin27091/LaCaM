package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.tables.Customer;
import model.tables.Product;
import model.tables.Purchase;


public class DAO_purchase {
    
    
    DataSource ds;
    
    public DAO_purchase(DataSource ds){
        this.ds = ds;
    }
    
    
    
    public List<Product> getProducts(Customer customer){
        List<Product> products = new ArrayList<Product>();
        
        String sql = "SELECT * FROM PURCHASE_ORDER INNER JOIN PRODUCT ON PURCHASE_ORDER.PRODUCT_ID = PRODUCT.PRODUCT_ID "
                + "WHERE PURCHASE_ORDER.CUSTOMER_ID="+customer.getCustomer_id();
        
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Product product = new Product();
                
                product.setDescription(rs.getString("description"));
                product.setPurchase_cost(rs.getInt("quantity")*rs.getFloat("purchase_cost")+rs.getFloat("shipping_cost"));
                product.setQuantity_on_hand(rs.getInt("quantity"));
                
                products.add(product);
            }
            
        } catch (Exception ex){
            
        }
        
        
        return products;
    }
    
    
    public List<Purchase> getPurchases(Customer customer) {
        List<Purchase> purchases = new ArrayList<Purchase>();
                
        String sql = "SELECT * FROM PURCHASE_ORDER WHERE CUSTOMER_ID="+customer.getCustomer_id();
        
        
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Purchase p = new Purchase();
                
                p.setOrder_num(rs.getInt("order_num"));
                p.setCustomer_id(rs.getInt("customer_id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setQuantity(rs.getInt("quantity"));
                p.setShipping_cost(rs.getFloat("shipping_cost"));
                p.setShipping_date(rs.getString("shipping_date"));
                p.setSales_dates(rs.getString("sales_date"));
                p.setFreight_company(rs.getString("freight_company"));
                
                
                purchases.add(p);
                System.out.println(p.toString());
            }
            
            
        } catch (Exception ex){
            System.out.println("Erreur dans le DAO" +  ex);

        }
        
        return purchases;
    }
}