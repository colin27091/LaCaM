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
import java.util.List;
import javax.sql.DataSource;
import model.tables.Product;

public class DAO_product {
    
    private final DataSource ds;
    
    public DAO_product(DataSource dataSource) {
        this.ds = dataSource;
    }
    
    public List<Product> getProducts() throws SQLException{
        List<Product> products = null;
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
        }
	
        return products;
    }
    
    public void addProduct(Product product){
        String sql = "";
    }
    
}
