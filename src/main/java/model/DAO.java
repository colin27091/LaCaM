package model;

import javax.sql.DataSource;

public class DAO {
    
    private final DataSource ds;
    

    public DAO(DataSource dataSource) {
        this.ds = dataSource;
    }
    
}
