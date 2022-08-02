package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import Other.Error;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ConnectionDatabase {
	public Connection connection;
	private static Connection instance = null;
	private static Error error=null;

	public ConnectionDatabase() {
		
	}
	

	public static Connection getConnection(){
	   Connection conn=null;
		try{ 
			
			Context ctx = new InitialContext();
		    Context env = (Context) ctx.lookup("java:comp/env");
		    final String connectionString = (String) env.lookup("connectionString");
		    final String username = (String) env.lookup("dbUser");
		    final String pwd = (String) env.lookup("dbPassword");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					connectionString,
					username,
					pwd);
		}
		catch (Exception ex) {
			error=Error.DATABASE_CONNECTION_ERROR;
			error.setDescription("Connection to database failed");
		}
		return  conn;
	}


	public static Error getError() {
		return error;
	}
}
