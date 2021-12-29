package org.sai.servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
// This class can be used to initialize the database connection
public class DatabaseConnection {
    public  static Connection initializeDatabase()
      //  throws SQLException, ClassNotFoundException
    {
    	try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}  
    	Connection con = null; 
    	try {
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Fassak@08");
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return con;
    }
}