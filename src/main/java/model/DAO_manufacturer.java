package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.tables.Manufacturer;

public class DAO_manufacturer {
    
    
    private final DataSource ds;
    
    
    public DAO_manufacturer(DataSource dataSource){
        this.ds = dataSource;
    }
    
    
    public List<Manufacturer> getManufacturers() throws SQLException{
        List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        String sql = "SELECT * FROM MANUFACTURER";
        
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Manufacturer m = new Manufacturer();
                m.setManufacturer_id(rs.getInt("manufacturer_id"));
                m.setName(rs.getString("name"));
                m.setAddressline1(rs.getString("addressline1"));
                m.setAddressline2(rs.getString("addressline2"));
                m.setCity(rs.getString("city"));
                m.setState(rs.getString("city"));
                m.setZip(rs.getString("zip"));
                m.setPhone(rs.getString("phone"));
                m.setFax(rs.getString("fax"));
                m.setEmail(rs.getString("email"));
                m.setRep(rs.getString("rep"));
                
                manufacturers.add(m);  
            }
            
        } catch (Exception ex){
            System.out.println(ex);
        }
        
        
        return manufacturers;
    }
    
    
    
}
