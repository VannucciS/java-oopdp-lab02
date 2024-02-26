package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DB.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from indywinners");
		
		
		while(rs.next()) {
			String name = rs.getString("driver");
			Integer year = rs.getInt("year");
			Double avgspeed = rs.getDouble("avgspeed");
			
			System.out.println(name + " , " + year + " " + avgspeed );
		}
		
		DB.closeConnection();
		

	}

}
