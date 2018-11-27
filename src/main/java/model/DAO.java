package model;

import model.tables.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

public class DAO {
    
    private final DataSource ds;
    
    
    
    

    public DAO(DataSource dataSource) {
    
        this.ds = dataSource;
    }
    
    public Customer getCustomer(int customer_id){
        return new Customer(0,' '," ");
    }
    
    
    
    
    
    
}
