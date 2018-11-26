/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.DAO;
import model.DataSourceFactory;

/**
 * Web application lifecycle listener.
 *
 * @author c
 */
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (!databaseExists()) {
			initializeDatabase();
		}
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }

    private boolean databaseExists(){
        boolean result = false;

	DAO dao = new DAO(DataSourceFactory.getDataSource());
        Logger.getLogger("DiscountEditor").log(Level.INFO, "Database already exists");
        result = true;
	return result;
    }

    private void initializeDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
