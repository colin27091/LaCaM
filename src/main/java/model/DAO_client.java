package model;

import javax.sql.DataSource;
import model.tables.Customer;

public class DAO_client {
    
    private final DataSource ds;
    private Customer customer;

    
    public DAO_client(DataSource dataSource, Customer customer) {
    
        this.ds = dataSource;
        this.customer = customer;
        
    }
    
}
