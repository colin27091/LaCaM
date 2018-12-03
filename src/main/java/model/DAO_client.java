package model;

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
    
    public void createClient(Customer customer){
        
    }
    
}
