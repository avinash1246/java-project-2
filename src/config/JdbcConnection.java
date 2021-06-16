package config;
import java.sql.*;

public class JdbcConnection {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		
		//DataBase information
	/*	String url="jdbc:h2:tcp://localhost/~/test";
		String username="sa";
		String password=""; */
		//Loading Driver
		Class.forName("org.h2.Driver");
		Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		return conn;
	}

}