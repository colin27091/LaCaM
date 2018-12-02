package model;

import javax.sql.DataSource;
import model.tables.Customer;

public class DAO_client {
    
    private final DataSource ds;

    
    public DAO_client(DataSource dataSource) {
        this.ds = dataSource;
    }
    
}
