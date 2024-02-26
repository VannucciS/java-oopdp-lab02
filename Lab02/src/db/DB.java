package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import exceptions.CreateException;

public class DB {
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection == null) {			
			try {
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
				connection = DriverManager.getConnection(url,properties);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CreateException(e.getMessage());
			}			
		}
		return connection;
	}
	
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new CreateException(e.getMessage());
			}			
		}		
	}
	
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new CreateException(e.getMessage());
		}
	}

}
