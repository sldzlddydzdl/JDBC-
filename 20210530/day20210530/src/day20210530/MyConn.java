package day20210530;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConn {
	// 커넥션을 가져오는 클래스
	
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		
		// 이 부분은 인터넷으로 찾아서 할 수 있으면 됨 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// url, user, password
		String url = "jdbc:mysql://localhost:3306/mega?characterEncoding=utf-8&"
				+ "severTimezone=Asia/Seoul";
		
		String user = "root";
		String pw = "1234";
		
		return DriverManager.getConnection(url, user, pw);
	}
	
}
