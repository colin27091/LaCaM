package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class DAO {
    
    private final DataSource ds;
    

    public DAO(DataSource dataSource) {
        System.out.println("DAO appelé");
        this.ds = dataSource;
    }
    
    
    public void getCapital() throws SQLException{
        List<String> capitale = new ArrayList<String>();
        String sql = "SELECT * FROM PAYS";
        try (Connection connection = ds.getConnection(); 
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("PAYS_NOM"));
            }
	}
    }
    
    
    
    
}
