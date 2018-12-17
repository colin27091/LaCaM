/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.tables.Product;

public class DAO_product {
    
    private final DataSource ds;
    
    public DAO_product(DataSource dataSource) {
        this.ds = dataSource;
        
    }
    
    public List<Product> getProducts() throws SQLException{
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM PRODUCT";
        try (Connection connection = ds.getConnection(); 
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
			while (rs.next()) {
                            
                            Product product = new Product();
                            product.setProduct_id(rs.getInt("product_id"));//clé primaire
                            product.setManufacturer_id(rs.getInt("manufacturer_id"));//clé etrangère (manufacturer_id)
                            product.setProduct_code(rs.getString("product_code"));//clé etrangère (product_code)
                            product.setPurchase_cost(Double.parseDouble(rs.getString("purchase_cost")));
                            product.setQuantity_on_hand(rs.getInt("quantity_on_hand"));
                            product.setMarkup(Double.parseDouble(rs.getString("markup")));
                            product.setAvailable(rs.getString("available"));
                            product.setDescription(rs.getString("description"));
                            products.add(product);
                            
                        }
        } catch (Exception ex){
            System.out.println(ex);
        }
	
        return products;
    }
    
    public boolean addProduct(Product product){
        String sql = "INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection connection = ds.getConnection();
               PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setInt(1, product.getProduct_id());
                stmt.setInt(2, product.getManufacturer_id());
                stmt.setString(3, product.getProduct_code());
                stmt.setFloat(4, (float) product.getPurchase_cost());
                stmt.setInt(5, product.getQuantity_on_hand());
                stmt.setFloat(6, (float) product.getMarkup());
                stmt.setString(7, product.getAvailable());
                stmt.setString(8, product.getDescription());
                stmt.executeUpdate();
                return true;
        }catch (Exception ex){
            return false;
        }
        
 
    }
    public Product getProduct(int product_id) throws SQLException{
        Product product = null;
        String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID="+product_id;
        try (Connection connection = ds.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            String zip = rs.getString("ZIP");
                            product = new Product();//Initialisation de customer avec les clé (primaires et etrengère)
                            product.setProduct_id(rs.getInt("PRODUCT_ID"));
                            product.setManufacturer_id(rs.getInt("MANUFACTURER_ID"));
                            product.setProduct_code(rs.getString("PRODUCT_CODE"));
                            product.setPurchase_cost(rs.getFloat("PURCHASE_COST"));
                            product.setQuantity_on_hand(rs.getInt("QUANTIITY_ON_HAND"));
                            product.setMarkup(rs.getFloat("MARKUP"));
                            product.setAvailable(rs.getString("AVAILABLE"));
                            product.setDescription(rs.getString("DESCRIPTION"));
                            
                            
			}
		}
        return product;
        
    }
    
    public void modifProduit(Product product){
        
    }
    
    public boolean createProduct(Product product) throws SQLException{
        String sql = "INSERT INTO APP.PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection connection = ds.getConnection();
               PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, product.getProduct_id());
            stmt.setInt(2, product.getManufacturer_id());
            stmt.setString(3, product.getProduct_code());
            stmt.setDouble(4, product.getPurchase_cost());
            stmt.setInt(5, product.getQuantity_on_hand());
            stmt.setDouble(6, product.getMarkup());
            stmt.setString(7, product.getAvailable());
            stmt.setString(8, product.getDescription());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex){
            return false;
        }
        
    }
    
    
    
    public boolean removeProduct(int product_id) throws SQLException{
        String sql = "UPDATE PRODUCT SET PRODUCT.AVAILABLE= 'FALSE', PRODUCT.QUANTITY_ON_HAND = 0 WHERE PRODUCT_ID="+product_id;
        
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            
            stmt.execute();

            return true;
        } catch (Exception ex){
            return false;
        }
        
        
    }
    	//PRODUCT_ID INTEGER NOT NULL,
	//MANUFACTURER_ID INTEGER NOT NULL,
	//PRODUCT_CODE CHAR(2) NOT NULL,
	//PURCHASE_COST DECIMAL(12,2),
	//QUANTITY_ON_HAND INTEGER,
	//MARKUP DECIMAL(4,2),
	//AVAILABLE VARCHAR(5),
	//DESCRIPTION VARCHAR(50),
    
}
