package day0523_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection Conn() throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
			String user = "root";
			String pw = "1234";
		
			String url = "jdbc:mysql://localhost:3306/mega?characterEncoding=utf-8&serverTimezone=Asia/Seoul";
		
			return DriverManager.getConnection(url, user , pw);
		
	}
	
}
