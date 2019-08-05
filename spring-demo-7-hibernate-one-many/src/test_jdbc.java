

import java.sql.Connection;
import java.sql.DriverManager;

public class test_jdbc {
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		String user ="student";
		String password="student";
		
		try {
			System.out.println("Connecting to database: "+ jdbcUrl);
			Connection myCon = DriverManager.getConnection(jdbcUrl, user, password); 	 
			System.out.println("Connection Successful!");
		}
		catch(Exception exec) {
			exec.printStackTrace();
		}
	}
}
